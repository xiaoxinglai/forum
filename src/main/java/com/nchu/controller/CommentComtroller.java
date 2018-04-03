package com.nchu.controller;

import com.google.gson.Gson;
import com.nchu.domain.DO.Comment;
import com.nchu.domain.DO.Option;
import com.nchu.domain.DO.User;
import com.nchu.domain.DO.UserOption;
import com.nchu.domain.VO.PageResult;
import com.nchu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user12 on 2018/3/2.
 */
@Controller
@RequestMapping("/comment")
public class CommentComtroller {

    private Gson gson=new Gson();
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ICommentService commentService;


    @PostMapping("/submit")
    public String submit(Comment comment, HttpSession session, Model model){

        User user=(User)session.getAttribute("User");
        comment.setBadNum(0L);
        comment.setGoodNum(0L);
        comment.setPersonId(user.getuId());
        comment.setPersonName(user.getuName());
        comment.setTime(new Date());

        if (commentService.SubmitComment(comment)){
            return "redirect:/question/detail/"+comment.getQuestionId();
        }else {
            return "redirect:/error";
        }


    }

    @GetMapping(value = "/ajax/delete")
    @ResponseBody
    public Object delete(@RequestParam(value = "commentId", required=false) Long commentId,HttpSession session) {

        User user= (User)session.getAttribute("User");
        if (ObjectUtils.isEmpty(user)){
            return -1L;
        }


        return  commentService.deleteBycommentId(commentId,user.getuId());

    }



    @GetMapping(value = "/ajaxList")
    @ResponseBody
    public Object ajaxlist(@RequestParam(value = "questionId", required=false) Long questionId, @RequestParam(value = "currPage", required=false) Integer currPage) {

        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=commentService.selectCommentByQuestionId(questionId,currPage);
        return pageResult;

    }

    @GetMapping(value = "/ajax/GoodOrBad")
    @ResponseBody
    public Long ajaxgoodOrBad(@RequestParam(value = "commentId") Long commentId, @RequestParam(value = "op") Integer key,@RequestParam(value = "num",required = false) Long Num,HttpSession session) {


        User user= (User)session.getAttribute("User");
        if (ObjectUtils.isEmpty(user)){
            return -1L;
        }

        String redis=stringRedisTemplate.opsForValue().get("c"+user.getuId().toString());
        if (StringUtils.isEmpty(redis)){
            //说明没有缓存 该用户没有点过赞也没有给过差评
            UserOption userOption=new UserOption();
            if (key==1){
                Num++;
                userOption.setGood(1);
            }else {
                userOption.setBad(1);
                Num++;
            }


            Map<Long,UserOption> commentIdAndUserOption=new HashMap<>();
            commentIdAndUserOption.put(commentId,userOption);
            Option option=new Option();
            option.setUserOptionMap(commentIdAndUserOption);


            String object=gson.toJson(option);

            stringRedisTemplate.opsForValue().set("c"+user.getuId().toString(),object);


            //key=1为点赞  0为差评
            Long result =commentService.CommentGoodOrBad(commentId,key,Num);

            return result;

        }else{

            Option map=gson.fromJson(redis, Option.class);
            UserOption userOption=map.getUserOptionMap().get(commentId);
            if (ObjectUtils.isEmpty(userOption)){  //说明用户没有对这个问题进行过点赞或者差评操作
                UserOption option=new UserOption();
                if (key==1){
                    Num++;
                    option.setGood(1);
                }else {
                    option.setBad(1);
                    Num++;
                }

                map.getUserOptionMap().put(commentId,option);
                String object1= gson.toJson(map);

                stringRedisTemplate.opsForValue().set("c"+user.getuId().toString(),object1);
                //key=1为点赞  0为差评
                Long result =commentService.CommentGoodOrBad(commentId,key,Num);

                return result;

            }else{

                if (key==0&&userOption.getBad()==1){

                    userOption.setBad(0);
                    map.getUserOptionMap().put(commentId,userOption);
                    String object2= gson.toJson(map);

                    stringRedisTemplate.opsForValue().set("c"+user.getuId().toString(),object2);



                    Long result =commentService.CommentGoodOrBad(commentId,key,--Num);

                    return result;
                }

                if (key==1&&userOption.getGood()==1){

                    userOption.setGood(0);
                    map.getUserOptionMap().put(commentId,userOption);
                    String object2= gson.toJson(map);

                    stringRedisTemplate.opsForValue().set("c"+user.getuId().toString(),object2);

                    Long result =commentService.CommentGoodOrBad(commentId,key,--Num);

                    return result;
                }


                if (key==1){
                    userOption.setGood(1);

                }else {

                    userOption.setBad(1);
                }


                map.getUserOptionMap().put(commentId,userOption);
                String object2= gson.toJson(map);

                stringRedisTemplate.opsForValue().set("c"+user.getuId().toString(),object2);


                Long result =commentService.CommentGoodOrBad(commentId,key,Num+1);



                return result;

            }




        }


    }














}

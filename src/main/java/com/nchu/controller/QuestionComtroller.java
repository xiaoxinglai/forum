package com.nchu.controller;

/**
 * Created by user12 on 2018/2/26.
 */

import com.google.gson.Gson;
import com.nchu.domain.DO.Option;
import com.nchu.domain.DO.Question;
import com.nchu.domain.DO.User;
import com.nchu.domain.DO.UserOption;
import com.nchu.domain.Form.QuestionForm;
import com.nchu.domain.VO.PageResult;
import com.nchu.service.IQuestionService;
import com.nchu.service.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionComtroller {


    private Gson gson=new Gson();
    @Autowired
    private IQuestionService questionService;

    @Autowired
    private WebSocket webSocket;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 处理问题提交
     * @param questionForm
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@Valid QuestionForm questionForm, BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getDefaultMessage());
            }

            model.addAttribute("QuestionForm", questionForm);
            model.addAttribute("result", result);
            return  "/submit";
        } else {
            User user = (User) session.getAttribute("User");
            Long id=questionService.InsertQuestion(questionForm,user);
            webSocket.sendMessage(user.getuName()+"提问了问题： "+questionForm.getTitle());
            if (id>0) {
                return "redirect:/question/detail/"+id;
            }else {
                return null;
            }

        }


    }


    @GetMapping(value = "/detail/{questionId}")
    public String question(@PathVariable("questionId") Long questionId,Model model) {
        Question question=questionService.selectByPrimaryKey(questionId);
        model.addAttribute("question",question);

        return "question";
    }



    @GetMapping(value = "/list")
    public String list(@RequestParam(value = "courseId", required=false) Long courseId,Model model) {

         model.addAttribute("courseId",courseId);
        return "list";

    }
    @GetMapping(value = "/ajaxList")
    @ResponseBody
    public Object ajaxlist(@RequestParam(value = "courseId", required=false) Long courseId,@RequestParam(value = "level", required=false) Long level,@RequestParam(value = "currPage", required=false) Integer currPage,Model model) {


        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=questionService.selectQuestionByCourseIdAndLevel(courseId,level,currPage);
        return pageResult;

    }

    @GetMapping(value = "/ajaxList/MyQuestion")
    @ResponseBody
    public Object MyQuestion(@RequestParam(value = "UID", required=false) Long UID,@RequestParam(value = "currPage", required=false) Integer currPage) {


        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=questionService.selectQuestionByUID(UID,currPage);
        return pageResult;

    }
    @GetMapping(value = "/cream/ajaxList")
    @ResponseBody
    public Object ajaxlistCream(@RequestParam(value = "currPage", required=false) Integer currPage) {


        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=questionService.isCreamQuetion(currPage);
        return pageResult;

    }

    @GetMapping(value = "/Course/cream/ajaxList")
    @ResponseBody
    public Object ajaxlistCourseCream(@RequestParam(value = "courseId") Long courseId,@RequestParam(value = "currPage") Integer currPage) {


        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=questionService.isCreamCourseQuetion(courseId,currPage);
        return pageResult;

    }


    @GetMapping(value = "/hotQuestion/ajaxList")
    @ResponseBody
    public Object hotQuestion(@RequestParam(value = "currPage", required=false) Integer currPage) {


        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=questionService.newQuetionAll(currPage);
        return pageResult;

    }


    @GetMapping(value = "/searcher")
    public String searcher(@RequestParam(value = "key") String key,Model model) {
        model.addAttribute("key",key);
        return "searcherList";

    }

    @GetMapping(value = "/ajaxsearcher")
    @ResponseBody
    public Object ajaxSearcher(@RequestParam(value = "key") String key, @RequestParam(value = "currentPage",required=false) Integer currentPage,Model model) {



        if (ObjectUtils.isEmpty(currentPage)){
            currentPage=1;
        }
        PageResult pageResult=questionService.questionSearcher(key,currentPage);

        return pageResult;

    }

    @GetMapping(value = "/ajax/GoodOrBad")
    @ResponseBody
    public Long ajaxgoodOrBad(@RequestParam(value = "questionId") Long questionId, @RequestParam(value = "key") Integer key,@RequestParam(value = "goodNum",required = false) Long goodNum,@RequestParam(value = "badNum",required = false) Long badNum,HttpSession session) {


        User user= (User)session.getAttribute("User");
        if (ObjectUtils.isEmpty(user)){
            return -1L;
        }

        String redis=stringRedisTemplate.opsForValue().get(user.getuId().toString());
        if (StringUtils.isEmpty(redis)){
            //说明没有缓存 该用户没有点过赞也没有给过差评
            UserOption userOption=new UserOption();
            if (key==1){
                goodNum++;
                userOption.setGood(1);
            }else {
                userOption.setBad(1);
                badNum++;
            }


            Map<Long,UserOption> questionIdAndUserOption=new HashMap<>();
            questionIdAndUserOption.put(questionId,userOption);
            Option option=new Option();
            option.setUserOptionMap(questionIdAndUserOption);


            String object=gson.toJson(option);

            stringRedisTemplate.opsForValue().set(user.getuId().toString(),object);


            //key=1为点赞  0为差评
            Long result =questionService.questionGoodOrBad(questionId,key,goodNum,badNum);

            return result;

        }else{

            Option map=gson.fromJson(redis, Option.class);
            UserOption userOption=map.getUserOptionMap().get(questionId);
            if (ObjectUtils.isEmpty(userOption)){  //说明用户没有对这个问题进行过点赞或者差评操作
                UserOption option=new UserOption();
                if (key==1){
                    goodNum++;
                    option.setGood(1);
                }else {
                    option.setBad(1);
                    badNum++;
                }

                map.getUserOptionMap().put(questionId,option);
                String object1= gson.toJson(map);

                stringRedisTemplate.opsForValue().set(user.getuId().toString(),object1);
                //key=1为点赞  0为差评
                Long result =questionService.questionGoodOrBad(questionId,key,goodNum,badNum);

                return result;

            }else{

                if (key==0&&userOption.getBad()==1){

                    userOption.setBad(0);
                    map.getUserOptionMap().put(questionId,userOption);
                    String object2= gson.toJson(map);

                    stringRedisTemplate.opsForValue().set(user.getuId().toString(),object2);



                    Long result =questionService.questionGoodOrBad(questionId,key,goodNum,badNum-1);

                    return result;
                }

                if (key==1&&userOption.getGood()==1){

                    userOption.setGood(0);
                    map.getUserOptionMap().put(questionId,userOption);
                    String object2= gson.toJson(map);

                    stringRedisTemplate.opsForValue().set(user.getuId().toString(),object2);

                    Long result =questionService.questionGoodOrBad(questionId,key,goodNum-1,badNum);

                    return result;
                }


                if (key==1){
                    userOption.setGood(1);
                    goodNum++;
                }else {
                    badNum++;
                    userOption.setBad(1);
                }


                map.getUserOptionMap().put(questionId,userOption);
                String object2= gson.toJson(map);

                stringRedisTemplate.opsForValue().set(user.getuId().toString(),object2);


                Long result =questionService.questionGoodOrBad(questionId,key,goodNum,badNum);



                return result;

            }




        }


    }



    @GetMapping(value ="/delete")
    public String delete(@RequestParam("questionId") Long questionId){
          if (questionService.deletequestion(questionId)){
              //todo 这里要传当前第几页过去
              return  "redirect:/admin";
          }else {
              return "redirect:/error";
          }

    }


    @GetMapping(value = "/test")
    public String list(){

        return "PaginatorTest";

    }


}



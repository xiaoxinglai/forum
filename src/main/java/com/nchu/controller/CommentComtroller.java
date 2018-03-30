package com.nchu.controller;

import com.nchu.domain.DO.Comment;
import com.nchu.domain.DO.User;
import com.nchu.domain.VO.PageResult;
import com.nchu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by user12 on 2018/3/2.
 */
@Controller
@RequestMapping("/comment")
public class CommentComtroller {

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

    @GetMapping(value = "/ajaxList")
    @ResponseBody
    public Object ajaxlist(@RequestParam(value = "questionId", required=false) Long questionId, @RequestParam(value = "currPage", required=false) Integer currPage) {

        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=commentService.selectCommentByQuestionId(questionId,currPage);
        return pageResult;

    }














}

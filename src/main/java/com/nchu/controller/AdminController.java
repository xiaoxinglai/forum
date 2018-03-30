package com.nchu.controller;

import com.nchu.domain.DO.Question;
import com.nchu.domain.DO.User;
import com.nchu.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by user12 on 2018/3/1.
 */
@Controller
public class AdminController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping(value = "/admin")
    public String admin() {

        //todo 要鉴权
        return "admin/admin";
    }

    @GetMapping(value = "/edit")
    public String adminquestion(@RequestParam("questionId") Long questionId, Model model) {

        Question question = questionService.selectByPrimaryKey(questionId);
        model.addAttribute("question", question);

        return "admin/question";
    }

    @PostMapping(value = "/doEdit")
    public String adminquestion(Question question, HttpSession session) {

        question.setIsResource(Boolean.TRUE);
        User user = (User) session.getAttribute("User");
        question.setTecherId(user.getuId());
        question.setTecherName(user.getuName());

        if (questionService.EditQuestion(question)) {
            return "redirect:question/detail/" + question.getQuestionId();
        } else {

            return "redirect:/error";
        }


    }


    @GetMapping(value = "/addCream")
    public String addCream(@RequestParam("questionId") Long questionId,@RequestParam("current") Integer current) {

        Question question=new Question();
        question.setQuestionId(questionId);
        question.setIsCream(Boolean.TRUE);
        questionService.creamQuestion(question);


        return "redirect:/admin?current="+current;
    }

    @GetMapping(value = "/CanceCream")
    public String CanceCream(@RequestParam("questionId") Long questionId,@RequestParam("current") Integer current) {

        Question question=new Question();
        question.setQuestionId(questionId);
        question.setIsCream(Boolean.FALSE);
        questionService.creamQuestion(question);

        return "redirect:/admin?current"+current;
    }

}

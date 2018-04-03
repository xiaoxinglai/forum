package com.nchu.controller;

import com.nchu.domain.DO.Account;
import com.nchu.domain.DO.User;
import com.nchu.domain.Form.QuestionForm;
import com.nchu.domain.Form.UserForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by user12 on 2018/2/3.
 */

@Controller
public class PageSkipComtroller {



    @GetMapping(value ="/login")
    public String login(@ModelAttribute Account account, BindingResult result, Model model){
        model.addAttribute("Account",account);
        model.addAttribute("result",result);
        return "admin/login";
    }

    @GetMapping(value ="/sign")
    public String sign(@ModelAttribute UserForm user, BindingResult result, Model model){

      model.addAttribute("UserForm",user);
      model.addAttribute("result",result);
        return "admin/sign";
    }

    @GetMapping(value = "/index")
    public String index() {

        return "index";
    }

    @GetMapping(value = "/userList")
    public String userList(HttpSession session, Model model) {
        User user= (User) session.getAttribute("User");
        model.addAttribute("UID",  user.getuId());

        return "UserQuestionlist";
    }
    @GetMapping(value = "/CreamList")
    public String CreamQuestionlist() {

        return "CreamQuestionlist";
    }



    @GetMapping(value = "/submit")
    public String submit(@Param("courseId") Long courseId,@ModelAttribute QuestionForm questionForm, BindingResult result, Model model) {
        questionForm.setCourseId(courseId);
        model.addAttribute("QuestionForm",questionForm);
        model.addAttribute("result",result);

        return "submit";
    }


    @GetMapping(value = "/fenlei")
    public String fenlei() {
        return "admin/fenlei";
    }

    @GetMapping(value = "/gonggao")
    public String gonggao() {
        return "admin/gonggao";
    }



    @GetMapping(value = "/websocket")
    public String websocket() {

        return "fragment/websocket";
    }
}

package com.nchu.controller;

import com.nchu.domain.DO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by user12 on 2018/2/3.
 */

@Controller
public class PageSkipComtroller {

    @GetMapping(value ="/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping(value ="/sign")
    public String sign(@ModelAttribute User user, BindingResult result, Model model){

      model.addAttribute("User",user);
      model.addAttribute("result",result);
        return "admin/sign";
    }

    @GetMapping(value = "/index")
    public String index() {

        return "index";
    }

    @GetMapping(value = "/list")
    public String list() {
        return "list";

    }

    @GetMapping(value = "/question")
    public String question() {
        return "question";
    }

    @GetMapping(value = "/submit")
    public String submit() {
        return "submit";
    }


    @GetMapping(value = "/admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping(value = "/fenlei")
    public String fenlei() {
        return "admin/fenlei";
    }

    @GetMapping(value = "/gonggao")
    public String gonggao() {
        return "admin/gonggao";
    }

    @GetMapping(value = "/adminquestion")
    public String adminquestion() {

        return "admin/question";
    }

    @GetMapping(value = "/websocket")
    public String websocket() {

        return "fragment/websocket";
    }
}

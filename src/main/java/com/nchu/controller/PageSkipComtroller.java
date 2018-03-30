package com.nchu.controller;

import com.nchu.domain.DO.Account;
import com.nchu.domain.Form.QuestionForm;
import com.nchu.domain.Form.UserForm;
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





    @GetMapping(value = "/submit")
    public String submit(@ModelAttribute QuestionForm questionForm, BindingResult result, Model model) {
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

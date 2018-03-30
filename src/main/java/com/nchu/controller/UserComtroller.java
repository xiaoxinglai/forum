package com.nchu.controller;

import com.nchu.domain.DO.Account;
import com.nchu.domain.DO.User;
import com.nchu.domain.Form.UserForm;
import com.nchu.enums.UserEnum;
import com.nchu.result.BizResult;
import com.nchu.service.IUserService;
import com.nchu.service.WebSocket;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

//import com.nchu.service.userService;

/**
 * @author laixiaoxing
 * Created by user12 on 2017/12/11.
 */

@Controller
public class UserComtroller {

    @Autowired
    private IUserService userService;


     @Autowired
    private WebSocket webSocket;

    /**
     * webSocket测试
     * @param Id
     */
    @RequestMapping(value = "/webSocket/{Id}",method = RequestMethod.GET)
    public void webSocket(@PathVariable("Id") Long Id){
        webSocket.sendMessage("查询了id");
    }


    /**
     * 处理注册
     * @param userForm
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/doSign",method = RequestMethod.POST)
    public String doSign(@Valid UserForm userForm, BindingResult result, Model model){

        if (!userForm.getPassword().equals(userForm.getRepassword())){
            model.addAttribute("UserForm",userForm);
            model.addAttribute("result",result);
            model.addAttribute("msg","两次密码不一致");
            return "admin/sign";
        }


        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getDefaultMessage());
            }

            model.addAttribute("UserForm",userForm);
            model.addAttribute("result",result);
            return "admin/sign";
        }

        User user=new User(userForm.getuId(),userForm.getCollege(),userForm.getGender(),userForm.getPermission(),userForm.getSignDate(),userForm.getTag(),userForm.getuName(),userForm.getuNo(),userForm.getDetail(),userForm.getPassword());

        BizResult bizResult=userService.doSign(user);
        if (bizResult.getSuccess()){

            return "redirect:/login";
        }else {
            model.addAttribute("UserForm",userForm);
            model.addAttribute("result",result);
            model.addAttribute("msg",bizResult.getMsg());
          return "admin/sign";
        }
    }

    /**
     *处理登录
     * @param account
     * @param result
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(@Valid Account account, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getDefaultMessage());
            }

            model.addAttribute("Account",account);
            model.addAttribute("result",result);
            return "admin/login";
        }else {

            BizResult<User> bizResult=userService.doLogin(account);
            if (bizResult.getSuccess()){
                session.setAttribute("User",bizResult.getDate());
                User user=bizResult.getDate();
                if (user.getTag().equals(UserEnum.TECHER.getCode())){

                    return "redirect:/admin";
                }else if (user.getTag().equals(UserEnum.STUDENT.getCode())){
                    return "redirect:/index";
                }else {
                    return "redirect:/admin";
                }

            }else {
                String msg=bizResult.getMsg();
                System.out.println("校验失败");
                model.addAttribute("Account",account);
                model.addAttribute("result",result);
                model.addAttribute("msg",msg);
                return "admin/login";
            }

        }



    }


    /**
     * 导出excel
     * @param response
     * @throws IOException
     * @throws WriteException
     */
    @GetMapping(value = "excel")
    public void excel(HttpServletResponse response) throws IOException, WriteException {

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=car_test.xls");
        ServletOutputStream out=response.getOutputStream();


        //创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(out);

        //创建sheet
        WritableSheet sheet=workbook.createSheet("sheet1",0);

        //单元格
        Label label=null;

        //数组存表头
        String[] title={"id","name","sex"};

        //设置列名
        for(int i=0;i<title.length;i++){
            label=new Label(i,0,title[i]);
            sheet.addCell(label);

        }

        for(int i=1;i<10;i++){
            //第一列  new Label(0,i,"a");    0是列   i是行
            label =new Label(0,i,"a");
            sheet.addCell(label);
            //第二列
            label =new Label(1,i,"user");
            sheet.addCell(label);
            //第三列
            label =new Label(2,i,"男");
            sheet.addCell(label);

        }

        //写入数据
        workbook.write();
        workbook.close();
        out.flush();
        out.close();


    }



}

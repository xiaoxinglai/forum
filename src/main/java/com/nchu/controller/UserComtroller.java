package com.nchu.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.nchu.domain.DO.User;
import com.nchu.mapper.UserMapper;
import com.nchu.result.BizResult;
import com.nchu.service.IUserService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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
    private UserMapper userMapper;
//     @Autowired
//    private WebSocket webSocket;
//
//    @RequestMapping(value = "/questionMapperId/{Id}",method = RequestMethod.GET)
//    @ResponseBody
//    public Question getquestionMapperId(@PathVariable("Id") Long Id){
//        webSocket.sendMessage("查询了id");
//        return null; //questionMapper.selectByPrimaryKey(Id);
//
//
//    }
//

    @RequestMapping(value = "/userMapper/{uId}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserMapperById(@PathVariable("uId") Long uId){
        return userMapper.selectByPrimaryKey(uId);


    }

    @RequestMapping(value = "/doSign",method = RequestMethod.POST)
    public String getUserMapperById(@Valid User user,BindingResult result,Model model){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getDefaultMessage());
            }
            System.out.println(result.getFieldError().getDefaultMessage());
          //  System.out.println(result.getFieldError("uNo").getDefaultMessage());
            System.out.println("校验失败");
            model.addAttribute("User",user);
            model.addAttribute("result",result);
            return "admin/sign";
        }


        BizResult bizResult=userService.doSign(user);
        if (bizResult.getSuccess()){
            return "admin/login";
        }else {
            model.addAttribute("User",user);
            model.addAttribute("result",result);
            model.addAttribute("msg",bizResult.getMsg());
          return "admin/sign";
        }
    }




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

package com.nchu.controller;

import com.nchu.Utils.ResultUtil;
import com.nchu.domain.DO.Question;
import com.nchu.domain.DO.User;
import com.nchu.domain.Result.Result;
import com.nchu.enums.ResultEnum;
import com.nchu.mapper.QuestionMapper;
import com.nchu.mapper.UserMapper;
//import com.nchu.service.userService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laixiaoxing
 * Created by user12 on 2017/12/11.
 */

@Controller
public class UserComtroller {

//    @Autowired
//    private userService userService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @RequestMapping(value = "/questionMapperId/{Id}",method = RequestMethod.GET)
    @ResponseBody
    public Question getquestionMapperId(@PathVariable("Id") Long Id){
        return questionMapper.selectByPrimaryKey(Id);


    }


    @RequestMapping(value = "/userMapper/{uId}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserMapperById(@PathVariable("uId") Long uId){
        return userMapper.selectUserById(uId);


    }


    @GetMapping(value = "/students/{uNo}")
    @ResponseBody
    public List<User> getUserAllForuNo(@PathVariable("uNo") Long uNo) {

        return  null;// userService.getUserOne(uNo);

    }

    @PostMapping(value = "/sign")
    @ResponseBody
    public Result<User> insertUser(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());

            return ResultUtil.error(ResultEnum.SNO_NULL_ERROR.getCode(), ResultEnum.SNO_NULL_ERROR.getMsg());

        }


        List<User> data = new ArrayList<>();

      //  data.add(userService.sign(user));


        return ResultUtil.success(data);

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

}

package com.nchu.controller;

import com.nchu.domain.DO.Course;
import com.nchu.domain.VO.PageResult;
import com.nchu.mapper.CourseMapper;
import com.nchu.service.imp.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * Created by user12 on 2018/3/16.
 */
@Controller
public class CourseComtroller {
    @Value("${web.upload-path}")
    private String path;

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseService courseService;



    @GetMapping("admin/courseAdd")
    public  String skipCorseAdd(){

        return "admin/courseAdd";
    }

    /**
     * 多文件多字段提交
     * @param request
     * @return
     */
    @RequestMapping(value = "/course/upload",method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request){

        MultipartHttpServletRequest params=(MultipartHttpServletRequest)request;

        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");

        String title=params.getParameter("title");

        Long time= LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

        MultipartFile file = null;
        BufferedOutputStream stream = null;

        for (int i = 0; i < files.size(); ++i) {

            file = files.get(i);
            if (file.getContentType().equals("image/png") || file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/jpg")) {

                if (!file.isEmpty()) {
                    try {
                        String fileName = time.toString() + file.getOriginalFilename();

                        String url = path + fileName;
                        Course course=new Course();
                        String imgUrl="/uploadImg/"+fileName;
                        course.setImgPath(imgUrl);
                        course.setTitle(title);
                       if (courseMapper.insert(course)==0){
                           return "数据写入数据库失败";
                       }

                        byte[] bytes = file.getBytes();
                        stream = new BufferedOutputStream(new FileOutputStream(
                                new File(url)));
                        stream.write(bytes);
                        stream.close();
                    } catch (Exception e) {
                        stream = null;
                        return "You failed to upload " + i + " => "
                                + e.getMessage();
                    }
                } else {
                    return "You failed to upload " + i
                            + " because the file was empty.";
                }
            }else{
                return "图片格式必须为png,jpeg,jpg";
            }
        }
        return "upload successful";
    }

    @GetMapping(value = "/course/ajaxList")
    @ResponseBody
    public Object ajaxlist(@RequestParam(value = "currPage", required=false) Integer currPage, Model model) {

        if (ObjectUtils.isEmpty(currPage)){
            currPage=1;
        }

        PageResult pageResult=courseService.selectQuestionByCourseIdAndLevel(currPage);
        return pageResult;

    }

    @GetMapping(value = "/course/del")
    @ResponseBody
    public Object del(@RequestParam(value = "num", required=false) Integer num) {


        if (courseMapper.deleteByPrimaryKey(num.longValue())>0)
        {
            return "删除成功！";
        }else {
            return "删除失败！";
        }

    }

}

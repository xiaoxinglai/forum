package com.nchu.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * Created by user12 on 2018/2/27.
 */
@Controller
public class UploadComtroller {


    @Value("${web.upload-path}")
    private String path;

    @GetMapping("/uploadTest")
    public String uploadTest(){

        return "uploadTest";
    }

    /**
     * 单个文件
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file){

        if (!file.isEmpty()){
            Long time= LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
            String fileName=time.toString()+file.getOriginalFilename();
            try {

                String url=path+fileName;
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(url)));

                out.write(file.getBytes());

                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "/uploadImg/"+fileName;
        }else {
            return "上传失败，因为文件是空的.";
        }


    }


    /**
     * 多文件多字段提交
     * @param request
     * @return
     */
    @RequestMapping(value = "/batch/upload",method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request){

        MultipartHttpServletRequest params=(MultipartHttpServletRequest)request;

        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");

        String name=params.getParameter("name");
        System.out.println("name:"+name);
        String id=params.getParameter("id");
        System.out.println("id:"+id);

        MultipartFile file = null;
        BufferedOutputStream stream = null;

        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    System.out.println("file:"+file.getOriginalFilename());

                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("src/main/resources/static/img/"+file.getOriginalFilename())));
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
        }
        return "提交成功";
    }



}

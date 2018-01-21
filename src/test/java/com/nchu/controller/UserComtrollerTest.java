package com.nchu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.domain.DO.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by user12 on 2017/12/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserComtrollerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUserAllForuNo() throws Exception {

//测试接口
        System.out.println("测试接口");
        mvc.perform(MockMvcRequestBuilders.get("/students/14202116")) //模拟url
                .andExpect(MockMvcResultMatchers.status()
                        .isOk());

    }


    @Test
    public void insertUser() throws Exception {

        User user = new User();
        user.setuNo(12345678L);
        user.setGender("男");
        user.setuName("赖晓星");

        ObjectMapper mapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.post("/sign")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());



    }

}
package com.nchu.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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




}
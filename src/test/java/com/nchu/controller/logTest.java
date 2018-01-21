package com.nchu.controller;



import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by user12 on 2018/1/3.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Data
public class logTest {
    @Test
    public  void test(){
        log.debug("debug");  //默认级别是显示debug以上的
        log.info("info");
        log.error("error是生生世世");


    }
}

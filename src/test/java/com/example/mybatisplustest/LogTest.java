package com.example.mybatisplustest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName LogTest
 * @Description 日志测试类
 * @Author LiZijing
 * @Date 2021/8/29
 */
@SpringBootTest
@Slf4j
public class LogTest {
    @Test
    public void logTest(){
        log.info("this is a info log");
        log.warn("this is a warn log");
        log.error("this is a error log");
        log.debug("this is a debug log");
        log.trace("this is a trace log");
    }
}

package com.example.mybatisplustest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> value 注解 </p>
 *
 * @author LiZijing
 * @date 2022/1/23
 */
@RestController
@RequestMapping("/value")
public class ValueController {
    private static String staticStr;
    @Value("${value.int}")
    private int i;
    @Value("${value.float}")
    private float f;
    @Value("${value.str}")
    private String str;
    @Value("${value.null:default}")
    private String isNull;
    @Value("89")
    private int i1;
    @Value("567.8")
    private float f1;
    @Value("测试字符串")
    private String str1;

    @Value("${value.staticStr}")
    private void setStaticStr(String str) {
        staticStr = str;
    }

    @RequestMapping("/")
    public String value() {
        return i + "\n" + f + "\n" + str + "\n" + isNull + "\n" + i1 + "\n" + f1 + "\n" + str1 + "\n" + staticStr;
    }
}

package com.example.mybatisplustest;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p> Value 注解测试 </p>
 *
 * @author LiZijing
 * @date 2022/1/18
 */
public class ValueTest {
    @Autowired
    Values values;

    @Test
    public void value() {
        System.out.println(values);
    }
}
@Data
@Component
class Values{
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
    @Value("${systemEnvironment['os.name']}")
    private String osName;
}

package com.example.mybatisplustest.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> ApiJsonOpject 注解的实现 </p>
 *
 * @author LiZijing
 * @className ApiJsonObject
 * @date 2021/9/5
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiJsonObject {
    ApiJsonProperty[] value();

    String name();

    String paramType();
}

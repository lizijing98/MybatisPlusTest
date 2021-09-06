package com.example.mybatisplustest.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> ApiJsonProperty 注解的实现 </p>
 *
 * @author LiZijing
 * @className ApiJsonProperty
 * @date 2021/9/5
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiJsonProperty {
    String key();

    String example() default "";

    String type() default "String";

    String description() default "";

    String paramType() default "";

    boolean required() default false;
}

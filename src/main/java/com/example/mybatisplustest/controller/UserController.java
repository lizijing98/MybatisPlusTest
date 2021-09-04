package com.example.mybatisplustest.controller;


import com.example.mybatisplustest.entity.User;
import com.example.mybatisplustest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
@RestController
@RequestMapping("/user")
@Api("User")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/{username}")
    @ApiOperation(value = "get user by username", notes = "通过 username 获取 User 实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", value = "用户名", required = true, dataType = "String")
    })
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.findUserByUsername(username);
    }
}


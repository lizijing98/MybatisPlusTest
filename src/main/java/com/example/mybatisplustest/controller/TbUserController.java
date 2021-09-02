package com.example.mybatisplustest.controller;


import com.example.mybatisplustest.service.TbUserService;
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
 * @author LZJ
 * @since 2021-08-22
 */
@RestController
@RequestMapping("/user")
@Api("User Control")
public class TbUserController {

    @Resource
    TbUserService userService;

    @GetMapping("/{username}")
    @ApiOperation(value = "get user by username", notes = "通过 username 获取 User")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", value = "用户名", required = true, dataType = "String")
    })
    public Object getUserByUsername(@PathVariable("username") String username) {
        return userService.findUserByUsername(username);
    }
}


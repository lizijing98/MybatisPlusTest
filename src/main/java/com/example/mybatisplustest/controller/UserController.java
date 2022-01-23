package com.example.mybatisplustest.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplustest.entity.User;
import com.example.mybatisplustest.service.UserService;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "Bright query by list", notes = "通过列表进行模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", allowEmptyValue = true, example = "user"),
            @ApiImplicitParam(name = "phone", value = "手机号码", paramType = "query", allowEmptyValue = true, example = "133"),
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "query", allowEmptyValue = true, example = "xxx@xx.xx")
    })
    public List<User> getUserList(@ApiIgnore @RequestParam Map<String, Object> params) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (params.containsKey("username")) {
            wrapper.like(User::getUsername, params.get("username"));
        }
        if (params.containsKey("phone")) {
            wrapper.like(User::getPhone, params.get("phone"));
        }
        if (params.containsKey("email")) {
            wrapper.like(User::getEmail, params.get("email"));
        }
        return userService.selectList(wrapper);
    }

    @RequestMapping(value = "/v1/{username}", method = RequestMethod.GET)
    @ApiOperation(value = "get user by username", notes = "通过 username 获取 User 实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", value = "用户名", required = true, dataType = "String")
    })
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.findUserByUsername(username);// 这个会产生 NullPointException
    }

    @RequestMapping(value = "/v2/{username}", method = RequestMethod.GET)
    @ApiOperation(value = "get user by username", notes = "通过 username 获取 User 实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "path", value = "用户名", required = true, dataType = "String")
    })
    public User getUserByName(@PathVariable("username")String username){
        return userService.lambdaQuery()
                .eq(User::getUsername,username)
                .one();
    }


}


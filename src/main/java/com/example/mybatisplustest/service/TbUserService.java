package com.example.mybatisplustest.service;

import com.example.mybatisplustest.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LZJ
 * @since 2021-08-22
 */
public interface TbUserService extends IService<TbUser> {

    // add one user
    Integer addOneUser(TbUser user);

    // delete by id
    Integer deleteUserById(Integer userId);

    // update one user
    Integer updateOneUser(TbUser user);

    // find user by username
    TbUser findUserByUsername(String username);

    // get all user
    List<TbUser> getAllUsers();
}

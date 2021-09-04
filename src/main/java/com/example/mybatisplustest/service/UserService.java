package com.example.mybatisplustest.service;

import com.example.mybatisplustest.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
public interface UserService extends IService<User> {

    /**
     * <p> add one user </p>
     *
     * @author LiZijing
     * @param user User
     * @return Integer
     * @data 2021/9/4
     */
    Integer addOneUser(User user);

    /**
     * <p> delete by userid </p>
     *
     * @author LiZijing
     * @param userId Integer
     * @return Integer
     * @data 2021/9/4
     */
    Integer deleteUserById(Integer userId);

    /**
     * <p> delete by username </p>
     *
     * @author LiZijing
     * @param username String
     * @return Integer
     * @data 2021/9/4
     */
    Integer deleteUserByUsername(String username);

    /**
     * <p> update one user </p>
     *
     * @author LiZijing
     * @param updateUser User
     * @return Integer
     * @data 2021/9/4
     */
    Integer updateOneUser(User updateUser);

    /**
     * <p> find user by username </p>
     *
     * @author LiZijing
     * @param username String
     * @return User
     * @data 2021/9/4
     */
    User findUserByUsername(String username);

    /**
     * <p> get all users </p>
     *
     * @author LiZijing
     * @return List
     * @data 2021/9/4
     */
    List<User> getAllUsers();
}

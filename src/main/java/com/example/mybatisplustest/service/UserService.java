package com.example.mybatisplustest.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplustest.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LiZijing
 * @see com.example.mybatisplustest.service.impl.UserImpl
 * @since 2021-09-04
 */
public interface UserService extends IService<User> {

    /**
     * <p> add one user </p>
     *
     * @param user User
     * @return Integer
     * @author LiZijing
     * @data 2021/9/4
     */
    Integer addOneUser(User user);

    /**
     * <p> delete by userid </p>
     *
     * @param userId Integer
     * @return Integer
     * @author LiZijing
     * @data 2021/9/4
     */
    Integer deleteUserById(Integer userId);

    /**
     * <p> delete by username </p>
     *
     * @param username String
     * @return Integer
     * @author LiZijing
     * @data 2021/9/4
     */
    Integer deleteUserByUsername(String username);

    /**
     * <p> update one user </p>
     *
     * @param updateUser User
     * @return Integer
     * @author LiZijing
     * @data 2021/9/4
     */
    Integer updateOneUser(User updateUser);

    /**
     * <p> find user by username </p>
     *
     * @param username String
     * @return User
     * @author LiZijing
     * @data 2021/9/4
     */
    User findUserByUsername(String username);

    /**
     * <p> get all users </p>
     *
     * @return List
     * @author LiZijing
     * @data 2021/9/4
     */
    List<User> getAllUsers();

    /**
     * <p> select by wrapper </p>
     *
     * @param wrapper wrapper
     * @return List
     * @author LiZijing
     * @data 2021/9/4
     */
    List<User> selectList(LambdaQueryWrapper<User> wrapper);
}

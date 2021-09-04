package com.example.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplustest.entity.User;
import com.example.mybatisplustest.mapper.UserMapper;
import com.example.mybatisplustest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer addOneUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUserById(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public Integer deleteUserByUsername(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return userMapper.deleteByMap(map);
    }

    @Override
    public Integer updateOneUser(User updateUser) {
        return userMapper.updateById(updateUser);
    }

    @Override
    public User findUserByUsername(String username) {
        return new LambdaQueryChainWrapper<>(userMapper)
                .eq(User::getUsername, username)
                .one();
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }
}

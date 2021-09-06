package com.example.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplustest.entity.Role;
import com.example.mybatisplustest.entity.User;
import com.example.mybatisplustest.entity.UserRole;
import com.example.mybatisplustest.mapper.RoleMapper;
import com.example.mybatisplustest.mapper.UserMapper;
import com.example.mybatisplustest.mapper.UserRoleMapper;
import com.example.mybatisplustest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiZijing
 * @see UserService
 * @since 2021-09-04
 */
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;


    public List<User> selectList(LambdaQueryWrapper<User> wrapper) {
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.getId());
            List<UserRole> userRoleList = userRoleMapper.selectByMap(map);
            List<Role> roles = new ArrayList<>();
            for (UserRole userRole : userRoleList) {
                roles.add(roleMapper.selectById(userRole.getRoleId()));
            }
            user.setRoles(roles);
        }
        return users;
    }

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
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(wrapper);
        List<UserRole> userRoleList = userRoleMapper.selectByUserId(user.getId());
        HashMap<String, Object> roleIds = new HashMap<>();
        userRoleList.forEach(item -> roleIds.put("id", item.getRoleId()));
        List<Role> roleList = roleMapper.selectByMap(roleIds);
        user.setRoles(roleList);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }
}

package com.example.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplustest.entity.TbUser;
import com.example.mybatisplustest.mapper.TbUserMapper;
import com.example.mybatisplustest.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LZJ
 * @since 2021-08-22
 */
@Service
public class TbUserImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public Integer addOneUser(TbUser user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUserById(Integer userId) {
        return userMapper.deleteById(userId);
    }


    @Override
    public Integer updateOneUser(TbUser user) {
        return userMapper.updateById(user);
    }

    @Override
    public TbUser findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<TbUser> getAllUsers() {
        return userMapper.selectList(null);
    }
}

package com.example.mybatisplustest.service.impl;

import com.example.mybatisplustest.entity.TbUser;
import com.example.mybatisplustest.mapper.TbUserMapper;
import com.example.mybatisplustest.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

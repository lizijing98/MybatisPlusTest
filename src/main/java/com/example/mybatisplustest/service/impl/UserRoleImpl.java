package com.example.mybatisplustest.service.impl;

import com.example.mybatisplustest.entity.UserRole;
import com.example.mybatisplustest.mapper.UserRoleMapper;
import com.example.mybatisplustest.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
@Service
public class UserRoleImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}

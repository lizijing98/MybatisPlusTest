package com.example.mybatisplustest.service.impl;

import com.example.mybatisplustest.entity.Role;
import com.example.mybatisplustest.mapper.RoleMapper;
import com.example.mybatisplustest.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
@Service
public class RoleImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

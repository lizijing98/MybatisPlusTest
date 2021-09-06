package com.example.mybatisplustest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplustest.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author LiZijing
 * @since 2021-09-04
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserRole> selectByUserId(Integer userId);
}

package com.example.mybatisplustest.mapper;

import com.example.mybatisplustest.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author LZJ
 * @since 2021-08-22
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

    TbUser selectByUsername(String username);
}

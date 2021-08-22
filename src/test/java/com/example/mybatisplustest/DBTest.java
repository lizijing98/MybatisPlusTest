package com.example.mybatisplustest;

import com.example.mybatisplustest.entity.TbUser;
import com.example.mybatisplustest.mapper.TbUserMapper;
import com.example.mybatisplustest.service.TbUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DBTest {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Test
    void testInsert(){
        TbUser user=new TbUser();
        user.setUsername("testUser");
        user.setPassword("testUser");
        user.setDescription("a test User record");
        int result=tbUserMapper.insert(user);
        System.out.println(user);
        System.out.println(result);
    }

    @Test
    void cotextLoads() {
        List<TbUser> users = tbUserMapper.selectList(null);
        users.forEach(System.out::println);
    }
}

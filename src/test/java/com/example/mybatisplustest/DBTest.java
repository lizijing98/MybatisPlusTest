package com.example.mybatisplustest;

import com.example.mybatisplustest.entity.TbUser;
import com.example.mybatisplustest.mapper.TbUserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DBTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBTest.class);
    @Autowired
    private TbUserMapper tbUserMapper;

    @Test
    void testInsert() {
        TbUser user = new TbUser();
        user.setUsername("testUser2");
        user.setPassword("testUser2");
        user.setDescription("a test User record");
        int result = tbUserMapper.insert(user);
        LOGGER.info(user.toString());
        LOGGER.info("result: " + result);
    }

    @Test
    void testUpdate() {
        TbUser user = tbUserMapper.selectById(4);
        user.setUsername("testUser");
        user.setPhone("13303710000");
        int result = tbUserMapper.updateById(user);
        LOGGER.info(user.toString());
        LOGGER.info("result: " + result);
        LOGGER.warn(user.toString());
    }

    @Test
    void contextLoads() {
        List<TbUser> users = tbUserMapper.selectList(null);
        users.forEach(System.out::println);
    }
}

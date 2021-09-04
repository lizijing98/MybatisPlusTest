package com.example.mybatisplustest;

import com.example.mybatisplustest.entity.User;
import com.example.mybatisplustest.mapper.UserMapper;
import com.example.mybatisplustest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class DBTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService UserService;

    @Test
    void testInsert() {
        User user = new User();
        user.setUsername("testUser2");
        user.setPassword("testUser2");
        user.setDescription("a test User record");
        int result = userMapper.insert(user);
        log.info(user.toString());
        log.info("result: " + result);
    }

    @Test
    void testUpdate() {
        User user = userMapper.selectById(4);
        user.setUsername("testUser");
        user.setPhone("13303710000");
        int result = userMapper.updateById(user);
        log.info(user.toString());
        log.info("result: " + result);
        log.warn(user.toString());
    }

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void addOneUser() {
        User user = new User();
        user.setUsername("addtest");
        user.setPassword("addtest");
        int result = UserService.addOneUser(user);
        log.info("the new user: {}", user);
        log.info("result: {}", result);
    }

    @Test
    void deleteOneUser() {
        int result = UserService.deleteUserByUsername("addtest");
        if (result > 0) {
            log.info("delete success: {}", result);
        } else {
            log.error("delete failed: {}", result);
        }
    }

    @Test
    void searchOneUser() {
        User user = UserService.findUserByUsername("addtest");
        if (user == null) {
            log.error("search failed: {}", user);
        } else {
            log.info("search success: {}", user);
        }
    }
}

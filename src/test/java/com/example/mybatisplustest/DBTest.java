package com.example.mybatisplustest;

import com.example.mybatisplustest.entity.TbUser;
import com.example.mybatisplustest.mapper.TbUserMapper;
import com.example.mybatisplustest.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class DBTest {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbUserService tbUserService;

    @Test
    void testInsert() {
        TbUser user = new TbUser();
        user.setUsername("testUser2");
        user.setPassword("testUser2");
        user.setDescription("a test User record");
        int result = tbUserMapper.insert(user);
        log.info(user.toString());
        log.info("result: " + result);
    }

    @Test
    void testUpdate() {
        TbUser user = tbUserMapper.selectById(4);
        user.setUsername("testUser");
        user.setPhone("13303710000");
        int result = tbUserMapper.updateById(user);
        log.info(user.toString());
        log.info("result: " + result);
        log.warn(user.toString());
    }

    @Test
    void contextLoads() {
        List<TbUser> users = tbUserMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void addOneUser() {
        TbUser user = new TbUser();
        user.setUsername("addtest");
        user.setPassword("addtest");
        int result = tbUserService.addOneUser(user);
        log.info("the new user: {}", user);
        log.info("result: {}", result);
    }

    @Test
    void deleteOneUser() {
        int result = tbUserService.deleteUserByUsername("addtest");
        if (result>0){
            log.info("delete success: {}",result);
        }else {
            log.error("delete failed: {}",result);
        }
    }

    @Test
    void searchOneUser(){
        TbUser user=tbUserService.findUserByUsername("addtest");
        if (user == null) {
            log.error("search failed: {}",user);
        }else {
            log.info("search seccess: {}",user);
        }
    }
}

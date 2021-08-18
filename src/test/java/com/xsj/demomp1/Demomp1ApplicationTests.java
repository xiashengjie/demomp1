package com.xsj.demomp1;

import com.xsj.demomp1.entity.User;
import com.xsj.demomp1.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demomp1ApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("xsj");
        user.setAge(22);
        user.setEmail("372192060@qq.com");

        int insert = userMapper.insert(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(10L);
        user.setAge(20);

        int insert = userMapper.updateById(user);
    }
}

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

}

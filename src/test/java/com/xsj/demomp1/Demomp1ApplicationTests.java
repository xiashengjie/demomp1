package com.xsj.demomp1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xsj.demomp1.entity.User;
import com.xsj.demomp1.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
        user.setName("夏圣杰2323");
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

    //测试乐观锁
    @Test
    public void testOptimisticLock() {
        User user = userMapper.selectById(11L);

        user.setAge(200);
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    public void selectDemo1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(users);
    }

    //分页查询
    @Test
    public void testPage() {
        //1.创建page对象
        //传入两个参数：当前页  每页显示条数
        Page<User> userPage = new Page<>(1, 3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面

        userMapper.selectPage(userPage,null);

        //通过page对象获取分页数据
        System.out.println(userPage.getCurrent());//当前页
        System.out.println(userPage.getPages());//总页数
        System.out.println(userPage.getRecords());//每页list集合
        System.out.println(userPage.getSize());//每页显示条数
        System.out.println(userPage.getTotal());//总记录数
        System.out.println(userPage.hasNext());//下一页
        System.out.println(userPage.hasPrevious());//上一页
    }

    //物理删除
    //修改以后就是逻辑删除
    @Test
    public void testDeleteById(){

        int result = userMapper.deleteById(13L);
        System.out.println(result);
    }


    //批量删除
    @Test
    public void testDeleteBatchIds() {

        int result = userMapper.deleteBatchIds(Arrays.asList(3,4));
        System.out.println(result);
    }

    //mp实现复杂查询操作
    @Test
    public void testSelectQuery() {
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //通过QueryWrapper设置条件
        //ge、gt、le、lt
        //查询age>=30的记录
        //wrapper.ge("age",30);//字段名  值
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        //eq、ne
        wrapper.eq("name","xsj");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
        //between、notBetween

        //like

        //orderByDesc
    }
}

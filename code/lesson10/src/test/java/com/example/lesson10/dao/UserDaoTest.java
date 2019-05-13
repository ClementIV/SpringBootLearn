package com.example.lesson10.dao;

import com.example.lesson10.dto.UserDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Autowired
    private UserDao dao;

    @Test
    public void saveTest() {
        UserDto user = new UserDto();
        user.setUsername("java乐园");
        user.setMobileNo("13711645813");
        user.setNickName("聊点");
        user.setPhoto("/user/pic/1.png");
        user.setEmail("happyhuangjinjin@sina.com");
        user.setBirthday(new Date());
        dao.save(user);
    }

    @Test
    public void updateTest() {
        UserDto user = new UserDto();
        user.setId(2);
        user.setUsername("java乐园");
        user.setMobileNo("13711645813");
        user.setNickName("聊点");
        user.setPhoto("/user/pic/2.png");
        user.setEmail("happyhuangjinjin@sina.com");
        user.setBirthday(new Date());
        dao.update(user);
    }

    @Test
    public void deleteTest() {
        dao.delete(2);
    }

    @Test
    public void findAllTest() {
        List<UserDto> list = dao.findAll();
        System.out.println(list.size());
        if (list.size() > 0) {
            for(UserDto u:list) {

                System.out.println(u.getId());
                System.out.println(u.getEmail());
                System.out.println(u.getUsername());
                System.out.println(u.getNickName());
                System.out.println(u.getPhoto());
                System.out.println(u.getBirthday());
                System.out.println(u.getMobileNo());
            }
        }
    }

    @Test
    public void getUserTest() {
        UserDto u = dao.getUser(3);
        System.out.println(u.getId());
        System.out.println(u.getEmail());
        System.out.println(u.getUsername());
        System.out.println(u.getNickName());
        System.out.println(u.getPhoto());
        System.out.println(u.getBirthday());
        System.out.println(u.getMobileNo());
    }
}
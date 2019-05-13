package com.example.lesson9;

import com.example.lesson9.dao.AuthorDao;
import com.example.lesson9.pojo.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lesson9ApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private AuthorDao authorDao;
    @Test
    public void testInsert(){
        Author author = new Author();

        author.setRealName("英雄联盟");
        author.setNickName("LOL");

        authorDao.add(author);
        System.out.println("插入成功");
    }
}

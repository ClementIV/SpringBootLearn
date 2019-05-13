package com.example.lesson9.dao.Impl;

import com.example.lesson9.dao.AuthorDao;
import com.example.lesson9.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int add(Author author) {
        String sql = "insert into t_author(id,real_name,nick_name) "+"values(:id,:realName,:nickName)";
        Map<String,Object> params = new HashMap<>();
        params.put("id",author.getId());
        params.put("realName",author.getRealName());
        params.put("nickName",author.getNickName());

        return (int) jdbcTemplate.update(sql,params);
    }

    @Override
    public int update(Author author) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Author findAuthor(Long id) {
        return null;
    }

    @Override
    public List<Author> findAuthorList() {
        return null;
    }
}

package com.example.lesson10.dao.impl;

import com.example.lesson10.dao.UserDao;
import com.example.lesson10.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(UserDto user) {
        String sql = "INSERT INTO t_user( username ,nick_name,photo,mobile_no,email,birthday) values (?,?,?,?,?,?)";
        System.out.println(user.getUsername());
        return jdbcTemplate.update(sql,user.getUsername(),user.getNickName(),user.getPhoto(),user.getMobileNo(),
        user.getEmail(),user.getBirthday());

    }

    @Override
    public int update(UserDto user) {
        String sql = "UPDATE t_user SET username = ?,nick_name = ?,photo = ?,mobile_no = ?,email = ?,birthday = ? WHERE id = ?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getNickName(),user.getPhoto(),user.getMobileNo(),
                user.getEmail(),user.getBirthday(),user.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<UserDto> findAll() {
        String sql = "SELECT id,username,nick_name nickName, photo , mobile_no mobileNo,email , birthday FROM t_user ";
        return jdbcTemplate.query(sql, new RowMapper<UserDto>() {
            @Override
            public UserDto mapRow(ResultSet resultSet, int i) throws SQLException {
                UserDto user = new UserDto();
                user.setUsername(resultSet.getString("username"));
                user.setNickName(resultSet.getString("nickName"));
                user.setPhoto(resultSet.getString("photo"));
                user.setMobileNo(resultSet.getString("mobileNo"));
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthday(resultSet.getTime("birthday"));
                return user;
            }
        });
    }

    @Override
    public UserDto getUser(Integer id) {
        String sql = "SELECT id , username,nick_name nickName,photo,mobile_no mobileNo,email,birthday FROM t_user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<UserDto>(UserDto.class));
    }
}

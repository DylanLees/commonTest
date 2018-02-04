package com.woniuxy.springboot.service;

import com.woniuxy.springboot.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("UserDao")
public class UserDao {
    @Resource
   private JdbcTemplate jdbcTemplate;

    /**
     * 查找所有用户的信息
     * @return
     */
    public List<User> findAll(){
        String sql="select * from users";
        return this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }


}

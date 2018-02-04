package com.woniuxy.springboot.service;

import com.woniuxy.springboot.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserService {
    @Resource
    private  UserDao userDao;
    public List<User> findAll(){
        return  this.userDao.findAll();
    }

}

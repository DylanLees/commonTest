package com.woniuxy.springdata.test;

import com.woniuxy.springdata.ApplicationConfig;
import com.woniuxy.springdata.entity.User;
import com.woniuxy.springdata.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserTest {
    @Resource
    private UserRepository userRepository;

    /**
     * 向数据库添加数据
     */
    @Test
    public void save(){
        User user = new User();
        user.setUserName("李四");
        user.setAge(10);
        user.setAddr("成都");
        user.setUserPass(DigestUtils.md5DigestAsHex("admin".getBytes()));
        this.userRepository.save(user);

    }

    /**
     * 删除数据库表中的数据
     */
    @Test
    public void  delete(){
        this.userRepository.delete(2);
    }

    /**
     * 查询数据库表中的数据
     */
    @Test
    public void findAll(){
        List<User> users = this.userRepository.findAll();
        for(User u:users){
            System.out.println(u.getAddr());
            System.out.println(u.getUserName());
        }
    }

    /**
     * 更新数据库表中的数据
     */
    @Test
    public  void update(){
        this.userRepository.findByUserNameAndUserPass("王五",1);
    }

    /**
     * 实现分页
     */
    @Test
    public void pagination(){
        Pageable pageable = new PageRequest(0,3);
        Page<User> page = this.userRepository.findAll(pageable);
        System.out.println(page);


    }

    /**
     * 调用存储过程
     */
    @Test
    public void callProcedure(){
        Integer plusinout = this.userRepository.plusinout(1);
        System.out.println(plusinout);
    }
}

package com.woniuxy.springboot.controller;

import com.woniuxy.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String user_name, String user_pass, Model model) {
        if ("admin".equals(user_name) && "admin".equals(user_pass)) {
            //添加用户数据
            model.addAttribute("users", this.userService.findAll());
            model.addAttribute("msg", "登录成功");
        } else {
            model.addAttribute("msg", "登录失败");
            return "login";
        }
        return "user/list";
    }

}

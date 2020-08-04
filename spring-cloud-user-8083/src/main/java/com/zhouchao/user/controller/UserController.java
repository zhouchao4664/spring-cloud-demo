package com.zhouchao.user.controller;

import com.zhouchao.user.service.UserService;
import com.zhouchao.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouchao
 * @Date 2020/7/28 20:06
 * @Description
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{userId}")
    public UserVo getUser(@PathVariable String userId) {
        UserVo userVo = new UserVo(1, "zhouchao", "男");
        return userVo;
    }

    @GetMapping("order")
    public String getOrderByUser(){
        userService.getOrderByUser();
        return "success";
    }

}

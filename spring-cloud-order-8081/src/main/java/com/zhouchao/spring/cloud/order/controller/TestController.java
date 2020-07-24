package com.zhouchao.spring.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouchao
 * @Date 2020/7/23 20:10
 * @Description
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "这个是测试请求";
    }

}

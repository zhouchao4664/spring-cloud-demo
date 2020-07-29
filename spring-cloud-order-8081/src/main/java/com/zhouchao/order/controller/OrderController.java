package com.zhouchao.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.zhouchao.order.pojo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author zhouchao
 * @Date 2020/7/23 20:10
 * @Description
 **/
@Slf4j
@RestController
public class OrderController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/test")
    public String test() {
        return "这个是测试请求";
    }

    @GetMapping("/order/by/user")
    public String orderListByUser() throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List list = Lists.newArrayList();

        OrderVo order1 = new OrderVo(1, "aaaa", "订单1");
        OrderVo order2 = new OrderVo(2, "bbbb", "订单2");

        list.add(order1);
        list.add(order2);

        String json = objectMapper.writeValueAsString(list);

        log.info("json");
        return json;
    }

}

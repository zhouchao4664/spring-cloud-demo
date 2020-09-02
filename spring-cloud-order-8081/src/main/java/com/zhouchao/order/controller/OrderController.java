package com.zhouchao.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.zhouchao.vo.order.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${hello}")
    private String text;

    @GetMapping("/test")
    public String test() {
        System.out.println(text);
        return text;
    }

    @GetMapping("/by/user")
    public List<OrderVo> orderListByUser(){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List list = Lists.newArrayList();

        OrderVo order1 = new OrderVo(1, "aaaa", "订单1");
        OrderVo order2 = new OrderVo(2, "bbbb", "订单2");

        list.add(order1);
        list.add(order2);

        String json = null;
        try {
            json = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("json");
        return list;
    }

}

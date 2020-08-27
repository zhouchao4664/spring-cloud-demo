package com.zhouchao.user.service;

import com.netflix.discovery.converters.Auto;
import com.zhouchao.fegin.order.OrderFeignClient;
import com.zhouchao.tool.jackson.JacksonUtil;
import com.zhouchao.vo.order.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/7/29 21:43
 * @Description
 **/
@Slf4j
@Service
public class UserService {

    @Autowired
    OrderFeignClient orderFeignClient;

    public void getOrderByUser() {
        List<OrderVo> orderVoList = orderFeignClient.orderListByUser();
        try {
            log.info(JacksonUtil.toJson(orderVoList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

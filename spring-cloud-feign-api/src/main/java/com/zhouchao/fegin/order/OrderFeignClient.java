package com.zhouchao.fegin.order;

import com.zhouchao.vo.order.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/7/30 2:05
 * @Description
 **/
@FeignClient(value = "service-order", fallbackFactory = OrderFeignClientHystrixFallbackFactory.class)
public interface OrderFeignClient {

    @GetMapping("/test")
    String test();

    @GetMapping("/order/by/user")
    List<OrderVo> orderListByUser();
}

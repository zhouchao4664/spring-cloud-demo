package com.zhouchao.fegin.order;

import com.zhouchao.vo.order.OrderVo;
import com.zhouchao.vo.user.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/7/30 2:16
 * @Description
 **/
@Slf4j
public class OrderFallBack implements OrderFeignClient {

    @Override
    public String test() {
        log.info("系统错误！");
        return null;
    }

    @Override
    public List<OrderVo> orderListByUser() {
        log.info("系统错误！");
        return null;
    }
}

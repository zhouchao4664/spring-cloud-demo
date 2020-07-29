package com.zhouchao.fegin.user;

import com.zhouchao.vo.user.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhouchao
 * @Date 2020/7/30 2:05
 * @Description
 **/

@FeignClient(value = "service-user", fallbackFactory = UserFeignClientHystrixFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("user/{userId}")
    UserVo getUser(@PathVariable String userId);

    @GetMapping("user/order")
    String getOrderByUser();
}

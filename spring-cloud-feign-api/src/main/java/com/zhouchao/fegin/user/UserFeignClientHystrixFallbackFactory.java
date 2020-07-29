package com.zhouchao.fegin.user;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author zhouchao
 * @Date 2019/6/21 17:33
 * @Description
 **/

@Slf4j
@Component
public class UserFeignClientHystrixFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable cause) {
        log.error("fallback reason:{}",cause.getMessage());
        return new UserFallBack();
    }
}

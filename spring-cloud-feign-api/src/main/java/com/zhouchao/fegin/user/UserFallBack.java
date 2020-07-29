package com.zhouchao.fegin.user;

import com.zhouchao.vo.user.UserVo;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author zhouchao
 * @Date 2020/7/30 2:16
 * @Description
 **/
@Slf4j
public class UserFallBack implements UserFeignClient {
    @Override
    public UserVo getUser(String userId) {
        log.info("系统错误！");
        return null;
    }

    @Override
    public String getOrderByUser() {
        log.info("系统错误！");
        return null;
    }
}

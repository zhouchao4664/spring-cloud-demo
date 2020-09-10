package com.zhouchao.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhouchao
 * @Date 2020/9/10 22:59
 * @Description
 **/
@Configuration
public class MyDefineBootStrapConfiguration {

    @Bean
    public JsonProperySourceLocator jsonProperySourceLocator(){
        return new JsonProperySourceLocator();
    }
}

package com.springbootbootstrap.config;

import com.springbootbootstrap.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: laizc
 * @Date: created in 2022-07-11
 */
@Configuration
public class MyConfig {

    @Autowired
    private WeixinProperties weixinProperties;

    @Bean
    public PageBean pageBean() {
        PageBean bean = new PageBean();
        bean.setLimit(3);
        String openId = weixinProperties.getOpenId();
        System.out.println(openId);
        return bean;

    }


}

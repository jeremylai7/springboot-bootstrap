package com.springbootbootstrap.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: laizc
 * @Date: created in 2022-07-11
 */
@Component
@ConfigurationProperties(prefix = "weixin")
@Getter
@Setter
public class WeixinProperties {


    private String openId;


}

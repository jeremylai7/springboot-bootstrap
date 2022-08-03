package com.springbootbootstrap.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc:
 **/
@Getter
@Setter
@Table(name = "t_access_log")
public class AccessLog {

    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 浏览器名称
     */
    private String browser;

    /**
     * pc名称
     */
    private String pc;

    /**
     * 登录时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date createTime;

    @Transient
    private String createTimeStr;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String regionName;

    /**
     * 市
     */
    private String city;

}

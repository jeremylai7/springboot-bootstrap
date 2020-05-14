package com.springbootbootstrap.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: laizc
 * @Date: Created in 9:42 2019-06-27
 */
@Getter
@Setter
@Table(name = "t_user")
public class User {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    //角色id
    private String roleId;

    //用户名
    private String username;

    //密码
    private String password;

    //年龄
    private Integer age;

    //是否是超级管理员
    private Boolean top;

    //用户类型 NORMAL:正常,APPRVL:认证,STOP:禁用
    private String userType;
}

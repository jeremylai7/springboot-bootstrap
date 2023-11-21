package com.springbootbootstrap.service;

import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;

import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in 10:04 2019-06-27
 */
public interface UserService extends BaseService<User>{
    /**
     * 获取全部数据
     * @return
     */
    List<User> list();

    /**
     * 获取表单数据
     * @param pageBean
     * @return
     */
    TableData<User> getTableData(PageBean pageBean);

    /**
     * 批量删除
     * @param ids id集合 用,隔开
     */
    void deleteBatch(String ids);

    /**
     * 添加
     * @param username  用户名
     * @param password  密码
     * @param age        年龄
     */
    void add(String username, String password, Integer age);

    void update(AccessLog accessLog);
}

package com.springbootbootstrap.service;

import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;

import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in 10:04 2019-06-27
 */
public interface UserService {
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

}

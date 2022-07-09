package com.springbootbootstrap.dao;

import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.MyMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: laizc
 * @Date: Created in 10:54 2019-06-27
 */
public interface UserDao extends MyMapper<User> {
}

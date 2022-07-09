package com.springbootbootstrap.dao;

import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.util.MyMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc:
 **/
public interface AccessLogDao extends MyMapper<AccessLog> {

    List<AccessLog> find();
}

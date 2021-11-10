package com.springbootbootstrap.dao;

import com.springbootbootstrap.model.AccessLog;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc:
 **/
public interface AccessLogDao extends Mapper<AccessLog>, IdsMapper<AccessLog> {

    List<AccessLog> find();
}

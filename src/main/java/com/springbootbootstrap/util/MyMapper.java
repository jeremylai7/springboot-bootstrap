package com.springbootbootstrap.util;

import com.springbootbootstrap.model.AccessLog;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: laizc
 * @date: created in 2022/7/9
 * @desc:
 **/
public interface MyMapper<T> extends Mapper<T>, IdsMapper<T> {
}

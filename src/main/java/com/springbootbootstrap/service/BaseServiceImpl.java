package com.springbootbootstrap.service;

import com.springbootbootstrap.util.MyMapper;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in 9:47 2019-06-27
 */
public class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    private MyMapper<T> mapper;

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int save(T t) {
        return mapper.insert(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public int deleteByPrimaryKey(int t) {
        return mapper.deleteByPrimaryKey(t);
    }

    @Override
    public TableData<T> getTableData(PageBean pageBean) {
        return null;
    }
}

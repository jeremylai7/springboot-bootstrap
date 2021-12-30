package com.springbootbootstrap.service;

import com.github.pagehelper.PageHelper;
import com.springbootbootstrap.dao.AccessLogDao;
import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc:
 **/
@Service
public class AccessLogServiceImpl implements AccessLogService{

    @Resource
    private AccessLogDao accessLogDao;

    @Override
    public void add(AccessLog accessLog) {
        accessLogDao.insert(accessLog);
    }

    @Override
    public TableData<AccessLog> getTableData(PageBean pageBean) {
        int count = accessLogDao.selectCount(null);
        if (count > 0) {
            PageHelper.startPage((pageBean.getOffset()/pageBean.getLimit()) + 1,pageBean.getLimit());
            Example example = new Example(AccessLog.class);
            example.setOrderByClause("id desc");
            List<AccessLog> list = accessLogDao.selectByExample(example);
            for (AccessLog accessLog : list) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                accessLog.setCreateTimeStr(sdf.format(accessLog.getCreateTime()));
            }
            return TableData.bulid(count,list);
        }
        return TableData.empty();
    }

    @Override
    public List<AccessLog> find() {
        List<AccessLog> lists = accessLogDao.find();
        System.out.println(lists);
        return lists;
    }

}

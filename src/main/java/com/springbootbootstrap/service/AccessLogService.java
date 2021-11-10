package com.springbootbootstrap.service;

import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc:
 **/
public interface AccessLogService {

    void add(AccessLog accessLog);

    TableData<AccessLog> getTableData(PageBean pageBean);
}

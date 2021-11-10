package com.springbootbootstrap.controller;

import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.service.AccessLogService;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc: 访问日志
 **/
@CrossOrigin
@Controller
@RequestMapping("/access-log")
public class AccessLogController {

    @Autowired
    private AccessLogService accessLogService;

    @GetMapping("/getTableData")
    @ResponseBody
    public TableData<AccessLog> getTableData(PageBean pageBean, HttpServletRequest request){
        if (pageBean.getLimit() == null){
            pageBean.setLimit(10);
        }
        if (pageBean.getOffset() == null){
            pageBean.setOffset(0);
        }
        TableData<AccessLog> tableData = accessLogService.getTableData(pageBean);
        return tableData;
    }


}

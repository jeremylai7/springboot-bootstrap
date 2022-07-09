package com.springbootbootstrap.controller;

import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.service.AccessLogService;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc: 访问日志
 **/
@CrossOrigin
@RestController
@RequestMapping("/access-log")
public class AccessLogController {

    @Autowired
    private AccessLogService accessLogService;

    @GetMapping("/getTableData")
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

    @GetMapping("/find")
    public List<AccessLog> find() {
        List<AccessLog> list = accessLogService.find();
        return list;
    }

    public class CreateConnectionThread extends Thread {

        @Override
        public void run() {
            super.run();
        }
    }


}



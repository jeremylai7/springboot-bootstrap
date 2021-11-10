package com.springbootbootstrap.controller;

import com.springbootbootstrap.dao.AccessLogDao;
import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.service.AccessLogService;
import com.springbootbootstrap.service.UserService;
import com.springbootbootstrap.util.NetUtil;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: laizc
 * @Date: Created in 9:41 2019-06-27
 */
@CrossOrigin
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessLogService accessLogService;

    @GetMapping({"index.html","/"})
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/getTableData")
    @ResponseBody
    public TableData<User> getTableData(PageBean pageBean,HttpServletRequest request){
        if (pageBean.getLimit() == null){
            pageBean.setLimit(10);
        }
        if (pageBean.getOffset() == null){
            pageBean.setOffset(0);
        }
        TableData<User> tableData = userService.getTableData(pageBean);

        addLog(request);
        return tableData;
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(String ids){
        userService.deleteBatch(ids);
    }

    @PostMapping("/add")
    @ResponseBody
    public void add(String username,String password,Integer age){
        userService.add(username,password,age);
    }

    private void addLog(HttpServletRequest request) {
        //添加访问日志
        String ip = NetUtil.getIpAddress(request);
        Enumeration<String> enumerations = request.getHeaderNames();
        AccessLog accessLog = new AccessLog();
        accessLog.setIp(ip);
        System.out.println("--------begin---------");
        while (enumerations.hasMoreElements()) {
            String headerName = enumerations.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println("name:" + headerName + ";value:" + headerValue);
            switch (headerName) {
                case "sec-ch-ua":
                    accessLog.setBrowser(request.getHeader(headerName).split(";")[0]);
                    break;
                case  "sec-ch-ua-platform":
                    accessLog.setPc(request.getHeader(headerName));
                    break;
                default:
                    break;
            }
        }
        System.out.println("-------end------------");
        accessLogService.add(accessLog);
    }



}

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

    private final String SPLIT = "\\(|\\)";

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
        while (enumerations.hasMoreElements()) {
            String headerName = enumerations.nextElement();
            if (headerName.equals("user-agent")) {
                String headerValue = request.getHeader(headerName);
                String[] array = headerValue.split(SPLIT);
                if (array.length >0) {
                    accessLog.setPc(array[1].split(";")[1]);
                    accessLog.setBrowser(array[4]);
                }
                break;
            }
        }
        accessLogService.add(accessLog);
    }

    /*@Transactional(rollbackFor = Exception.class)
    public void orderPass() {
        // 更新订单审核状态
        updateOrderAuditStatus(id);
        try {
            updatePutInStorage(id);
        } catch (Exception e) {
            System.out.println("更新出库失败");
        }

    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updatePutInStorage(Long id) throws Exception{
        // 添加入库
        addPutInStorage(id);
        // 更新订单入库状态
        updateOrderStorageStatus(id);
        System.out.println("更新出库成功");
    }*/


}

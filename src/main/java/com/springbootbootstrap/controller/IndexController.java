package com.springbootbootstrap.controller;

import com.springbootbootstrap.model.User;
import com.springbootbootstrap.service.UserService;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping({"index.html","/"})
    public ModelAndView index(){
        List<User> list = userService.list();
        System.out.println(list);
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/getTableData")
    @ResponseBody
    public TableData<User> getTableData(PageBean pageBean){
        if (pageBean.getLimit() == null){
            pageBean.setLimit(10);
        }
        if (pageBean.getOffset() == null){
            pageBean.setOffset(0);
        }
        TableData<User> tableData = userService.getTableData(pageBean);
        return tableData;
    }





}

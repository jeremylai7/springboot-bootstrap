package com.springbootbootstrap.controller;

import com.springbootbootstrap.model.User;
import com.springbootbootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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





}

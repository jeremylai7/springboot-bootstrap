package com.springbootbootstrap.service;

import com.springbootbootstrap.dao.UserDao;
import com.springbootbootstrap.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in 10:05 2019-06-27
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public List<User> list(){
        return userDao.selectAll();
    }

}

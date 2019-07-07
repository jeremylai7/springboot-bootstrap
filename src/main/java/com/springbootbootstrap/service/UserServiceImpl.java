package com.springbootbootstrap.service;

import com.github.pagehelper.PageHelper;
import com.springbootbootstrap.dao.UserDao;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public TableData<User> getTableData(PageBean pageBean) {
        int count = userDao.selectCount(null);
        if (count > 0){
            PageHelper.startPage((pageBean.getOffset()/pageBean.getLimit()) + 1, pageBean.getLimit());
            Example example = new Example(User.class);
            if (StringUtils.isNotBlank(pageBean.getOrder())){
                example.setOrderByClause(pageBean.getSort()+" "+pageBean.getOrder());
            }
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(pageBean.getSearch())){
                criteria.andLike(pageBean.getSort(),"%"+pageBean.getSearch()+"%");
            }
            List<User> list = userDao.selectByExample(example);
            return TableData.bulid(count,list);
        }
        return TableData.empty();
    }

    @Override
    public void deleteBatch(String ids) {
        userDao.deleteByIds(ids);
    }

}

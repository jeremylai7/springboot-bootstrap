package com.springbootbootstrap.service;

import com.github.pagehelper.PageHelper;
import com.springbootbootstrap.dao.AccessLogDao;
import com.springbootbootstrap.dao.UserDao;
import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in 10:05 2019-06-27
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{



    @Override
    public List<User> list(){
        return this.selectAll();
    }

    @Override
    public TableData<User> getTableData(PageBean pageBean) {
        int count = this.selectCount();
        if (count > 0){
            PageHelper.startPage((pageBean.getOffset()/pageBean.getLimit()) + 1, pageBean.getLimit());
            Example example = new Example(User.class);
            //sort
            if (StringUtils.isNotBlank(pageBean.getOrder())){
                example.setOrderByClause(pageBean.getSort()+" "+pageBean.getOrder());
            }
            Example.Criteria criteria = example.createCriteria();
            //search
            if (StringUtils.isNotBlank(pageBean.getSearch())){
            	if (StringUtils.isBlank(pageBean.getSort())) {
            		pageBean.setSort("username");
	            }
                criteria.andLike(pageBean.getSort(),"%"+pageBean.getSearch()+"%");
            }
            List<User> list = this.selectByExample(example);
            return TableData.bulid(count,list);
        }
        return TableData.empty();
    }

    @Override
    public void deleteBatch(String ids) {
        this.deleteByIds(ids);
    }

    @Override
    public void add(String username, String password, Integer age) {
        Example example = new Example(User.class);
        Example.Criteria  criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> list = this.selectByExample(example);
        if (list.size() == 0){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            user.setRoleId("8");
            user.setTop(false);
            user.setUserType("NL");
            this.save(user);
        }
    }

    @Resource
    private UserDao userDao;

    @Resource
    private AccessLogDao accessLogDao;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void update(AccessLog accessLog) {
        User user = new User();
        user.setAge(10);
        user.setPassword("4242");
        userDao.insert(user);
        AccessLog log = new AccessLog();
        log.setId(accessLog.getId());
        log.setPc(accessLog.getPc()+ "哦哦");
        accessLogDao.updateByPrimaryKeySelective(log);

    }

}

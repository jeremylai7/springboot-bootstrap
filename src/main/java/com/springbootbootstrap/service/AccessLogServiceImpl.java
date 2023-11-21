package com.springbootbootstrap.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.springbootbootstrap.dao.AccessLogDao;
import com.springbootbootstrap.dao.UserDao;
import com.springbootbootstrap.model.AccessLog;
import com.springbootbootstrap.model.User;
import com.springbootbootstrap.util.PageBean;
import com.springbootbootstrap.util.TableData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: laizc
 * @date: created in 2021/11/10
 * @desc:
 **/
@Service
public class AccessLogServiceImpl implements AccessLogService{

    private static final String URL = "https://api.beijinxuetang.com/api/common/ip";

    @Resource
    private AccessLogDao accessLogDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void add(AccessLog accessLog) {
        String ip = accessLog.getIp();
        String brower = accessLog.getBrowser();
        if (StringUtils.isNotBlank(brower) && brower.length() > 64) {
            accessLog.setBrowser(accessLog.getBrowser().substring(0,64));
        }
        accessLog.setCreateTime(new Date());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ip",ip);
        JSONObject json = restTemplate.postForObject(URL,jsonObject, JSONObject.class);
        //JSONObject result = restTemplate.getForObject("http://ip-api.com/json/" + ip + "?lang=zh-CN", JSONObject.class);
        if (json.getInteger("code") == 0) {
            json = json.getJSONObject("data");
            String nation = json.getString("nation");
            String province = json.getString("province");
            String city = json.getString("city");
            accessLog.setCountry(nation);
            accessLog.setRegionName(province);
            accessLog.setCity(city);

        }
        accessLogDao.insert(accessLog);
    }

    @Override
    public TableData<AccessLog> getTableData(PageBean pageBean) {
        int count = accessLogDao.selectCount(null);
        if (count > 0) {
            PageHelper.startPage((pageBean.getOffset()/pageBean.getLimit()) + 1,pageBean.getLimit());
            Example example = new Example(AccessLog.class);
            example.setOrderByClause("id desc");
            List<AccessLog> list = accessLogDao.selectByExample(example);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (AccessLog accessLog : list) {
                accessLog.setCreateTimeStr(sdf.format(accessLog.getCreateTime()));
            }
            return TableData.bulid(count,list);
        }
        return TableData.empty();
    }

    @Override
    public List<AccessLog> find() {
        List<AccessLog> lists = accessLogDao.find();
        return lists;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void test(String id) {
        AccessLog accessLog = accessLogDao.selectByIds("11").get(0);
        AccessLog log = new AccessLog();
        log.setId(accessLog.getId());
        log.setBrowser(accessLog.getBrowser() + "哈哈");
        accessLogDao.updateByPrimaryKeySelective(log);
        userService.update(accessLog);



    }

    @Resource
    private UserDao userDao;

    @Autowired
    private UserService userService;

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

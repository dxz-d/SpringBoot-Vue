package com.evan.wj.service;

import com.evan.wj.dao.UserDao;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/5 16:30
 * @param
 * @return
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null != user;
    }

    private User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }

    /**
     * 从数据库中获取当前用户
     * @param userName
     * @return
     */
    public User getByUserName(String userName) {
        return userDao.findByUsername(userName);
    }
}

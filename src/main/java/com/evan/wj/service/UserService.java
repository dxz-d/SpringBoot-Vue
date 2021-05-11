package com.evan.wj.service;

import com.evan.wj.dao.UserDao;
import com.evan.wj.dto.UserDto;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    AdminRoleService adminRoleService;

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

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /*public List<UserDto> list() {
        List<User> users = userDao.findAll();

        // Find all roles in DB to enable JPA persistence context
        List<UserDto> userDtos = users.stream().map(user -> (UserDto) new UserDto().convertFrom(user)).collect(Collectors.toList());

        userDtos.forEach(u -> {
            List<AdminRole> adminRoles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(adminRoles);
        });
        return userDtos;
    }*/

    public List<UserDto> list() {
        List<User> users = userDao.findAll();

        // Find all roles in DB to enable JPA persistence context.
        // List<AdminRole> allRoles = adminRoleService.findAll();

        List<UserDto> userDTOS = users
                .stream().map(user -> (UserDto) new UserDto().convertFrom(user)).collect(Collectors.toList());

        userDTOS.forEach(u -> {
            List<AdminRole> roles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(roles);
        });

        return userDTOS;
    }
}

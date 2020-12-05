package com.evan.wj.dao;

import com.evan.wj.pojo.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/5 16:24
 * @param
 * @return
 */
public interface UserDao extends JpaRepository<User, Integer> {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    User getByUsernameAndPassword(String username, String password);
}

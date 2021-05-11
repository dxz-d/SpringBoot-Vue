package com.evan.wj.dao;

import com.evan.wj.pojo.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/28 9:26
 */
public interface AdminUserRoleDao extends JpaRepository<AdminUserRole, Integer> {

    /**
     * 获取当前用户对应的所有角色id列表
     * @param uid
     * @return
     */
    List<AdminUserRole> findAllByUidIn(Integer uid);
}

package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @description:
 * @author: dxz
 * @date: 2021/4/22 17:12
 */
public interface AdminRoleDao extends JpaRepository<AdminRole, Integer> {

    // AdminRole findById(int id);
}

package com.evan.wj.dao;

import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @description:
 * @author: dxz
 * @date: 2021/5/10 17:19
 */
public interface AdminPerMissionDao extends JpaRepository<AdminPermission, Integer> {

    // AdminPermission findById(int pids);
}

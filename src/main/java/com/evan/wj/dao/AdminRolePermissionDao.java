package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: dxz
 * @date: 2021/5/10 17:06
 */
public interface AdminRolePermissionDao extends JpaRepository<AdminRolePermission, Integer> {

    List<AdminRolePermission> findAllByRid(List<Integer> rids);

    /*List<AdminRolePermission> findAllByRid(int rid);
    void deleteAllByRid(int rid);*/
}

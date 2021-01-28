package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/28 9:40
 */
public interface AdminRoleMenuDao extends JpaRepository<AdminRoleMenu, Integer> {

    /**
     * 查询出这些角色对应的所有菜单项
     * @param rids
     * @return
     */
    List<AdminRoleMenu> findAllByRid(List<Integer> rids);
}

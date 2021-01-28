package com.evan.wj.dao;

import com.evan.wj.pojo.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/28 9:45
 */
public interface AdminMenuDao extends JpaRepository<AdminMenu, Integer> {

    /**
     * 查询出这些角色对应的所有菜单项
     * @param parentId
     * @return
     */
    List<AdminMenu> findAllByParentId(Integer parentId);
}

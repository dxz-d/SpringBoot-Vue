package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleMenuDao;
import com.evan.wj.pojo.AdminRoleMenu;
import org.apache.xerces.impl.XMLEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/28 9:35
 */
@Service
public class AdminRoleMenuService {

    @Autowired
    private AdminRoleMenuDao adminRoleMenuDao;

    /**
     * 查询出这些角色对应的所有菜单项
     * @param rids
     * @return
     */
    public List<AdminRoleMenu> findAllByRid(List<Integer> rids) {
        return adminRoleMenuDao.findAllByRid(rids);
    }
}

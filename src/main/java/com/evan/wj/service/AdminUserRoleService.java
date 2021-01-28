package com.evan.wj.service;

import com.evan.wj.dao.AdminUserRoleDao;
import com.evan.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/28 9:18
 */
@Service
public class AdminUserRoleService {

    @Autowired
    private AdminUserRoleDao adminUserRoleDao;

    /**
     * 获取当前用户对应的所有角色的id列表
     * @param uid
     * @return
     */
    public List<AdminUserRole> listAllByUid(Integer uid) {
        return adminUserRoleDao.findAllByUidIn(uid);
    }
}

package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleDao;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: dxz
 * @date: 2021/4/22 16:49
 */
@Service
public class AdminRoleService {

    @Autowired
    private static UserService userService;

    @Autowired
    private static AdminUserRoleService adminUserRoleService;

    @Autowired
    private static AdminRoleDao adminRoleDao;

    /**
     * 获取当前用户的角色
     * @param username
     * @return
     */
    /*public List<AdminRole> listRolesByUser(String username) {
        // 获取当前用户的id
        int uid = userService.findByUsername(username).getId();

        // 获取当前用户对应的角色id列表
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        // 根据角色id列表
        return adminRoleDao.findAllById(rids);
    }*/

    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.findByUsername(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        return adminRoleDao.findAllById(rids);
    }
}

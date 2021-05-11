package com.evan.wj.service;

import com.evan.wj.dao.AdminPerMissionDao;
import com.evan.wj.dao.AdminRolePermissionDao;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: dxz
 * @date: 2021/4/22 16:45
 */
@Service
public class AdminPermissionService {

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    private AdminRolePermissionDao adminRolePermissionDao;

    @Autowired
    private AdminPerMissionDao adminPermissionDao;

    /**
     * 根据当前用户获取所有权限
     */
    public Set<String> listPermissionURLsByUser(String username) {

        // 获取当前用户的角色id列表
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole :: getId).collect(Collectors.toList());

        // 根据角色id去查找权限的id
        List<Integer> pids = adminRolePermissionDao.findAllByRid(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionDao.findAllById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission :: getUrl).collect(Collectors.toSet());
        return URLs;
    }

    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDao.findAll();
        for(AdminPermission p : ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }



}












package com.evan.wj.service;

import com.evan.wj.dao.AdminMenuDao;
import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.pojo.AdminRoleMenu;
import com.evan.wj.pojo.AdminUserRole;
import com.evan.wj.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/27 16:53
 */
@Service
public class AdminMenuService {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Autowired
    private AdminRoleMenuService adminRoleMenuService;

    @Autowired
    private AdminMenuDao adminMenuDao;

    public List<AdminMenu> getMenuByCurrentUser() {
        // 从数据库中获取当前用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByUserName(username);

        // 获取当前用户对应的所有角色的id列表
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        // 查询出这些角色对应的所有菜单项
        // stream简化列表的处理  map()提取集合中的某一属性
        // distinct()对查询出的菜单项进行了去重操作，避免多角色情况下有冗余的菜单
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuDao.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // 处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    private void handleMenus(List<AdminMenu> menus) {
        // 遍历菜单项
        for(AdminMenu menu : menus) {
            // 根据每一项的id查询该项所有的子项
            List<AdminMenu> children = getAllByParentId(menu.getId());
            // 放进children属性
            menu.setChildren(children);
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }

        /*menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        // 提出所有子项，只保留第一层的父项
        menus.removeIf(m -> m.getParentId() != 0);*/
    }

    private List<AdminMenu> getAllByParentId(Integer parentId) {
        return adminMenuDao.findAllByParentId(parentId);
    }
}

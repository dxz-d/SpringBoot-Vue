package com.evan.wj.controller;

import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/27 15:58
 */
@RestController
public class MenuController {

    @Autowired
    private AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenuByCurrentUser();
    }
}

package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/5 6:03
 * @param
 * @return
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param requestUser
     * @return
     */
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(requestUser);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在1");
        }

    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐，默认长度16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置hash算法迭代次数
        int times = 2;
        // 得到hash后的密码
        String encodePassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括salt与hash后的密码
        user.setSalt(salt);
        user.setPassword(encodePassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @ResponseBody
    @GetMapping("/api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功退出";
        return ResultFactory.buildSuccessResult(message);
    }

    /**
     * 访问每个页面都向后端发送一个请求，目的是经由拦截器验证服务器端的登录状态
     * @return
     */
    @ResponseBody
    @GetMapping("/api/authentication")
    public String authentication() {
        return "身份认证成功";
    }
}




























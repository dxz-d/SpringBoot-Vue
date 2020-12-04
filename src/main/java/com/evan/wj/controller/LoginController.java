package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/5 6:03
 * @param
 * @return
 */
@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对html标签进行转义，防止XXS进攻
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword()) ) {
            String message = "账号密码错误";
            System.out.println("test,账号密码错误");
            return new Result(400);
        }else {
            return new Result(200);
        }
    }
}

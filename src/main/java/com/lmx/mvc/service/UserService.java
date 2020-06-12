package com.lmx.mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 功能描述：Servlet
 *
 * @program: springmvc-demo
 * @author: LM.X
 * @create: 2020-06-09 18:21
 **/
@Service
public class UserService {

    public String login(String user, String pwd) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(pwd)) {
            return "账户名或密码错误";
        }
        return "用户名：" + user + "登录成功！Session：" + UUID.randomUUID().toString();

    }

}

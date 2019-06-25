package com.gznu.element.controller.login;


import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginControler {

    private static final Logger logger = LoggerFactory.getLogger(LoginControler.class);

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password, String mode, Model model) {
//        JSONObject jsonObject=new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        String url = "";
//        手动加入
        mode = "web";
        //        返回用户名
        model.addAttribute("username", username);


        System.out.println(subject.getSession().getId());
        // 在认证提交前准备token（令牌）123
        // 这里的账号和密码 将来是由用户输入进去
        username = username + mode;
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                password);
        try {
            // 执行认证提交
            subject.login(token);
//            jsonObject.put("token", subject.getSession().getId());
            model.addAttribute("token", subject.getSession().getId());
//            jsonObject.put("msg",14);//登陆成功
            model.addAttribute("msg", "登陆成功");

            url = "index";
        } catch (Exception e) {
            logger.error("登陆失败; e={}", e);
            if (e.getClass().getName() != null) {
                if (UnknownAccountException.class.getName().equals(e.getClass().getName())) {
                    //抛出账号不存在异常
//                    jsonObject.put("msg", 10);//无此账号
                    model.addAttribute("msg", "无此账号");
                } else if (IncorrectCredentialsException.class.getName().equals(e.getClass().getName())) {
//                    jsonObject.put("msg", 11);//密码错误
                    model.addAttribute("msg", "密码错误");
                } else if (AuthenticationException.class.getName().equals(e.getClass().getName())) {
//                    jsonObject.put("msg", 12);//验证失败;
                    model.addAttribute("msg", "验证失败");
                } else if (UnknownSessionException.class.getName().equals(e.getClass().getName())) {
//                    jsonObject.put("msg", 13);//会话失效
                    model.addAttribute("msg", "会话失效");
                }
            } else {
//                jsonObject.put("msg", 12);//验证失败;
                model.addAttribute("msg", "验证失败");
            }
            url = "login";
        }
        System.out.println(subject.getSession().getId());


//        return jsonObject;
        return url;
    }


}

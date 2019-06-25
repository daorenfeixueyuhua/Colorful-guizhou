package com.gznu.element.controller.user;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 返回model
    @RequestMapping("/showAll")
    public String showAllUser(PagingQuery query, Model model) {
        PagingQueryData data = null;
        try {
            data = userService.findAllUser(query);
            model.addAttribute("data", data);
        } catch (RuntimeException e) {
            model.addAttribute("msg", "无数据");
        }
        return "admin/user/list";
    }

}

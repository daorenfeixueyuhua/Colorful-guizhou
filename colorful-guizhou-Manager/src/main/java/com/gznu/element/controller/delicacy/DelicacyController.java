package com.gznu.element.controller.delicacy;

import com.gznu.element.entity.delicacy.Delicacy;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.service.delicacy.DelicacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("delicacy")
public class DelicacyController {
    @Autowired
    private DelicacyService delicacyService;

    @PostMapping("/add")
    public String addDelicacy(Delicacy delicacy, Model model) {
        try {
            delicacyService.insertDelicacy(delicacy);
            model.addAttribute("msg", "操作成功");
        } catch (RuntimeException e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/delicacy/add";
    }

    @GetMapping("/has")
    public String hasDelicacy(String delicacyId, Model model) {
        Delicacy delicacy = null;
        delicacy = delicacyService.selectDelicacyByID(delicacyId);
        if (delicacy == null) {
            model.addAttribute("msg", "该id: " + delicacyId + " 不存在");
        }
        return "index";
    }

    @GetMapping("/findOne")
    public String findDelicacyByID(String delicacyId, Model model) {
        Delicacy delicacy = delicacyService.selectDelicacyByID(delicacyId);
        if (delicacy == null) {
            model.addAttribute("msg", "该id: " + delicacyId + " 不存在");
        }
        model.addAttribute("delicacy", delicacy);
        return "index";
    }

    @GetMapping("/showAll")
    public String showAll(PagingQuery query, Model model) {
        PagingQueryData<Delicacy> data = null;
        try {
            data = delicacyService.selectAllDelicacy(query);
            model.addAttribute("data", data);
            model.addAttribute("msg", "操作成功");
        } catch (RuntimeException e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/delicacy/list";
    }

    @GetMapping("/del")
    public String deleteDelicacy(String delicacyId, Model model) {
        try {
            delicacyService.deleteDelicacy(delicacyId);
            model.addAttribute("msg", "操作成功");
        } catch (Exception e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/delicacy/del";
    }

    @PostMapping("update")
    public String updateDelicacy(Delicacy delicacy, Model model) {
        try {
            delicacyService.updateDelicacy(delicacy);
            model.addAttribute("msg", "操作成功");
        } catch (Exception e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/delicacy/update";
    }
}

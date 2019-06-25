package com.gznu.element.controller.landscape;

import com.gznu.element.entity.landscape.Landscape;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.service.landscape.LandscapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("landscape")
public class LandscapeController {
    @Autowired
    private LandscapeService landscapeService;

    @PostMapping("/add")
    public String addLandscape(Landscape landscape, Model model) {
        try {
            landscapeService.insertLandscape(landscape);
            model.addAttribute("msg", "操作成功");
        } catch (RuntimeException e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/landscape/add";
    }

    @GetMapping("/has")
    public String hasLandscape(String landscapeId, Model model) {
        Landscape landscape = null;
        landscape = landscapeService.selectLandscapeByID(landscapeId);
        if (landscape == null) {
            model.addAttribute("msg", "该id: " + landscapeId + " 不存在");
        }
        return "index";
    }

    @GetMapping("/findOne")
    public String findLandscapeByID(String landscapeId, Model model) {
        Landscape landscape = landscapeService.selectLandscapeByID(landscapeId);
        if (landscape == null) {
            model.addAttribute("msg", "该id: " + landscapeId + " 不存在");
        }
        model.addAttribute("landscape", landscape);
        return "index";
    }

    @GetMapping("/showAll")
    public String showAll(PagingQuery query, Model model) {
        PagingQueryData<Landscape> data = null;
        try {
            data = landscapeService.selectAllLandscape(query);
            model.addAttribute("data", data);
            model.addAttribute("msg", "操作成功");
        } catch (RuntimeException e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/landscape/list";
    }

    @GetMapping("/del")
    public String deleteLandscape(String landscapeId, Model model) {
        try {
            landscapeService.deleteLandscape(landscapeId);
            model.addAttribute("msg", "操作成功");
        } catch (Exception e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/landscape/del";
    }

    @PostMapping("update")
    public String updateLandscape(Landscape landscape, Model model) {
        try {
            landscapeService.updateLandscape(landscape);
            model.addAttribute("msg", "操作成功");
        } catch (Exception e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/landscape/update";
    }
}

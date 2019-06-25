package com.gznu.element.controller.region;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.entity.region.Region;
import com.gznu.element.service.region.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping("/add")
    public String addRegion(Region region, Model model) {
        try {
            regionService.insertRegion(region);
            model.addAttribute("msg", "操作成功");
        } catch (RuntimeException e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/region/add";
    }

    @GetMapping("/has")
    public String hasRegion(String regionId, Model model) {
        Region region = null;
        region = regionService.selectAllRegionById(regionId);
        if (region == null) {
            model.addAttribute("msg", "该id: " + regionId + " 不存在");
        }
        return "index";
    }

    @GetMapping("/findOne")
    public String findRegionByID(String regionId, Model model) {
        Region region = regionService.selectAllRegionById(regionId);
        if (region == null) {
            model.addAttribute("msg", "该id: " + regionId + " 不存在");
        }
        model.addAttribute("region", region);
        return "index";
    }

    @GetMapping("/showAll")
    public String showAll(PagingQuery query, Model model) {
        PagingQueryData<Region> data = null;
        try {
            data = regionService.selectAllRegion(query);
            model.addAttribute("data", data);
            model.addAttribute("msg", "操作成功");
        } catch (RuntimeException e) {
            model.addAttribute("msg", "操作失败");
        }
        return "admin/region/list";
    }

    @GetMapping("/del")
    public String deleteRegion(String regionID, Model model) {
        try {
            regionService.deleteRegion(regionID);
            model.addAttribute("msg", "操作成功");
        } catch (Exception e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/region/del";
    }

    @PostMapping("update")
    public String updateRegion(Region region, Model model) {
        try {
            regionService.updateRegion(region);
            model.addAttribute("msg", "操作成功");
        } catch (Exception e) {
            model.addAttribute("msg", "操作失败");
        }
        return "/admin/region/update";
    }
}

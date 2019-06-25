package com.gznu.element.controller.abnormal;

import com.alibaba.fastjson.JSONObject;
import com.gznu.element.entity.abnormal.AbnormalEvent;
import com.gznu.element.service.abnormal.AbnormalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author dage
 * @date 2019/04/16
 */
@Controller
@RequestMapping("/index")
public class AbnormalEventController {
    @Autowired
    private AbnormalEventService abnormalEventService;

    @RequestMapping("/abnormalEvent")
    @ResponseBody
    public JSONObject getRealAbnormalEvent(String regionId){
        JSONObject jsonObject = new JSONObject();
        List<AbnormalEvent> abnormalEventList = null;
        try{
            abnormalEventList = abnormalEventService.getRealAbnormalEventList(regionId);
            jsonObject.put("datas", abnormalEventList);
        }catch (RuntimeException e){
        }
        return jsonObject;
    }

}

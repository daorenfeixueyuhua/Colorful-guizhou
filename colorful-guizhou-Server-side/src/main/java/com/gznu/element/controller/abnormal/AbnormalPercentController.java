package com.gznu.element.controller.abnormal;

import com.alibaba.fastjson.JSONObject;
import com.gznu.element.entity.abnormal.AbnormalPercent;
import com.gznu.element.service.abnormal.AbnormalPercentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author dage
 * @date 2019/04/01
 */
@Controller
@RequestMapping("/index/abnormalPercent")
public class AbnormalPercentController {
    @Autowired private AbnormalPercentService abnormalPercentService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AbnormalPercentController.class);
    @RequestMapping("/history")
    @ResponseBody
    public JSONObject getAbnormalPercent(String regionId, String startTime, String endTime){
        JSONObject jsonObject = new JSONObject();
        List<AbnormalPercent> datas = null;
        try{
            datas = abnormalPercentService.getAbnormalPercent(regionId, startTime, endTime);
        }catch (RuntimeException e){
            String args = "regionId: "+regionId + " startTime: "+startTime +" endTime: "+endTime;
            LOGGER.info("异常历史百分比统计异常 "+ args);
        }
        jsonObject.put("datas", datas);
        return jsonObject;
    }
    @RequestMapping("/real")
    @ResponseBody
    public JSONObject getAbnormalPercent(String regionId){
        JSONObject jsonObject = new JSONObject();
        List<AbnormalPercent> datas = null;
        try{
            datas = abnormalPercentService.getAbnormalPercent(regionId);
        }catch (RuntimeException e){
            String args = "regionId: "+regionId;
            LOGGER.info("异常实时百分比统计异常 "+ args);
        }
        jsonObject.put("datas", datas);
        return jsonObject;
    }
}

package com.gznu.element.service.abnormal;

import com.google.common.base.Joiner;
import com.gznu.element.dao.abnormal.AbnormalDao;
import com.gznu.element.entity.abnormal.AbnormalPercent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AbnormalPercentService implements AbnormalPercentApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbnormalPercentService.class);

    @Autowired private AbnormalDao abnormalDao;

    @Override
    public List<AbnormalPercent> getAbnormalPercent(String regionId, String startTime, String endTime) {
        List<AbnormalPercent> abnormalPercentList = new ArrayList<>();
        List<String> manholeIdList;
        List<String> pipeIdList;
        List<String> abnormalStatusList = new ArrayList<>();
        Map<String, Integer> abnormalMap = new HashMap<>();
        try{
            manholeIdList = abnormalDao.getManholeIdByRegionId(regionId);
            pipeIdList = abnormalDao.getPipeIdByManholeId(Joiner.on("','").join(manholeIdList));

            List<String> temp1 = abnormalDao.getHistoryAbnormalStatusByManholeIdLimitTime(Joiner.on("','").join(manholeIdList), startTime, endTime);
            List<String> temp2 = abnormalDao.getHistoryAbnormalStatusByPipeIdLimitTime(Joiner.on("','").join(pipeIdList), startTime, endTime);
            if(temp1.size()!=0){
                abnormalStatusList.addAll(temp1);
            }
            if(temp2.size()!=0) {
                abnormalStatusList.addAll(temp2);
            }
            // 统计各种状态的数量

            for(int i = 0; i<abnormalStatusList.size();i++){
                if(abnormalMap.get(abnormalStatusList.get(i))==null){
                    abnormalMap.put(abnormalStatusList.get(i), 1);
                }else{
                    abnormalMap.put(abnormalStatusList.get(i), abnormalMap.get(abnormalStatusList.get(i))+1);
                }
            }

            int countAbnormalStatus = abnormalStatusList.size();
            if(countAbnormalStatus == 0){
                countAbnormalStatus = 1;
            }

            for(String key : abnormalMap.keySet()){
                AbnormalPercent abnormalPercent = new AbnormalPercent();
                abnormalPercent.setAbnormalName(key);
                abnormalPercent.setAbnormalCount(abnormalMap.get(key));
                // 异常比例 = 异常次数 / 总次数
                abnormalPercent.setAbnormalPercent(abnormalPercent.getAbnormalCount()*1.0/countAbnormalStatus);
                abnormalPercentList.add(abnormalPercent);
            }
        }catch (Exception e){
            String msg = "查询历史异常百分比失败";
            LOGGER.info(msg+e.getMessage());
            throw new RuntimeException(msg);
        }
        return abnormalPercentList;
    }

    @Override
    public List<AbnormalPercent> getAbnormalPercent(String regionId) {
        List<AbnormalPercent> abnormalPercentList = new ArrayList<>();
        List<String> manholeIdList;
        List<String> pipeIdList;
        List<String> abnormalStatusList = new ArrayList<>();
        Map<String, Integer> abnormalMap = new HashMap<>();
        try{
            manholeIdList = abnormalDao.getManholeIdByRegionId(regionId);
            pipeIdList = abnormalDao.getPipeIdByManholeId(Joiner.on("','").join(manholeIdList));

            List<String> temp1 = abnormalDao.getRealAbnormalStatusByManholeIdLimitTime(Joiner.on("','").join(manholeIdList));
            List<String> temp2 = abnormalDao.getRealAbnormalStatusByPipeIdLimitTime(Joiner.on("','").join(pipeIdList));
            if(temp1.size()!=0){
                abnormalStatusList.addAll(temp1);
            }
            if(temp2.size()!=0) {
                abnormalStatusList.addAll(temp2);
            }
            // 统计各种状态的数量

            for(int i = 0; i<abnormalStatusList.size();i++){
                if(abnormalMap.get(abnormalStatusList.get(i))==null){
                    abnormalMap.put(abnormalStatusList.get(i), 1);
                }else{
                    abnormalMap.put(abnormalStatusList.get(i), abnormalMap.get(abnormalStatusList.get(i))+1);
                }
            }

            int countAbnormalStatus = abnormalStatusList.size();
            if(countAbnormalStatus == 0){
                countAbnormalStatus = 1;
            }

            for(String key : abnormalMap.keySet()){
                AbnormalPercent abnormalPercent = new AbnormalPercent();
                abnormalPercent.setAbnormalName(key);
                abnormalPercent.setAbnormalCount(abnormalMap.get(key));
                // 异常比例 = 异常次数 / 总次数
                abnormalPercent.setAbnormalPercent(abnormalPercent.getAbnormalCount()*1.0/countAbnormalStatus);
                abnormalPercentList.add(abnormalPercent);
            }
        }catch (Exception e){
            String msg = "查询实时异常百分比失败";
            LOGGER.info(msg+e.getMessage());
            throw new RuntimeException(msg);
        }
        return abnormalPercentList;
    }
}

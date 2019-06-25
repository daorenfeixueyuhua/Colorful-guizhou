package com.gznu.element.service.abnormal;

import com.google.common.base.Joiner;
import com.gznu.element.dao.abnormal.AbnormalEventDao;
import com.gznu.element.entity.abnormal.AbnormalEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dage
 * @date 2019/04/16
 */
@Service
public class AbnormalEventService implements AbnormalEventApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbnormalEventService.class);
    @Autowired
    private AbnormalEventDao abnormalEventDao;
    /**
     * 返回实时异常事件
     *
     * @param regionId
     * @return
     */
    @Override
    public List<AbnormalEvent> getRealAbnormalEventList(String regionId) {
        List<AbnormalEvent> abnormalEventList = new ArrayList<>();
        try{
            int startIndex = 0;
            int endIndex = 10;
            abnormalEventList.addAll(abnormalEventDao.getManholeAbnormalEventByRegionId(regionId, startIndex, endIndex));
            abnormalEventList.addAll(abnormalEventDao.getPipeAbnormalEventByRegionId(regionId, startIndex, endIndex));
            // 按事件时间排序
            ComparatorAbnormalEvent comparator = new ComparatorAbnormalEvent();
            Collections.sort(abnormalEventList, comparator);
        }catch (Exception e){
            String message = "查询异常事件出错";
            LOGGER.error(message,e);
            throw new RuntimeException();
        }
        return abnormalEventList;
    }

    /**
     * 比较函数
     */
    class ComparatorAbnormalEvent implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            AbnormalEvent a1 = (AbnormalEvent)o1;
            AbnormalEvent a2 = (AbnormalEvent)o2;
            int flag = 0;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                Date d1 = dateFormat.parse(a1.getTime());
                Date d2 = dateFormat.parse(a2.getTime());
                if(d1.getTime()<d2.getTime()) {
                    flag = 1;
                }
            }catch (Exception  e){
                throw new RuntimeException("时间转换错误");
            }
            return flag;
        }
    }

}

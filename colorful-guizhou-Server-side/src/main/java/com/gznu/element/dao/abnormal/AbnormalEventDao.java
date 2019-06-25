package com.gznu.element.dao.abnormal;

import com.gznu.element.entity.abnormal.AbnormalEvent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

public interface AbnormalEventDao {

    /**
     * 获取井异常事件
     */
    @Select("select time, type, position, description\n" +
            "from\n" +
            "     (select `current_time` as time, event_type as type, event_target_id as position, event_state as description from sys_event_info where event_state != 1) as event\n" +
            "natural join\n" +
            "      (select manhole_id as position from sys_manhole_cover where region_id = #{regionId} ) as manhole\n" +
            "order by time limit #{startIndex}, #{endIndex};")
    List<AbnormalEvent> getManholeAbnormalEventByRegionId(@Param("regionId") String regionId, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    /**
     * 获取管道异常事件
     */
    @Select("select time, type, position, description\n" +
            "from\n" +
            "    (select `current_time` as time, event_type as type, event_target_id as position, event_state as description from sys_event_info where event_state != 5) as event\n" +
            "natural join\n" +
            "    (select pipe_id as position from (select manhole_id as inflow_manhole_id from sys_manhole_cover where region_id = #{regionId}) as manhole natural join sys_manhole_pipe) as pipe\n" +
            "order by time limit #{startIndex}, #{endIndex};")
    List<AbnormalEvent> getPipeAbnormalEventByRegionId(@Param("regionId") String regionId, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);
}

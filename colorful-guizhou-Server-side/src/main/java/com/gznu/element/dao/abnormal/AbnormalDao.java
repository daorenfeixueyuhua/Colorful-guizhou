package com.gznu.element.dao.abnormal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AbnormalDao {

    /**
     * 根据地区id获取，该地区下的所有井id
     * @param regionId 地区id
     * @return list<井id>
     */
    @Select("select manhole_id from sys_manhole_cover where region_id = #{regionId};")
    List<String> getManholeIdByRegionId(@Param("regionId") String regionId);

    /**
     * 根据地区id获取该地区下的所有管道id  不适用
     * @param regionId
     * @return
     */
    @Select("select pipe_id from sys_pipe_info where region_id = #{regionId};")
    List<String> getPipeIdByRegionId(@Param("regionId") String regionId);

    /**
     * 根据井id获取与井id相关联的管道id
     * @param manholeId 井id
     * @return list<管道id>
     */
    @Select("select pipe_id from sys_manhole_pipe where flowout_manhole_id in ('${manholeId}');")
    List<String> getPipeIdByManholeId(@Param("manholeId") String manholeId);

    @Select("select manhole_state from sys_manhole_history_state where manhole_id in ('${manholeId}') and sys_manhole_history_state.`current_time` >= #{startTime} and sys_manhole_history_state.`current_time` <= #{endTime};")
    List<String> getHistoryAbnormalStatusByManholeIdLimitTime(@Param("manholeId") String manholeId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select pipe_state from sys_pipe_history_state where pipe_id in ('${pipeId}') and sys_pipe_history_state.`current_time` >= #{startTime} and sys_pipe_history_state.`current_time` <= #{endTime};")
    List<String> getHistoryAbnormalStatusByPipeIdLimitTime(@Param("pipeId") String pipeId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select manhole_state from sys_manhole_state where manhole_id in ('${manholeId}');")
    List<String> getRealAbnormalStatusByManholeIdLimitTime(@Param("manholeId") String manholeId);

    @Select("select pipe_state from sys_pipe_state where pipe_id in ('${pipeId}');")
    List<String> getRealAbnormalStatusByPipeIdLimitTime(@Param("pipeId") String pipeId);

}

package com.gznu.element.dao.pipeCircuit;

import com.gznu.element.entity.pipeCircuit.PipeCircuit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PipeCircuitDao {

    @Select("select pipe_circuit_id, start_pipe_id, end_pipe_id from sys_pipe_circuit where region_id = #{regionId};")
    List<PipeCircuit> getPipeCircuitInfoByRegion(@Param("regionId") String regionId);




}

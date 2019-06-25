package com.gznu.element.dao.landscape;

import com.gznu.element.entity.landscape.Landscape;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LanscapeDao {
    @Insert("insert into gz_landscape (landscape_id, landscape_type, landscape_name, region_id, price,  introduction) " +
            "value (#{landscape.landscapeId}, #{landscape.landscapeType}, #{landscape.landscapeName}," +
            "#{landscape.regionId}, #{landscape.price}, #{landscape.introduction});")
    int addLandscape(@Param("landscape") Landscape landscape);

    @Delete("delete from gz_landscape where landscape_id = #{landscapeId};")
    int deleteLandscape(@Param("landscapeId") String landscapeId);

    @Select("select landscape_id, landscape_type, landscape_name, region_id, price, introduction from gz_landscape limit #{startIndex}, #{pageSize};")
    List<Landscape> findAllLandscape(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Update("update gz_landscape set landscape_type = #{landscape.landscapeType}, landscape_name = #{landscape.landscapeName}," +
            "region_id = #{landscape.regionId}, price = #{landscape.price}, introduction = #{landscape.introduction} " +
            "where landscape_id = #{landscape.landscapeId};")
    int updateLandscapeSelective(@Param("landscape") Landscape landscape);

    @Select("select count(*) from gz_landscape where landscape_id = #{landscapeId}")
    int hasLandscape(@Param("landscapeId") String landscapeId);

    @Select("select count(landscape_id) from gz_landscape;")
    int coutLandscape();

    @Select("select landscape_id, landscape_type, landscape_name, region_id, price, introduction from gz_landscape where landscape_id = #{landscapeId};")
    Landscape selectOne(@Param("landscapeId") String landscapeId);
}

package com.gznu.element.dao.region;

import com.gznu.element.entity.region.Region;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface RegionDao {

    @Insert("insert into gz_region\n" +
            "    (region_id, region_name, super_region_id) \n" +
            "    VALUE (#{region.regionId}, #{region.regionName}, #{region.superRegionId});")
    int addRegion(@Param("region") Region region);

    @Delete("delete from gz_region where region_id = #{regionId}")
    int delRegion(@Param("regionId") String regionId);

    @Update("update gz_region set region_name = #{region.regionName}, super_region_id = #{region.superRegionId} where region_id = #{region.regionId};")
    int updRegion(@Param("region") Region region);

    @Select("select region_id, region_name, super_region_id from gz_region limit #{startIndex}, #{pageSize};")
    List<Region> findAll(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("select count(*) from gz_region where region_id = #{regionId}")
    int hasRegion(@Param("regionId") String regionId);

    @Select("select count(region_id) from gz_region;")
    int countRegion();

    @Select("select region_id, region_name, super_region_id from gz_region where region_id = #{regionId};")
    Region selectRegionByID(@Param("regionId") String regionId);

}

package com.gznu.element.dao.delicacy;

import com.gznu.element.entity.delicacy.Delicacy;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DelicacyDao {
    @Insert("insert into gz_delicacy (delicacy_id, delicacy_type, delicacy_name, region_id, price, introduction)" +
            " value (#{delicacy.delicacyId}, #{delicacy.delicacyType}, #{delicacy.delicacyName}, " +
            "#{delicacy.regionId}, #{delicacy.price}, #{delicacy.introduction});")
    int addDelicacy(@Param("delicacy") Delicacy delicacy);

    @Delete("delete from gz_delicacy where delicacy_id = #{delicacyId};")
    int delete(@Param("delicacyId") String delicacyId);

    @Select("select delicacy_id, delicacy_type, delicacy_name, region_id, price, introduction from gz_delicacy limit #{startIndex}, #{pageSize};")
    List<Delicacy> findAllDelicacy(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Update("update gz_delicacy set delicacy_type = #{delicacy.delicacyType}, delicacy_name = #{delicacy.delicacyName}," +
            " region_id = #{delicacy.regionId}, price = #{delicacy.price}, introduction = #{delicacy.introduction}" +
            "where delicacy_id = #{delicacy.delicacyId};")
    int updateDelicacySelective(@Param("delicacy") Delicacy delicacy);

    @Select("select count(delicacy_id) from gz_delicacy where delicacy_id = #{delicacyId};")
    int hasDelicacy(String delicacyId);

    @Select("select count(delicacy_id) from gz_delicacy;")
    int countDelicacy();

    @Select("select delicacy_id, delicacy_type, delicacy_name, region_id, price, introduction from gz_delicacy where delicacy_id = #{delicacyId};")
    Delicacy selectOne(@Param("delicacyId") String delicacyId);
}

package com.gznu.element.dao.user;

import com.gznu.element.entity.user.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select user_name, pass_word, name, gender, birthday, region_id from gz_user limit #{startIndex}, #{pageSize};")
    List<User> findAll(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Delete("update gz_user set lock = 1 where user_name = #{userName};")
    int lockeUser(@Param("userName") String userName);

    @Select("select count(user_name) from gz_user;")
    int countAllUser();
}

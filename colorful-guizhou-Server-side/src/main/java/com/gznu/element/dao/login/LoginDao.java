package com.gznu.element.dao.login;

import com.gznu.element.entity.manger.MangerInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {
    /**
     * 返回用户名和密码
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Select("select su.user_name,su.pass_word from sys_user su where su.user_name = #{username}")
    MangerInfo selectUserUserPrincipalById(@Param("username") String username);
}

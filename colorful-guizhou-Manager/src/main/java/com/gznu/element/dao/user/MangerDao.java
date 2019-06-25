package com.gznu.element.dao.user;

import com.gznu.element.entity.manger.MangerInfo;
import org.apache.ibatis.annotations.*;

//
//
//class UserProvider{
//    private final String TABLE = "sys_user";
//
//    public String deleteUserByUserName(List<String> userName){
//        SQL sql = new SQL().DELETE_FROM(TABLE);
//        StringBuilder condition = new StringBuilder();
//        condition.append("(");
//        for(int i=0;i<userName.size();++i){
//            if(i!=0) {
//                condition.append("," + userName.get(i));
//            }
//            else{
//                condition.append(userName.get(i));
//            }
//        }
//        condition.append(")");
//        sql.WHERE("user_name in "+condition);
//        return sql.toString();
//    }
//}
//

/**
 * @author dada
 */
public interface MangerDao {
    /**
     * 返回用户名和密码
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Select("select manager_name, manager_password from gz_manager where manager_name = #{username};")
    MangerInfo selectMangerPrincipalById(@Param("username") String username);




}
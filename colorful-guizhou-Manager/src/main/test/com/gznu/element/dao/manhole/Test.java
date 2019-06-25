package com.gznu.element.dao.manhole;

import com.google.common.base.Joiner;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dage
 * @date 2019/01/14
 */

class UserProvider {
    private final String TABLE = "sys_user";

    public String deleteUserByUserName(List<String> userName) {
        SQL sql = new SQL().DELETE_FROM(TABLE);
        StringBuilder condition = new StringBuilder();
        condition.append("(");
        for (int i = 0; i < userName.size(); ++i) {
            if (i != 0) {
                condition.append("," + userName.get(i));
            } else {
                condition.append(userName.get(i));
            }
        }
        condition.append(")");
        sql.WHERE("user_name in " + condition);
        return sql.toString();
    }
}

public class Test {

    @org.junit.Test
    public void run() {
        List<String> list = new ArrayList<>();
        list.add("pengda");
        list.add("dage");
        list.add("dada");

        System.out.println(Joiner.on("','").join(list));
    }
}

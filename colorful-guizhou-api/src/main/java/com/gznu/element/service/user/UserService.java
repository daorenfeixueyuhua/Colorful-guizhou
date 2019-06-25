package com.gznu.element.service.user;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;

public interface UserService {
    /**
     * 分页查询所有用户数据
     * @param query
     * @return
     */
    PagingQueryData findAllUser(PagingQuery query);

    /**
     * 锁定该用户
     * @param userName
     * @return
     */
    int lockUser(String userName);
}

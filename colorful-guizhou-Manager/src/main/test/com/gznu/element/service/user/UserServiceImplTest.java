package com.gznu.element.service.user;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-transaction.xml"})
public class UserServiceImplTest {
    @Autowired private UserService userService;
    @Test
    public void findAllUser() {
        PagingQueryData<User> data = null;
        try {
            PagingQuery query = new PagingQuery();
            query.setCurrentPage(1);
            query.setPageSize(20);
            data = userService.findAllUser(query);
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }

    @Test
    public void lockUser() {
    }
}
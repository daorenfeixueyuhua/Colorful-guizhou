package com.gznu.element.service.user;

import com.gznu.element.dao.user.UserDao;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;

import com.gznu.element.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    /**
     * 分页查询所有用户数据
     *
     * @param query
     * @return
     */
    @Override
    public PagingQueryData findAllUser(PagingQuery query) {
        PagingQueryData<User> data = new PagingQueryData<>();
        List<User> userList = null;
        int cnt = 0;
        try{
            cnt = userDao.countAllUser();
            data = initPage(data, cnt, query);
            userList = userDao.findAll(query.getStartIndex(), query.getPageSize());
            data.setDatas(userList);
        }catch (Exception e){
            LOGGER.error("查询用户失败: " + e.getMessage());
            throw new RuntimeException();
        }
        return data;
    }

    /**
     * 锁定该用户
     *
     * @param userName
     * @return
     */
    @Override
    public int lockUser(String userName) {
        try{
            userDao.lockeUser(userName);
        }catch (Exception e){
            LOGGER.error("锁定" + userName + "失败： " + e.getMessage());
            throw new RuntimeException();
        }
        return 0;
    }



    private PagingQueryData<User> initPage(PagingQueryData<User> page, int pageCount,
                                           PagingQuery pagingQuery) {
        page.setTotalRecord(pageCount);// 设置总记录数
        page.setCurrentPage(pagingQuery.getCurrentPage());// 设置当前页
        page.setPageSize(pagingQuery.getPageSize());// 设置每页显示行数
        page.setTotalPage();// 设置总页数
        page.setStartRecord();// 设置起始记录数
        pagingQuery.setStartIndexEndIndex();// 设置开始行和结束行
        return page;
    }
}

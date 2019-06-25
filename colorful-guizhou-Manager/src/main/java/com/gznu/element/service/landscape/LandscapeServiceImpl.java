package com.gznu.element.service.landscape;

import com.gznu.element.dao.landscape.LanscapeDao;
import com.gznu.element.entity.landscape.Landscape;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandscapeServiceImpl implements LandscapeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LandscapeServiceImpl.class);
    @Autowired
    private LanscapeDao lanscapeDao;

    /**
     * 插入一个新的landscape
     *
     * @param landscape
     * @return
     */
    @Override
    public int insertLandscape(Landscape landscape) {
        int cnt = 0;
        try {
            if (lanscapeDao.hasLandscape(landscape.getLandscapeId()) == 1) {
                cnt = -1;
            } else {
                cnt = lanscapeDao.addLandscape(landscape);
            }
        } catch (Exception e) {
            LOGGER.error("插入landscape: " + landscape.toString() + "失败" + e.getMessage());
            throw new RuntimeException();
        }
        return cnt;
    }

    /**
     * 删除一个landscape
     *
     * @param landscapeID
     * @return
     */
    @Override
    public int deleteLandscape(String landscapeID) {
        int cnt = 0;
        try {
            // 不存在
            if (lanscapeDao.hasLandscape(landscapeID) == 0) {
                cnt = -1;
            } else {
                cnt = lanscapeDao.deleteLandscape(landscapeID);
            }
        } catch (Exception e) {
            LOGGER.error("删除Landscape: " + landscapeID + "失败： " + e.getMessage());
        }
        return cnt;
    }

    /**
     * 分页查询所有数据
     *
     * @param query
     * @return
     */
    @Override
    public PagingQueryData selectAllLandscape(PagingQuery query) {
        PagingQueryData<Landscape> data = new PagingQueryData<>();
        int cnt = 0;
        List<Landscape> landscapeList = null;
        try {
            cnt = lanscapeDao.coutLandscape();
            data = initPage(data, cnt, query);
            landscapeList = lanscapeDao.findAllLandscape(query.getStartIndex(), query.getPageSize());
            data.setDatas(landscapeList);
        } catch (Exception e) {
            LOGGER.error("查询region失败： " + e.getMessage());
            throw new RuntimeException();
        }
        return data;
    }

    /**
     * 修改一个landscape
     *
     * @param landscape
     * @return
     */
    @Override
    public int updateLandscape(Landscape landscape) {
        int cnt = 0;
        try {
            cnt = lanscapeDao.updateLandscapeSelective(landscape);
        } catch (Exception e) {
            LOGGER.error("更新Landscape: " + landscape.toString() + " 失败: " + e.getMessage());
        }
        return cnt;
    }

    @Override
    public Landscape selectLandscapeByID(String landscapeId) {
        Landscape landscape = null;
        try {
            landscape = lanscapeDao.selectOne(landscapeId);
        } catch (Exception e) {
            LOGGER.error("查询Landscape: " + landscapeId + " 失败: " + e.getMessage());
        }
        return landscape;

    }

    private PagingQueryData<Landscape> initPage(PagingQueryData<Landscape> page, int pageCount,
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

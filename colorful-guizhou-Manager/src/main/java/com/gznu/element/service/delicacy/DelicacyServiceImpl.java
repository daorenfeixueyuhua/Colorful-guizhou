package com.gznu.element.service.delicacy;

import com.gznu.element.dao.delicacy.DelicacyDao;
import com.gznu.element.entity.delicacy.Delicacy;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelicacyServiceImpl implements DelicacyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelicacyServiceImpl.class);
    @Autowired
    private DelicacyDao delicacyDao;

    /**
     * 插入一个新的delicacy
     *
     * @param delicacy
     * @return
     */
    @Override
    public int insertDelicacy(Delicacy delicacy) {
        int cnt = 0;
        try {
            if (delicacyDao.hasDelicacy(delicacy.getDelicacyId()) == 1) {
                cnt = -1;
            } else {
                cnt = delicacyDao.addDelicacy(delicacy);
            }
        } catch (Exception e) {
            LOGGER.error("插入Delicacy: " + delicacy.toString() + "失败" + e.getMessage());
            throw new RuntimeException();
        }
        return cnt;
    }

    /**
     * 删除delicacy
     *
     * @param delicacyID
     * @return
     */
    @Override
    public int deleteDelicacy(String delicacyID) {
        int cnt = 0;
        try {
            // 不存在
            if (delicacyDao.hasDelicacy(delicacyID) == 0) {
                cnt = -1;
            } else {
                cnt = delicacyDao.delete(delicacyID);
            }
        } catch (Exception e) {
            LOGGER.error("删除Delicacy: " + delicacyID + "失败： " + e.getMessage());
        }
        return cnt;
    }

    /**
     * 查询所有，并分页显示
     *
     * @param query
     * @return
     */
    @Override
    public PagingQueryData selectAllDelicacy(PagingQuery query) {
        PagingQueryData<Delicacy> data = new PagingQueryData<>();
        int cnt = 0;
        List<Delicacy> delicacyList = null;
        try {
            cnt = delicacyDao.countDelicacy();
            data = initPage(data, cnt, query);
            delicacyList = delicacyDao.findAllDelicacy(query.getStartIndex(), query.getPageSize());
            data.setDatas(delicacyList);
        } catch (Exception e) {
            LOGGER.error("查询Delicacy失败： " + e.getMessage());
            throw new RuntimeException();
        }
        return data;
    }

    /**
     * 修改delicacy
     *
     * @param delicacy
     * @return
     */
    @Override
    public int updateDelicacy(Delicacy delicacy) {
        int cnt = 0;
        try {
            cnt = delicacyDao.updateDelicacySelective(delicacy);
        } catch (Exception e) {
            LOGGER.error("更新Delicacy: " + delicacy.toString() + " 失败: " + e.getMessage());
        }
        return cnt;
    }

    @Override
    public Delicacy selectDelicacyByID(String delicacyId) {
        Delicacy delicacy = null;
        try {
            delicacy = delicacyDao.selectOne(delicacyId);
        } catch (Exception e) {
            LOGGER.error("查询Delicacy: " + delicacyId + " 失败: " + e.getMessage());
        }
        return delicacy;
    }

    private PagingQueryData<Delicacy> initPage(PagingQueryData<Delicacy> page, int pageCount,
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

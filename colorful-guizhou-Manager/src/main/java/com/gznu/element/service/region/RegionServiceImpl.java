package com.gznu.element.service.region;

import com.gznu.element.dao.region.RegionDao;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.entity.region.Region;
import com.gznu.element.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegionServiceImpl.class);
    @Autowired
    private RegionDao regionDao;

    /**
     * 插入region
     *
     * @param region
     * @return
     */
    @Override
    public int insertRegion(Region region) {
        try {
            if (regionDao.hasRegion(region.getRegionId()) == 1) {
                return 1;
            }
            regionDao.addRegion(region);
        } catch (Exception e) {
            LOGGER.error("region插入失败： " + e.getMessage());
            throw new RuntimeException();
        }
        return 0;
    }

    /**
     * 删除region
     *
     * @param regionId
     * @return
     */
    @Override
    public int deleteRegion(String regionId) {
        int cnt = 0;
        try {
            // 不存在
            if (regionDao.hasRegion(regionId) == 0) {
                cnt = -1;
            } else {
                cnt = regionDao.delRegion(regionId);
            }
        } catch (Exception e) {
            LOGGER.error("删除region失败： " + e.getMessage());
        }
        return cnt;
    }

    /**
     * 分页查询所有region
     *
     * @param query
     * @return
     */
    @Override
    public PagingQueryData selectAllRegion(PagingQuery query) {
        PagingQueryData<Region> data = new PagingQueryData<>();
        int cnt = 0;
        List<Region> regionList = null;
        try {
            cnt = regionDao.countRegion();
            data = initPage(data, cnt, query);
            regionList = regionDao.findAll(query.getStartIndex(), query.getPageSize());
            data.setDatas(regionList);
        } catch (Exception e) {
            LOGGER.error("查询region失败： " + e.getMessage());
            throw new RuntimeException();
        }
        return data;
    }

    /**
     * 更新region
     *
     * @param region
     * @return
     */
    @Override
    public int updateRegion(Region region) {
        int cnt = 0;
        try {
            cnt = regionDao.updRegion(region);
        } catch (Exception e) {
            LOGGER.error("更新region: " + region.toString() + " 失败: " + e.getMessage());
        }
        return cnt;
    }

    @Override
    public Region selectAllRegionById(String regionId) {
        Region region = null;
        try {
            region = regionDao.selectRegionByID(regionId);
        } catch (Exception e) {
            LOGGER.error("查询 " + regionId + " 失败 " + e.getMessage());
        }
        return region;
    }

    private PagingQueryData<Region> initPage(PagingQueryData<Region> page, int pageCount,
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

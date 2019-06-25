package com.gznu.element.service.region;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.entity.region.Region;

public interface RegionService {
    /**
     * 插入region
     * @param region
     * @return
     */
    int insertRegion(Region region);

    /**
     * 删除region
     * @param regionId
     * @return
     */
    int deleteRegion(String regionId);

    /**
     * 分页查询所有region
     * @param query
     * @return
     */
    PagingQueryData selectAllRegion(PagingQuery query);

    /**
     * 更新region
     * @param region
     * @return
     */
    int updateRegion(Region region);

    /**
     * 更具regionId查询
     * @param regionID
     * @return
     */
    Region selectAllRegionById(String regionID);
}

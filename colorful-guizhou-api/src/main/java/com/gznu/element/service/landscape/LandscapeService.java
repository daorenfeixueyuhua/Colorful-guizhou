package com.gznu.element.service.landscape;

import com.gznu.element.entity.landscape.Landscape;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;

public interface LandscapeService {
    /**
     * 插入一个新的landscape
     * @param landscape
     * @return
     */
    int insertLandscape(Landscape landscape);

    /**
     * 删除一个landscape
     * @param landscapeID
     * @return
     */
    int deleteLandscape(String landscapeID);

    /**
     * 分页查询所有数据
     * @param query
     * @return
     */
    PagingQueryData selectAllLandscape(PagingQuery query);

    /**
     * 修改一个landscape
     * @param landscape
     * @return
     */
    int updateLandscape(Landscape landscape);

    /**
     * 根据landscape查询
     * @param landscapeId
     * @return
     */
    Landscape selectLandscapeByID(String landscapeId);
}

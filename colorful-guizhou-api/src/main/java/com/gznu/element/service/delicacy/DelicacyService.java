package com.gznu.element.service.delicacy;

import com.gznu.element.entity.delicacy.Delicacy;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;

import java.util.List;

public interface DelicacyService {
    /**
     * 插入一个新的delicacy
     * @param delicacy
     * @return
     */
    int insertDelicacy(Delicacy delicacy);

    /**
     * 删除delicacy
     * @param delicacyID
     * @return
     */
    int deleteDelicacy(String delicacyID);

    /**
     * 查询所有，并分页显示
     * @param query
     * @return
     */
    PagingQueryData selectAllDelicacy(PagingQuery query);

    /**
     * 修改delicacy
     * @param delicacy
     * @return
     */
    int updateDelicacy(Delicacy delicacy);

    /**
     * 根据delicacyID查询
     * @param delicacyId
     * @return
     */
    Delicacy selectDelicacyByID(String delicacyId);
}


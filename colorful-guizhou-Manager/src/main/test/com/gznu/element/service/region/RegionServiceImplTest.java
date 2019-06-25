package com.gznu.element.service.region;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import com.gznu.element.entity.region.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-transaction.xml"})
public class RegionServiceImplTest {
    @Autowired private RegionService regionService;
    @Test
    public void insertRegion() {
        Region region = new Region();
        region.setRegionId("0100001");
        region.setRegionName("测试的地方");
        region.setSuperRegionId("01");
        try{
            regionService.insertRegion(region);
        }catch (RuntimeException e){
            System.out.println("测试失败");
        }
    }

    @Test
    public void selectAllRegion() {
        PagingQueryData<Region> data = null;
        try {
            PagingQuery query = new PagingQuery();
            query.setCurrentPage(1);
            query.setPageSize(20);
            data = regionService.selectAllRegion(query);
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }

    @Test
    public void updateRegion() {
        Region region = new Region();
        region.setRegionId("0100001");
        region.setRegionName("测试修改的地方");
        region.setSuperRegionId("01");
        try {
            regionService.updateRegion(region);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }
    @Test
    public void deleteRegion() {
        String regionID = "999999";
        try {
            regionService.deleteRegion(regionID);
        } catch (RuntimeException e) {
            System.out.println("测试失败");
        }
    }
}
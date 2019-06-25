package com.gznu.element.dao.region;

import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.region.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-transaction.xml"})
public class RegionDaoTest {
    @Autowired
    private RegionDao regionDao;
    @Test
    public void addRegionTest(){

        Region region = new Region();
        region.setRegionId("111111111111");
        region.setRegionName("000000000000");

        int c = regionDao.addRegion(region);
        System.out.println(c);
    }



    @Test
    public void showAddRegion(){
        PagingQuery query = new PagingQuery();
        query.setPageSize(20);
        query.setCurrentPage(1);
        List<Region> regions = regionDao.findAll(query.getStartIndex(), query.getPageSize());
        System.out.println(regions);
    }
}

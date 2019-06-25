package com.gznu.element.service.landscape;

import com.gznu.element.entity.landscape.Landscape;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-transaction.xml"})
public class LandscapeServiceImplTest {

    @Autowired
    private LandscapeService landscapeService;

    @Test
    public void insertLandscape() {
        Landscape landscape = new Landscape();
        landscape.setLandscapeId("999999");
        landscape.setLandscapeType("测试类");
        landscape.setLandscapeName("测试1");
        landscape.setPrice(90.0F);
        landscape.setRegionId("0101");
        landscape.setIntroduction("这是一个测试的东东！");

        try {
            landscapeService.insertLandscape(landscape);
        } catch (RuntimeException e) {
            System.out.println("测试失败！");
        }
    }


    @Test
    public void selectAllLandscape() {
        PagingQueryData<Landscape> data = null;
        try {
            PagingQuery query = new PagingQuery();
            query.setCurrentPage(1);
            query.setPageSize(20);
            data = landscapeService.selectAllLandscape(query);
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }

    @Test
    public void updateLandscape() {
        Landscape landscape = new Landscape();
        landscape.setLandscapeId("999999");
        landscape.setLandscapeType("测试类");
        landscape.setLandscapeName("测试1++++修改");
        landscape.setPrice(90.0F);
        landscape.setRegionId("0101");
        landscape.setIntroduction("这是一个测试的东东！");
        try {
            landscapeService.updateLandscape(landscape);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }

    @Test
    public void deleteLandscape() {
        String landcapyID = "999999";
        try {
            landscapeService.deleteLandscape(landcapyID);
        } catch (RuntimeException e) {
            System.out.println("测试失败");
        }
    }
}
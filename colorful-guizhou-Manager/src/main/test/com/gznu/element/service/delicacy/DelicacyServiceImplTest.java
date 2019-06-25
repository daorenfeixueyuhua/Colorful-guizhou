package com.gznu.element.service.delicacy;

import com.gznu.element.entity.delicacy.Delicacy;
import com.gznu.element.entity.pagingQuery.PagingQuery;
import com.gznu.element.entity.pagingQuery.PagingQueryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-transaction.xml"})
public class DelicacyServiceImplTest {
    @Autowired
    private DelicacyService delicacyService;

    @Test
    public void insertDelicacy() {
        Delicacy delicacy = new Delicacy();
        delicacy.setDelicacyId("9999999");
        delicacy.setDelicacyName("测试1");
        delicacy.setDelicacyType("测试类");
        delicacy.setPrice(90.0F);
        delicacy.setRegionId("0101");
        delicacy.setIntroduction("这是一个测试");
        try {
            delicacyService.insertDelicacy(delicacy);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }


    @Test
    public void selectAllDelicacy() {
        PagingQueryData<Delicacy> data = null;
        try {
            PagingQuery query = new PagingQuery();
            query.setCurrentPage(1);
            query.setPageSize(20);
            data = delicacyService.selectAllDelicacy(query);
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("测试失败");
        }

    }

    @Test
    public void updateDelicacy() {
        Delicacy delicacy = new Delicacy();
        delicacy.setDelicacyId("9999999");
        delicacy.setDelicacyName("测试1+修改");
        delicacy.setDelicacyType("测试类");
        delicacy.setPrice(90.0F);
        delicacy.setRegionId("0101");
        delicacy.setIntroduction("这是一个测试");
        try {
            delicacyService.updateDelicacy(delicacy);
        } catch (Exception e) {
            System.out.println("测试失败");
        }
    }

    @Test
    public void deleteDelicacy() {
        String delicacy = "9999999";
        try {
            delicacyService.deleteDelicacy(delicacy);
        } catch (RuntimeException e) {
            System.out.println("测试失败");
        }
    }
}
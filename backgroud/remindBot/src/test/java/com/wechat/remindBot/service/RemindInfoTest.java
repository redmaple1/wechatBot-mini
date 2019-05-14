package com.wechat.remindBot.service;

import com.avos.avoscloud.AVObject;
import com.wechat.remindBot.dos.RemindDO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemindInfoTest {

    @Autowired
    private RemindInfoService remindInfoService;

    @Test
    @Ignore
    public void testAddRemind(){
        RemindDO testRemind = new RemindDO();
        testRemind.setTitle("测试提醒1");
        testRemind.setSendTo("测试发送人1");
        testRemind.setCronExp("0 0 12,19 * * *");
        testRemind.setContent("测试提醒内容1");
        testRemind.setOwnerId("testOwnerId1");
        testRemind.setStatus(0);

        remindInfoService.addRemind(testRemind);
    }

    @Test
    @Ignore
    public void testUpdateRemind(){
        String objectId = "5cda7c9443e78c0065dd0435";
        RemindDO testRemind = new RemindDO();
        testRemind.setTitle("测试提醒1");
        testRemind.setSendTo("测试发送人1修改");
        testRemind.setCronExp("0 0 12,19 * * *");
        testRemind.setContent("测试提醒内容1修改");
        testRemind.setOwnerId("testOwnerId1");
        testRemind.setStatus(0);

        remindInfoService.updateRemind(objectId,testRemind);
    }

    @Test
    public void testGetRemindsByOwnerId(){
        String ownerId = "testOwnerId1";
        List<AVObject> remindsByOwnerId = remindInfoService.getRemindsByOwnerId(ownerId);
        System.out.println(remindsByOwnerId);
    }

}

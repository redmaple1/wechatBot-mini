package com.wechat.remindBot.service;

import com.wechat.remindBot.vo.TemplateMsgSendVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateMsgServiceTest {

    @Autowired
    private TemplateMsgService templateMsgService;

    @Test
    @Ignore
    public void testSendMsg(){
        TemplateMsgSendVO templateMsgSendVO = new TemplateMsgSendVO();
        templateMsgSendVO.setForm_id("a81dac1b1051477e9d4fdaf2e3b01cfe");
        templateMsgSendVO.setTemplate_id("CEi3HE3JM47Ojj5oZha7QPBCqzKFKMsJDYkY360qze4");
        templateMsgSendVO.setTouser("oM_VF46r2fC2y3U-eC92HvK13Mko");
        templateMsgService.sendMsg(templateMsgSendVO);
    }
}

package com.wechat.remindBot.service.impl;

import com.wechat.remindBot.service.AccessTokenService;
import com.wechat.remindBot.service.TemplateMsgService;
import com.wechat.remindBot.vo.TemplateMsgSendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateMsgServiceImpl implements TemplateMsgService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccessTokenService accessTokenService;

    @Override
    public void sendMsg(TemplateMsgSendVO templateMsgSendVO) {
        String accessToken = accessTokenService.getAccessToken();
        String sendUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + accessToken;

        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(sendUrl, templateMsgSendVO, Object.class);
    }
}

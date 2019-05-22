package com.wechat.remindBot.service.impl;

import com.alibaba.fastjson.JSON;
import com.wechat.remindBot.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private RestTemplate restTemplate;

    public final static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}";

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

    @Override
    public String getAccessToken() {
        Map<String,Object> params = new HashMap<>();

        params.put("APPID",appId);
        params.put("APPSECRET",appSecret);
        String result = restTemplate.getForObject(accessTokenUrl, String.class,params);
        Map resMap = (Map) JSON.parse(result);
        if (resMap.get("access_token") != null){
            return (String) resMap.get("access_token");
        }else {
            log.error("get access key from weChat error.");
            return null;
        }
    }
}

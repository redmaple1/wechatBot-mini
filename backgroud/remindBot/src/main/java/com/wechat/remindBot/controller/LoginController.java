package com.wechat.remindBot.controller;

import com.wechat.remindBot.vo.LoginSessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/remindBot")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

    @GetMapping("login")
    @ResponseBody
    public String getLoginSession(@RequestParam("js_code") String code){

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type=authorization_code";

        Map<String,Object> params = new HashMap<>();

        params.put("appid",appId);
        params.put("secret",appSecret);
        params.put("js_code",code);
        String result = restTemplate.getForObject(url, String.class,params);
        System.out.println(result);
        return result;
    }
}

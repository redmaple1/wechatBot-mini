package com.wechat.remindBot.controller;

import com.wechat.remindBot.util.json.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/remindBot")
public class FormIdController {

    @PostMapping("/formId")
    @ResponseBody
    public ApiResult sendTemplateMsg(@RequestParam("formId") String formId,
                                     @RequestParam("openId") String openId){

        return null;
    }

}

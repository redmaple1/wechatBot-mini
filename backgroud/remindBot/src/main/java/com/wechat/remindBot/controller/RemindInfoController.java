package com.wechat.remindBot.controller;

import com.wechat.remindBot.dos.RemindDO;
import com.wechat.remindBot.service.RemindInfoService;
import com.wechat.remindBot.util.json.ApiResult;
import com.wechat.remindBot.vo.RemindInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/remindBot")
public class RemindInfoController {

    @Autowired
    private RemindInfoService remindInfoService;

    @PostMapping("/remindInfo")
    @ResponseBody
    public ApiResult addRemind(@RequestBody RemindInfoVO remindInfoVO){
        RemindDO remindDO = new RemindDO();
        BeanUtils.copyProperties(remindInfoVO,remindDO);
//        remindDO.setOwnerId(ownerId);
//        remindInfoService.addRemind(remindDO);
        return ApiResult.newSuccessResult();
    }

}

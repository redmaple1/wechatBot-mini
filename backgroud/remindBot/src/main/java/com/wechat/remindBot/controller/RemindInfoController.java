package com.wechat.remindBot.controller;

import com.avos.avoscloud.AVObject;
import com.wechat.remindBot.dos.RemindDO;
import com.wechat.remindBot.service.RemindInfoService;
import com.wechat.remindBot.util.json.ApiResult;
import com.wechat.remindBot.vo.RemindInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/remindBot")
public class RemindInfoController {

    @Autowired
    private RemindInfoService remindInfoService;

    @GetMapping("/remindInfo")
    @ResponseBody
    public ApiResult<List> getRemindList(@RequestParam("ownerId") String ownerId){
        List<AVObject> remindsByOwnerId = remindInfoService.getRemindsByOwnerId(ownerId);

        List<RemindInfoVO> result = remindsByOwnerId.stream().map(i -> {
            RemindInfoVO remindInfoVO = new RemindInfoVO();
            BeanUtils.copyProperties(i, remindInfoVO);
            return remindInfoVO;
        }).collect(Collectors.toList());

        return ApiResult.newSuccessResult(result);
    }

    @PostMapping("/remindInfo")
    @ResponseBody
    public ApiResult addRemind(@RequestBody RemindInfoVO remindInfoVO){
        RemindDO remindDO = new RemindDO();
        BeanUtils.copyProperties(remindInfoVO,remindDO);
//        remindDO.setOwnerId(ownerId);
//        remindInfoService.addRemind(remindDO);
        return ApiResult.newSuccessResult();
    }

    @PutMapping("/remindInfo")
    @ResponseBody
    public ApiResult editRemind(@RequestBody RemindInfoVO remindInfoVO){
        RemindDO remindDO = new RemindDO();
        BeanUtils.copyProperties(remindInfoVO,remindDO);
//        remindInfoService.updateRemind(remindInfoVO.getObjectId(),remindDO);
        return ApiResult.newSuccessResult();
    }

}

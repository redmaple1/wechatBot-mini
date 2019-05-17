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

        List<RemindInfoVO> result = remindsByOwnerId.stream().map(i ->cover(i)).collect(Collectors.toList());

        return ApiResult.newSuccessResult(result);
    }

    @GetMapping("/remindInfo/{objectId}")
    @ResponseBody
    public ApiResult<RemindInfoVO> getRemindByObjectId(@PathVariable("objectId") String objectId){
        AVObject remindByObjectId = remindInfoService.getRemindByObjectId(objectId);
        RemindInfoVO remindInfoVO = cover(remindByObjectId);
        return ApiResult.newSuccessResult(remindInfoVO);
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
        remindInfoService.updateRemind(remindInfoVO.getObjectId(),remindDO);
        return ApiResult.newSuccessResult();
    }

    private RemindInfoVO cover(AVObject source){
        RemindInfoVO remindInfoVO = new RemindInfoVO();
        remindInfoVO.setObjectId(source.getObjectId());
        remindInfoVO.setTitle(source.getString("title"));
        remindInfoVO.setSendTo(source.getString("sendTo"));
        remindInfoVO.setCronExp(source.getString("cronExp"));
        remindInfoVO.setContent(source.getString("content"));
        remindInfoVO.setOwnerId(source.getString("ownerId"));
        return remindInfoVO;
    }

}

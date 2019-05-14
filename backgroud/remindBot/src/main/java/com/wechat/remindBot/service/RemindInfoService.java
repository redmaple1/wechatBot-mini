package com.wechat.remindBot.service;


import com.avos.avoscloud.AVObject;
import com.wechat.remindBot.dos.RemindDO;

import java.util.List;

public interface RemindInfoService {

    /**
     * 添加提醒信息
     * @param remindDO
     */
    void addRemind(RemindDO remindDO);

    /**
     * 更新提醒信息
     * @param remindDO
     */
    void updateRemind(String objectId, RemindDO remindDO);

    /**
     * 根据ownerId获取提醒信息
     * @param ownerId
     * @return
     */
    List<AVObject> getRemindsByOwnerId(String ownerId);

}

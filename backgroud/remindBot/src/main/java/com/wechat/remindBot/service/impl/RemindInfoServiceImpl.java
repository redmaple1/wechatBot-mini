package com.wechat.remindBot.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.google.common.collect.Lists;
import com.wechat.remindBot.dos.RemindDO;
import com.wechat.remindBot.exception.ServiceException;
import com.wechat.remindBot.service.RemindInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RemindInfoServiceImpl implements RemindInfoService {

    public final static String REMINDINFO_TABLE_NAME = "RemindInfo";

    @Override
    public void addRemind(RemindDO remindDO) {
        AVObject remindInfo = new AVObject(REMINDINFO_TABLE_NAME);
        remindInfo.put("title", remindDO.getTitle());
        remindInfo.put("sendTo", remindDO.getSendTo());
        remindInfo.put("cronExp", remindDO.getCronExp());
        remindInfo.put("content", remindDO.getContent());
        remindInfo.put("ownerId",remindDO.getOwnerId());
        remindInfo.put("status",remindDO.getStatus());
        try {
            remindInfo.save();
            log.info("Add RemindInfo={} success.",remindInfo);
        } catch (AVException e) {
            log.error("Add RemindInfo failed. e={}",e);
            throw new ServiceException("创建提醒失败");
        }
    }

    @Override
    public void updateRemind(String objectId, RemindDO remindDO) {
        AVObject remindInfo = AVObject.createWithoutData(REMINDINFO_TABLE_NAME,objectId);
        remindInfo.put("title", remindDO.getTitle());
        remindInfo.put("sendTo", remindDO.getSendTo());
        remindInfo.put("cronExp", remindDO.getCronExp());
        remindInfo.put("content", remindDO.getContent());
        remindInfo.put("ownerId",remindDO.getOwnerId());
        remindInfo.put("status",remindDO.getStatus());
        try {
            remindInfo.save();
            log.info("Update RemindInfo={} where objectId={} success.",remindInfo,objectId);
        } catch (AVException e) {
            log.error("Update RemindInfo failed. e={}",e);
            throw new ServiceException("更新提醒失败");
        }
    }

    @Override
    public void delRemind(String objectId) {
        try {
            AVQuery.doCloudQuery("update RemindInfo set status=1 where objectId=?",objectId);
        } catch (Exception e) {
            log.error("delete remindInfo(id={}) failed",objectId,e);
            throw new ServiceException("删除提醒失败");
        }
    }

    @Override
    public List<AVObject> getRemindsByOwnerId(String ownerId) {
        AVQuery<AVObject> remindQuery = new AVQuery<>(REMINDINFO_TABLE_NAME);
        remindQuery.whereEqualTo("ownerId",ownerId);
        remindQuery.whereEqualTo("status",0);

        try {
            return remindQuery.find();
        } catch (AVException e) {
            log.error("query remindInfos with ownerId={} failed.",ownerId);
            return Lists.newArrayList();
        }
    }

    @Override
    public AVObject getRemindByObjectId(String objectId) {
        AVQuery<AVObject> remindQuery = new AVQuery<>(REMINDINFO_TABLE_NAME);
        try {
            return remindQuery.get(objectId);
        } catch (AVException e) {
            log.error("getRemindByObjectId({}) failed.",objectId);
            return new AVObject();
        }

    }
}

package com.wechat.remindBot.vo;

import lombok.Data;

@Data
public class RemindInfoVO {

    /**
     * objectId
     */
    private String objectId;

    /**
     * 提醒标题
     */
    private String title;

    /**
     * 被提醒人
     */
    private String sendTo;

    /**
     * cron表达式
     */
    private String cronExp;

    /**
     * 提醒内容
     */
    private String content;

    /**
     * 提醒的所有人
     */
    private String ownerId;

}

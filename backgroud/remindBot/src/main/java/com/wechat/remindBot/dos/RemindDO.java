package com.wechat.remindBot.dos;

import lombok.Data;

@Data
public class RemindDO {

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

    /**
     * 提醒状态 0:有效； 1:无效
     */
    private int status;
}

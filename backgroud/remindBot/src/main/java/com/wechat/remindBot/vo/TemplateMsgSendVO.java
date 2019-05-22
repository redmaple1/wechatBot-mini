package com.wechat.remindBot.vo;

import lombok.Data;

@Data
public class TemplateMsgSendVO {

    private String touser;

    private String template_id;

    private String form_id;

}

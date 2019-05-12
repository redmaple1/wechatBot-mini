package com.wechat.remindBot.vo;

import lombok.Data;

@Data
public class LoginSessionVO {
    private String openid;

    private String session_key;

    private String unionid;

    private Integer errcode;

    private String errmsg;
}

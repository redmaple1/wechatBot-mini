package com.wechat.remindBot.service;

import com.wechat.remindBot.vo.TemplateMsgSendVO;

public interface TemplateMsgService {

    void sendMsg(TemplateMsgSendVO templateMsgSendVO);

}

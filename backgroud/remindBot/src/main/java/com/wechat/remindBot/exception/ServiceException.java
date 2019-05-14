package com.wechat.remindBot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private int errCode;

    private String errMsg;

    public ServiceException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public ServiceException(Exception cause) {
        super(cause);
    }

    public ServiceException(Exception cause, String errMsg) {
        super(cause);
        this.errMsg = errMsg;
    }
}

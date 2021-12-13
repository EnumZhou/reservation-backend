package com.company.reservation.controller;

import com.company.reservation.util.MessageResult;

public class BaseController {
    protected MessageResult success() {
        return  new MessageResult(200,"SUCCESS");
    }
    protected MessageResult success(String msg) {
        return new MessageResult(200,msg);
    }
    protected MessageResult success(String msg, Object obj) {
        return new MessageResult(200,msg,obj);
    }
    protected MessageResult success(Object obj) {
        return new MessageResult(200,"SUCCESS",obj);
    }

    protected MessageResult error(String msg) {
        return new MessageResult(500,msg);
    }
    protected MessageResult error (int code, String msg) {
        return new MessageResult(code,msg);
    }
}

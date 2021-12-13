package com.company.reservation.util;

import lombok.Data;

@Data
public class MessageResult {
    private int code;
    private String message;
    private Object data;

    public MessageResult(int code, String message){
        this.code=code;
        this.message=message;
    }

    public MessageResult(int code, String message, Object data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }

}

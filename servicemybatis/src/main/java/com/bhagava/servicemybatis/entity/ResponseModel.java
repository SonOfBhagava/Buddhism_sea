package com.bhagava.servicemybatis.entity;

public class ResponseModel {

    public final static String SUCCESS = "SUCCESS";
    public final static String ERROR = "ERROR";

    private String rflag;
    private String msg;

    public String getRflag() {
        return rflag;
    }
    public void setRflag(String rflag) {
        this.rflag = rflag;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

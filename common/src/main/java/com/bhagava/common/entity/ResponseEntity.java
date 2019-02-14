package com.bhagava.common.entity;

/**
 * created by FeiJunhao on ${date}
 */
public class ResponseEntity {
    public final static String SUCCESS = "SUCCESS";
    public final static String ERROR = "ERROR";
    private String rflag;

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public Object getResData() {
        return resData;
    }

    public void setResData(Object resData) {
        this.resData = resData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Object resData;
    private String msg;

    private ResponseEntity(String rflag,Object resData,String msg){
        this.rflag = rflag;
        this.resData = resData;
        this.msg = msg;
    }

    public static ResponseEntity success(Object resData){
        return new ResponseEntity(SUCCESS,resData,"");
    }

    public static ResponseEntity error(String msg){
        return new ResponseEntity(ERROR,"",msg);
    }

}

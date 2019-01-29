package com.bhagava.common.entity;


import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 封存所有协议中返回字段的实体类
 */
@SuppressWarnings("all")
@Component(value = "ResponseEntity")
public class ResponseEntity implements Serializable {
	private static final long serialVersionUID = 5975812703584696361L;
	
	/**
	 * 成功状态码
	 */
	public static final String SUCCESS = "SUCCESS";
	/**
	 * 失败状态码
	 */
	public static final String ERROR = "ERROR";
	
	// 结果码
	private String rflag = "";
	// 结果值
	private String resdata = "";
	// 数据ID
	private String requestId = "";
	// 返回信息
	private String msg = "";
	// 全部完整的返回信息
	private String response = "";

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	/**
	 * 构造方法
	 * @param rflag
	 * @param resdata
	 * @param lsid
	 * @param rfmsg
	 * @param errmsg
	 */
	public ResponseEntity(String rflag, String requestId, String resdata, String msg) {
		this.rflag = rflag;
		this.resdata = resdata;
		this.requestId = requestId;
		this.msg = msg;
	}


	/**
	 * 生成成功结果
	 * @param resdata
	 * @return
	 */
	public static ResponseEntity success(String requestId, String resdata, String msg) {
		return new ResponseEntity(SUCCESS, requestId, resdata, msg);
	}
	
	/**
	 * 生成错误结果
	 * @param rflag
	 * @param resdata
	 * @param lsid
	 * @param rfmsg
	 * @param errmsg
	 * @return
	 */
	public static ResponseEntity error(String requestId, String resdata, String msg) {
		return new ResponseEntity(ERROR, requestId, resdata, msg);
	}
	
	/**
	 * 获取结果码
	 * @return
	 */
	public String getRflag() {
		return rflag;
	}
	
	/**
	 * 设置结果码
	 * @param rflag
	 */
	public void setRflag(String rflag) {
		this.rflag = rflag;
	}
	
	/**
	 * 获取结果值
	 * @return
	 */
	public String getResdata() {
		return resdata;
	}
	
	/**
	 * 设置结果值
	 * @param resdata
	 */
	public void setResdata(String resdata) {
		this.resdata = resdata;
	}


	public static void main(String[] args) {

		for(int i=0;i < 10000;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					ResponseEntity.error("s","s","s1wwwwwww").getMsg();
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					ResponseEntity.error("s","s","s1wwwwwww").getMsg();
				}
			}).start();
		}
	}
	@Override
	public String toString() {
		return "ResponseEntity [rflag=" + rflag + ", requestId=" + requestId + ", resdata=" + resdata + ", msg=" + msg + "]";
	}
}


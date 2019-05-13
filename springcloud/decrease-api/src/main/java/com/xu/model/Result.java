package com.xu.model;

import java.io.Serializable;

/**
 * 公共的返回对象
 * @author CodeLab
 *
 */
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	
	
	public static Result ok(Integer code,String msg) {
		return new Result(code, msg);
	}
	
	public static Result ok() {
		return new Result(200, "OK");
	}
	
	public static Result error(Integer code,String msg) {
		return new Result(code, msg);
	}
	
	public static Result error() {
		return new Result(400, "error");
	}
	
	
	public Result() {}
	public Result(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


}

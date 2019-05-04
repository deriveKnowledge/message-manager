package cn.wannengde.manager.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * 通用的返回的类
 * */
public class Msg implements Serializable {
	private static final long serialVersionUID = 1L;
	//状态码  100-成功 200-失败
	private int code;
	//提示信息
	private String msg;
	
	//用户要返回给浏览器的数据
	private Map<String,Object> extend = new HashMap<String,Object>();


	public static Msg success(String temp){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg(temp);
		return result;
	}
	
	public static Msg fail(String temp){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg(temp);
		return result;
	}
	
	public Msg no(String temp) {
		this.setCode(200);
		this.setMsg(temp);
		return this;
	}
	
	public Msg ok(String temp) {
		this.setCode(100);
		this.setMsg(temp);
		return this;
	}
	
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	@Override
	public String toString() {
		return "Msg [code=" + code + ", msg=" + msg + ", extend=" + extend + "]";
	}
	
}

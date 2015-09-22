package com.hand.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;

	private String type;
	
	private String errMsg;

	@Override
	public String execute() throws Exception {
		if (username.trim() == null || username.equals("")) {
			errMsg = "账号不能为空";
			return ERROR;
		}
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	

}

package br.com.felipe.mytuition.app.utils;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = 5123727013716271497L;

	private Integer code;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

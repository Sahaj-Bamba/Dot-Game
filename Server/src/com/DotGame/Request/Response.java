package com.DotGame.Request;

import com.DotGame.Constant.Responses;

import java.io.Serializable;

public class Response extends ClientToken implements Serializable {

	private Responses status;
	private String errorMessage;

	public Response(Responses status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

}
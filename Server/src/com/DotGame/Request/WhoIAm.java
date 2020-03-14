package com.DotGame.Request;

import com.DotGame.Constant.Request;

import java.io.Serializable;

public class WhoIAm implements Serializable {

	private String name;

	public WhoIAm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.valueOf(Request.WHOIAM);
	}

}
package com.DotGame.Constant;

public enum Request {
	
	WHOIAM("0"),
	GROUPPASS("1"),
	RESPONSE("2"),
	GROUPLIST("3"),
	
	CREATEGROUP("4"),
	JOINGROUP("5")
	
	
	;
	
	Request(String s){
		s.toString();
	}
}

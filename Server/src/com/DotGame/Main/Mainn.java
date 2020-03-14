package com.DotGame.Main;

public class Mainn {

	public static int SIZE = 2;
	public static Owner GAMER;

	public static void main(String args[]) {
		GAMER = new Owner();
		new Server().start();
	}

}
package com.DotGame.Main;

import com.DotGame.Constant.LineType;
import com.DotGame.Request.GameState;

public class Game {
	private int size;
	private String[] players = new String[8];
	private GameState gameState;
	private String groupName;
	
	public Game(int Size) {
		this.size = size;
		gameState = new GameState(size);
	}
	
	public void update(LineType lineType, int x , int y){
		if (lineType == LineType.Horizontal){
			gameState.addHorizontalLine(x,y);
		}else if (lineType == LineType.Vertical){
			gameState.addVerticalLine(x,y);
		}
	}
	
}

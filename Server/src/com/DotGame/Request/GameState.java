
package com.DotGame.Request;

import com.DotGame.Constant.LineType;

import java.awt.*;
import java.io.Serializable;

/**
 *
 * @author Sahaj
 */

/**
 *
 * This Class describes the state of the game at any instant .
 * The calculations will take place at the server and state,
 * will be sent by the server to be drawn by the client on screen.
 */
public class GameState implements Serializable{
	private int turn;
	private int[][] horizontalLines = new int[10][10];
	private int[][] verticalLines = new int[10][10];
	private int[][] rectangles = new int [10][10];
	
	public GameState(int size) {
		
		turn = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size; j++) {
				verticalLines[i][j] = -1;
			}
		}
		for (int i = 0; i < size ; i++) {
			for (int j = 0; j < size - 1; j++) {
				horizontalLines[i][j] = -1;
			}
		}
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				rectangles[i][j] = -1;
			}
		}
		
	}
	
	
	public void addHorizontalLine(int x, int y) {
		horizontalLines[x][y] = turn;
	}
	
	public void addVerticalLine(int x, int y) {
		verticalLines[x][y] = turn;
	}
	
	public int getVColor(int i, int j) {
		return verticalLines[i][j];
	}
	
	public int getHColor(int i, int j) {
		return horizontalLines[i][j];
	}
	
	public int getRColor(int i, int j) {
		return rectangles[i][j];
	}
	
	public int getTurn(){
		return turn;
	}
	
	public void makeMove(Move move){
		if (move.getLineType() == LineType.Horizontal){
			addHorizontalLine((int) move.getPoint().getX(),(int) move.getPoint().getY());
			if (move.getPoint().x == 0){
				
			}
		}else if (move.getLineType() == LineType.Vertical){
			addVerticalLine((int) move.getPoint().getX(),(int) move.getPoint().getY());
		}
	}
	
}
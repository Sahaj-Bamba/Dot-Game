
package com.DotGame.Request;

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
		turn++;
	}
	
	public void addVerticalLine(int x, int y) {
		verticalLines[x][y] = turn;
		turn++;
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

 	
}
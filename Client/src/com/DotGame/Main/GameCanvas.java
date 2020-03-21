/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DotGame.Main;

import com.DotGame.Request.GameState;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author Sahaj
 */
public class GameCanvas extends Canvas{
    
    private int WIDTH  = 440;
    private int HEIGHT = 440;

    private Color[] colors = new Color[9];
    GameState gameState;
    private int size;
    
    public GameCanvas(int size){
        setBackground(Color.blue);
        setSize(WIDTH, HEIGHT);
        this.size = size;
    }

    private void init(){
        colors[0]=Color.red;
        colors[1]=Color.GREEN;
        colors[2]=Color.BLUE;
        colors[3]=Color.CYAN;
        colors[4]=Color.GRAY;
        colors[5]=Color.MAGENTA;
        colors[6]=Color.PINK;
        colors[7]=Color.YELLOW;
    }
    
    public void paint(Graphics g){
        
        //  Draw background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // Draw Dots
        g.setColor(Color.blue);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.fillOval(100, 100, 30, 30);
            }
        }
		
    }
    
    public void update(GameState gameState){
        this.gameState = gameState;
        super.update(this.getGraphics());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DotGame.Main;

import com.DotGame.Request.GameState;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Sahaj
 */
public class GamePanel extends JPanel {

    
    private int WIDTH  = 440;
    private int HEIGHT = 440;

    private Color[] colors = new Color[9];
    GameState gameState;
    private int size;

    private int gridSize = 50;
    private int dotSize = 20;
    private int offset = 10;
    
    private Ellipse2D[][] dots = new Ellipse2D[10][10];
    private Line2D[][] vLines = new Line2D[10][10];
    private Line2D[][] hLines = new Line2D[10][10];
    private Rectangle2D[][] rects = new Rectangle2D[10][10];
    
    
    public GamePanel(int size){
        this.size = size;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.white);
        setSize(WIDTH, HEIGHT);
        init();
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
        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                rects[i][j] = new Rectangle2D.Double(offset + j*gridSize , offset + i*gridSize,gridSize,gridSize);
                dots[i][j] = new Ellipse2D.Double(offset + j*gridSize , offset + i*gridSize,dotSize,dotSize);
                vLines[i][j] = new Line2D.Double(offset + j*gridSize , offset + i*gridSize,offset + j*gridSize , offset + (i+1)*gridSize);
                hLines[i][j] = new Line2D.Double(offset + j*gridSize , offset + i*gridSize,offset + (j+1)*gridSize , offset + (i)*gridSize);
            }
        }
        System.out.println("hi");
        this.repaint();
    }
    
    
    
    
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);       
        Graphics2D g2d = (Graphics2D)g;
        
        // Draw Dots
        g2d.setColor(Color.blue);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g2d.fill(dots[i][j]);
                if (gameState.getVColor(i,j) != -1){
                    g2d.setColor(colors[gameState.getVColor(i,j)]);
                    g2d.fill(vLines[i][j]);
                }
                if (gameState.getHColor(i,j) != -1){
                    g2d.setColor(colors[gameState.getHColor(i,j)]);
                    g2d.fill(hLines[i][j]);
                }
                if (gameState.getRColor(i,j) != -1){
                    g2d.setColor(colors[gameState.getRColor(i,j)]);
                    g2d.fill(rects[i][j]);
                }
            }
        }
    }
    
    public void update(GameState gameState){
        this.gameState = gameState;
        this.repaint();
    }
        
    
    
}

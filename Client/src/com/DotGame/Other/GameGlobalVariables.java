package com.DotGame.Other;

/**
 *
 * @author Sahaj
 */

import com.DotGame.Main.Client;
import java.awt.*;

/**
 * Different Global variables used everywhere
 *
 */

public class GameGlobalVariables {
    
    /**
     * The main instance of the class
     */
    private static GameGlobalVariables gameGlobalVariables = null;
    
    private Client Gamer;
    
    /**
     * Server Configuration Variables
     *
     */
    private int port;
    private String ip;
    
    /**
     * Screen size controls
     *
     */
    private double defaultScreenHeight;
    private double defaultScreenWidth;
    private double screenHeight;
    private double screenWidth;
    private double screenHeightFraction;
    private double screenWidthFraction;
    
    /**
     * Game Control Variables
     *
     */
    private int SIZE;
    
    /**
     * Private constructor calls init method
     *
     */
    private GameGlobalVariables(){
        init();
    }
    
    /**
     * Creates the instance and return
     * @return the instance of the object
     */
    public static GameGlobalVariables getInstance(){
        if (gameGlobalVariables==null){
            gameGlobalVariables=new GameGlobalVariables();
        }
        return gameGlobalVariables;
    }
    
    /**
     * initialize different variables
     *
     */
    private void init(){
        calculateFraction(1080,1920);
        port = 5555;
        ip = "localhost";
        Gamer = new Client(ip,port);
    }
    
    public int getSIZE() {
        return SIZE;
    }
    
    public int getPort() {
        return port;
    }
    
    public String getip() {
        return ip;
    }
    
    public Client getClient(){
        return this.Gamer;
    }
    
    public double getScreenHeightFraction() {
        return screenHeightFraction;
    }

    public double getScreenWidthFraction() {
        return screenWidthFraction;
    }
    
    /**
     * All The work of the screen size adjusting screen resolution independence
     *
     * @param x the width of the screen
     * @param y the height of the screen
     */
    public void calculateFraction(double x, double y){
    
        this.defaultScreenHeight=x;
        this.defaultScreenWidth=y;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeightFraction = screenHeight/defaultScreenHeight;
        screenWidthFraction = screenWidth/defaultScreenWidth;
    
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DotGame.Request;

import com.DotGame.Constant.Request;
import java.io.Serializable;

/**
 *
 * @author Sahaj
 */
public class StartGame implements Serializable{
        
    @Override
    public String toString() {
        return String.valueOf(Request.STARTGAME);
    }
    
}
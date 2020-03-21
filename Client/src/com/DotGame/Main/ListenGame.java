/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DotGame.Main;

import com.DotGame.Constant.Request;
import com.DotGame.Other.GameGlobalVariables;
import com.DotGame.Request.AddMember;
import com.DotGame.Request.GameState;
import com.DotGame.Request.Message;
import com.DotGame.Request.RemoveMember;
import com.DotGame.Utilities.GroupView;

/**
 *
 * @author Sahaj
 */
public class ListenGame implements Runnable{
    
    private MainGame mainGame;

    public ListenGame(MainGame mainGame) {
        this.mainGame = mainGame;
    }
    
    @Override
    public void run(){
        
        while (true){
            
            Object obj = GameGlobalVariables.getInstance().getClient().receiveMessage();
            
            if (obj.toString().equals(String.valueOf(Request.MESSAGE))){
                receivedMessage((Message)obj);
            }else if (obj.toString().equals(String.valueOf(Request.MEMBERREMOVE))){
                removeMember((RemoveMember)obj);    
            }else if (obj.toString().equals(String.valueOf(Request.GAMESTATE))){
                updateGame((GameState)obj);    
            }
            
        }
        
    }

    private void receivedMessage(Message obj) {
        mainGame.gotMessage(obj.getFrom() + " :- " + obj.getContent());
    }

    private void removeMember(RemoveMember removeMember) {
        mainGame.lostPlayer(removeMember.getName());
    }

    private void updateGame(GameState gameState) {
        mainGame.updateGame(gameState);
    }
    

    
}

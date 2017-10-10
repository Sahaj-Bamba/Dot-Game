/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotgame;
import acm.program.DialogProgram;
import static dotgame.DotGame.MAX_PLY;
import static dotgame.DotGame.No_Player;
import static dotgame.DotGame.GS;
import static dotgame.DotGame.BG_Color;
import static dotgame.DotGame.Back;
import static dotgame.DotGame.Grid_S;
import static dotgame.DotGame.MX_GS;
import static dotgame.DotGame.Players;
/**
 *
 * @author sneha_sahaj
 */
public class settings extends DialogProgram
{
    public void run()
    {
        
        int temp;
        int temp2;
        ChooseColor temp3=new ChooseColor();
        while(true)
        {
            temp=readInt("\n1- Change number of players \n2- Set background color \n3- Set player color \n4- Set Matrix Size");
            if(temp>0&&temp<5)
                break;
            print("Error\n\nPlease enter a correct value");
        }
        switch(temp)
        {
            case 1:
                    while(true)
                    {
                        temp2=readInt("\nEnter the number of players between 2 and " + MAX_PLY);
                        if(temp2>1&&temp2<MAX_PLY)
                        {
                            No_Player=temp2;
                            break;
                        }
                        else
                            println("Error\n\nEnter correct value ");
                    }
                    break;
            case 2:
                    
                    BG_Color=temp3.run("back ground");
                    break;
            case 3:
                    for(int i=1;i<=No_Player;i++)
                        Players[i-1].colour=temp3.run("Player "+i);
                    break;
            case 4:
                    while(true)
                    {
                        temp2=readInt("Please Enter the grid Size . Enter a number between 1 and "+MX_GS);
                        if(temp>0&&temp<MX_GS+1)
                        {
                            GS=temp2;
                            Back.setSize(GS*Grid_S,GS*Grid_S);
                            break;
                        }
                    }
        }
        DotGame.initializer();
    }
    
}

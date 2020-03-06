/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotgame;
import acm.program.DialogProgram;
import static dotgame.DotGame.GB_CNT;
import static dotgame.DotGame.MAX_PLY;
import static dotgame.DotGame.No_Player;
import static dotgame.DotGame.Players;

/**
 *
 * @author sneha_sahaj
 */
public class end_game extends DialogProgram
{
public void run()
{
    
    int Winners[]=new int[MAX_PLY];
    int Scor[]=new int[MAX_PLY];
    
    for(int i=0;i<No_Player;i++)
    {
        Winners[i]=i+1;
        Scor[i]=Players[i].score;
    }
    int x=0;
    int y=0;
    for(int i=0;i<No_Player;i++)
    {
        x=i;
        for(int j=i;j<No_Player;j++)
        {
            if(Scor[j]<Scor[x])
            {
                x=j;
            }
            
            y=Scor[i];
            Scor[i]=Scor[x];
            Scor[x]=y;
            y=Winners[i];
            Winners[i]=Winners[x];
            Winners[x]=y;
        }
    }
    y=0;
    int t=No_Player-1;
    x=Scor[t];
        while(x==Scor[t])
        {
            y++;
            t--;
            if(t==-1)
                break;
        }
    if(y==1)
    println("Winner is Player "+(Winners[No_Player-1]));
    else
    {
            println("We have "+y+" Winners .");
            y=0;
    t=No_Player-1;
    x=Scor[t];
        while(x==Scor[t])
        {
            println("Player "+Winners[t]);
            t--;
            if(t==-1)
                break;
            
            
        }
            
    }
    /*DotGame.initializer();
    GB_CNT=false;
    while(!GB_CNT)
    {
    
        new menu().start();

    }*/
    System.exit(0);
}
}
package dotgame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package dotgame;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import static dotgame.DotGame.BG_Color;
import static dotgame.DotGame.Back;
import static dotgame.DotGame.Click_End;
import static dotgame.DotGame.GS;
import static dotgame.DotGame.Grid_S;
import static dotgame.DotGame.H_Line;
import static dotgame.DotGame.MX_GS;
import static dotgame.DotGame.No_Player;
import static dotgame.DotGame.MX;
import static dotgame.DotGame.Players;
import static dotgame.DotGame.Points;
import static dotgame.DotGame.Rect;
import static dotgame.DotGame.V_Line;
import static dotgame.DotGame.GB_CNT;
import static dotgame.DotGame.Ply_Scr;
import static dotgame.DotGame.Ply_Scr_2;
import java.awt.Color;
import java.awt.event.MouseEvent;
/**
 *
 * @author sneha_sahaj
 */
public class StartGame extends GraphicsProgram 
{
    GLabel Ply_Nm=new GLabel("Player   ");
    
    
   // private GPoint A1,A2;
    private int L_F;
    private int Active_X_1;
    private int Active_X_2;
    private int Active_Y_1;
    private int Active_Y_2;
    private int Player_cnt;
    private int click_cnt;
     Color[] colors;
    public void init()
	{
            colors = new Color[MX];
        colors[0]=Color.red;
        colors[1]=Color.GREEN;
        colors[2]=Color.BLUE;
        colors[3]=Color.CYAN;
        colors[4]=Color.GRAY;
        colors[5]=Color.MAGENTA;
        colors[6]=Color.PINK;
        colors[7]=Color.YELLOW;
            click_cnt=0;   
            Player_cnt=0;
            addMouseListeners();
	}
    public void FL(String a)
    {
        
       
        char[] initial =new char [a.length()];
        char[] org =new char[a.length()];
        initial[0]=a.charAt(0);
        org[0]=' ';
        
        
        
        for(int i=1;a.charAt(i)!='\n';i++)
        {
            org[i]=a.charAt(i);
            initial[i]=' ';
            if(a.charAt(i)==' ')
            {
                
                i++;
                if(a.charAt(i)==' ')
                    break;
                org[i]=' ';
                initial[i]=a.charAt(i);
            }
                
        }
        String st_org=new String(org);
        String st_initial =new String(initial);
        GLabel label_initial =new GLabel(st_initial);
        GLabel label_org =new GLabel(st_org);
        GLabel size=new GLabel(a);
        size.setFont("SansSerif-50");
        label_initial.setFont("SansSerif-50");
        label_org.setFont("SansSerif-50");
        double x;
        x = (getWidth()-size.getWidth())/2;
        double y;
        y=(getHeight()+size.getAscent())/2;
        add(label_initial,x,y);
        label_initial.move(0,100);
        for(int i=0;i<10;i++)
        {
            label_initial.move(0,-10);
            label_initial.setColor(colors[i%7]);
            pause(200);
        }
        add(label_org,x,y);
        label_org.move(0,100);
        for(int i=0;i<10;i++)
        {
            label_org.move(0,-10);
            label_org.setColor(colors[i%7]);
          //  label_org.scale(1.1);
            pause(200);
        }
        removeAll();
        add(size,x,y);
        pause(500);
        
        removeAll();
        
    }
    private int multibox=0;
    public void run()
    {
        
      GB_CNT = true;
        Ply_Nm.setLocation((GS*Grid_S-Ply_Nm.getWidth())/2,5-Grid_S);
        Ply_Nm.setColor(Players[Player_cnt%No_Player].colour);
        Ply_Nm.setLabel("Player "+Player_cnt%No_Player);
        Ply_Nm.setFont("TimesRoman-30");
        //Flash TF=new Flash();
        FL("Game Begins  ");
        
        //add(Back);
        add(Ply_Scr[Player_cnt%No_Player]);
        for(int score_t=0;score_t<No_Player;score_t++)
        add(Ply_Scr_2[score_t]);
   
          for(int i=1;i<GS+1;i++)
        {
            for(int j=1;j<GS+1;j++)
            {
                add(Rect[i-1][j-1]);
            }
        }
        for(int i=1;i<GS+2;i++)
        {
            for(int j=1;j<GS+1;j++)
            {
                add(H_Line[i-1][j-1]);
               
                
                
            }
        }
        for(int i=1;i<GS+1;i++)
        {
            for(int j=1;j<GS+2;j++)
            {
                add(V_Line[i-1][j-1]);
               
                
                
            }
        }
       
        for(int i=1;i<GS+2;i++)
        {
            for(int j=1;j<GS+2;j++)
            {
                add(Points[i-1][j-1]);
            }
        }
        add(Click_End);
    }
   
    public void mouseClicked(MouseEvent e)
	{
           multibox=0;
            boolean f=false;
            
            for(int i=0;i<GS+1;i++)
            {
                for(int j=0;j<GS+1;j++)
                {
                    if(Points[i][j].contains(e.getX(),e.getY()))
                    {
                        f=true;
                        if(click_cnt%2==0)
                    {
                        Active_X_1=i;
                        Active_Y_1=j;
                        //A1.setLocation((i+1)*Grid_S, (j+1)*Grid_S);
                    }
                        else
                    {
                        Active_X_2=i;
                        Active_Y_2=j;
                        //A2.setLocation((i+1)*Grid_S, (j+1)*Grid_S);
                    }
                        break;
                    }
                    
                }
                if(f)
                    break;
            }
            L_F=0;
            if(Click_End.contains(e.getX(),e.getY()))
            {
                  new end_game().start();
            }
            if(f)
            {
                click_cnt++;
                if(click_cnt%2==0)
                {
                    int temp_12;
                    if(Active_X_1>Active_X_2)
                    {
                        temp_12=Active_X_1;
                        Active_X_1=Active_X_2;
                        Active_X_2=temp_12;
                    }
                    if(Active_Y_1>Active_Y_2)
                    {
                        temp_12=Active_Y_2;
                        Active_Y_2=Active_Y_1;
                        Active_Y_1=temp_12;
                    }
                    if(Active_Y_2==Active_Y_1)
                    {
                        if(Active_X_2-Active_X_1==1)
                        {
                            if(V_Line[Active_X_1][Active_Y_1].getColor()==BG_Color) {
                            
                                L_F=3;
                            
                            V_Line[Active_X_1][Active_Y_1].setColor(Players[Player_cnt%No_Player].colour);
                        
                            }
                        }
                        /*else if(Active_X_2-Active_X_1==-1)
                        {
                            if(V_Line[Active_X_2][Active_Y_2].getColor()==BG_Color)
                            {L_F=2;
                            
                            V_Line[Active_X_2][Active_Y_2].setColor(Players[Player_cnt%No_Player].colour);
                        
                            }
                        }*/
                    }
                    else if(Active_X_1==Active_X_2)
                    {
                         if(Active_Y_2-Active_Y_1==1)
                        {
                            if(H_Line[Active_X_1][Active_Y_1].getColor()==BG_Color)
                            {
                                L_F=1;
                            
                            H_Line[Active_X_1][Active_Y_1].setColor(Players[Player_cnt%No_Player].colour);
                        
                            }
                        }
                        /*else if(Active_Y_2-Active_Y_1==-1)
                        {
                            if(H_Line[Active_X_2][Active_Y_2].getColor()==BG_Color)
                            {
                                L_F=4;
                            
                            H_Line[Active_X_2][Active_Y_2].setColor(Players[Player_cnt%No_Player].colour);
                        
                            }
                        }*/
                    }
                    
                                                
                }
                if(L_F!=0)
                {
                   Player_cnt++;
                    if(!((Active_X_1==0&&Active_X_2==0)||(Active_Y_1==0&&Active_Y_2==0)||(Active_X_1==GS&&Active_X_2==GS)||(Active_Y_2==GS&&Active_Y_1==GS)))
                    {
                        if(L_F==3)
                        {
                            if(H_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1+1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1+1].getColor()!=BG_Color&&Rect[Active_X_1][Active_Y_1].getColor()!=BG_Color)
                            {
                                multibox=1;
                                  Player_cnt--;  
                                Rect[Active_X_1][Active_Y_1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;
                                (Players[Player_cnt%No_Player].score)++;
                            }
                            if(V_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1][Active_Y_1-1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1-1].getColor()!=BG_Color&&H_Line[Active_X_1+1][Active_Y_1-1].getColor()!=BG_Color&&Rect[Active_X_1][Active_Y_1-1].getColor()!=BG_Color) 
                            {
                                if(multibox==0)
                                  Player_cnt--;  
                             
                                Rect[Active_X_1][Active_Y_1-1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;   
                            }
                            
                        }
                        /*else if(L_F==4)
                        {
                            
                            if(H_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&H_Line[Active_X_2+1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2+1].getColor()!=BG_Color&&Rect[Active_X_2][Active_Y_2].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_2][Active_Y_2].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;
                                (Players[Player_cnt%No_Player].score)++;
                            }
                            else if(H_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&H_Line[Active_X_2-1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2-1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2-1][Active_Y_2+1].getColor()!=BG_Color&&Rect[Active_X_2-1][Active_Y_2].getColor()!=BG_Color) 
                            {
                                  Player_cnt--;  
                             
                                Rect[Active_X_2-1][Active_Y_2].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                                   
                            }
                           
                        }*/
                        else if(L_F==1)
                        {
                        if(H_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1+1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1+1].getColor()!=BG_Color&&Rect[Active_X_1][Active_Y_1].getColor()!=BG_Color)
                            {
                                multibox=1;
                                  Player_cnt--;  
                                Rect[Active_X_1][Active_Y_1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        if(H_Line[Active_X_1-1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1-1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1-1][Active_Y_1+1].getColor()!=BG_Color&&Rect[Active_X_1-1][Active_Y_1].getColor()!=BG_Color)
                            {
                                if(multibox==0)
                                  Player_cnt--;  
                                Rect[Active_X_1-1][Active_Y_1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        }
                        /*else if(L_F==2)
                        {
                            if(H_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&H_Line[Active_X_2+1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2+1].getColor()!=BG_Color&&Rect[Active_X_2][Active_Y_2].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_2][Active_Y_2].setFillColor(Players[Player_cnt%No_Player].colour);
                                 //Player_cnt--;  
                                (Players[Player_cnt%No_Player].score)++;
                            }
                            else if(H_Line[Active_X_2][Active_Y_2-1].getColor()!=BG_Color&&H_Line[Active_X_2+1][Active_Y_2-1].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2-1].getColor()!=BG_Color&&Rect[Active_X_2][Active_Y_2-1].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_2][Active_Y_2-1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }
                            
                        }*/
                    }
                    else 
                    {if(L_F==1)
                    {
                        if(Active_X_1==0)
                        {
                           if(H_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1+1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1+1].getColor()!=BG_Color&&Rect[Active_X_1][Active_Y_1].getColor()!=BG_Color)
                            {
                               
                                  Player_cnt--;  
                                Rect[Active_X_1][Active_Y_1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        }
                        else if(Active_X_1==GS)
                        {
                            if(H_Line[Active_X_1-1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1-1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1-1][Active_Y_1+1].getColor()!=BG_Color&&Rect[Active_X_1-1][Active_Y_1].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_1-1][Active_Y_1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        }
                    }
                    /*else if(L_F==2)
                    {
                        if(Active_Y_1==0)
                            if(H_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&H_Line[Active_X_2+1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2+1].getColor()!=BG_Color&&Rect[Active_X_2][Active_Y_2].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_2][Active_Y_2].setFillColor(Players[Player_cnt%No_Player].colour);
                               // Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        else if(Active_Y_1==GS)
                        {
                            if(H_Line[Active_X_2][Active_Y_2-1].getColor()!=BG_Color&&H_Line[Active_X_2+1][Active_Y_2-1].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2-1].getColor()!=BG_Color&&Rect[Active_X_2][Active_Y_2-1].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_2][Active_Y_2-1].setFillColor(Players[Player_cnt%No_Player].colour);
                               // Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;
                            }

                        }
                    }*/
                    else if(L_F==3)
                    {
                        if(Active_Y_1==0)
                        {
                             if(H_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1+1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1+1].getColor()!=BG_Color&&Rect[Active_X_1][Active_Y_1].getColor()!=BG_Color)
                            {
                                  Player_cnt--;  
                                Rect[Active_X_1][Active_Y_1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        }
                        else if(Active_Y_1==GS)
                        {
                            if(V_Line[Active_X_1][Active_Y_1].getColor()!=BG_Color&&H_Line[Active_X_1][Active_Y_1-1].getColor()!=BG_Color&&V_Line[Active_X_1][Active_Y_1-1].getColor()!=BG_Color&&H_Line[Active_X_1+1][Active_Y_1-1].getColor()!=BG_Color&&Rect[Active_X_1][Active_Y_1-1].getColor()!=BG_Color) 
                            {
                                  Player_cnt--;  
                             
                                Rect[Active_X_1][Active_Y_1-1].setFillColor(Players[Player_cnt%No_Player].colour);
                                //Player_cnt--;   
                                (Players[Player_cnt%No_Player].score)++;   
                            }
                        }
                        
                        
                    }
                    /*else if(L_F==4)
                    {
                        if(Active_X_1==0)
                        {
                            if(H_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&H_Line[Active_X_2+1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2][Active_Y_2+1].getColor()!=BG_Color&&Rect[Active_X_2][Active_Y_2].getColor()!=BG_Color)
                            {
                                 Player_cnt--;
                                Rect[Active_X_2][Active_Y_2].setFillColor(Players[Player_cnt%No_Player].colour);
                                  
                                (Players[Player_cnt%No_Player].score)++;
                            }
                        }
                        if(Active_X_1==GS)
                        {
                            if(H_Line[Active_X_2][Active_Y_2].getColor()!=BG_Color&&H_Line[Active_X_2-1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2-1][Active_Y_2].getColor()!=BG_Color&&V_Line[Active_X_2-1][Active_Y_2+1].getColor()!=BG_Color&&Rect[Active_X_2-1][Active_Y_2].getColor()!=BG_Color) 
                            {
                             
                                Player_cnt--; 
                                Rect[Active_X_2-1][Active_Y_2].setFillColor(Players[Player_cnt%No_Player].colour);
                                  
                                (Players[Player_cnt%No_Player].score)++;
                                   
                            }
                        }
                    }*/
                    }
                    
                     remove(Ply_Scr[(Player_cnt-1)%No_Player]);
                    add(Ply_Scr[(Player_cnt)%No_Player]);
                    Ply_Scr[(Player_cnt)%No_Player].setLabel("Player "+((Player_cnt)%No_Player+1)+"   "+Players[(Player_cnt)%No_Player].score);
                    Ply_Scr[(Player_cnt-1)%No_Player].setLabel("Player "+((Player_cnt-1)%No_Player+1)+"   "+Players[(Player_cnt-1)%No_Player].score);
                    Ply_Scr_2[(Player_cnt)%No_Player].setLabel("Player "+((Player_cnt)%No_Player+1)+"   "+Players[(Player_cnt)%No_Player].score);
                    Ply_Scr_2[(Player_cnt-1)%No_Player].setLabel("Player "+((Player_cnt-1)%No_Player+1)+"   "+Players[(Player_cnt-1)%No_Player].score);
                }
            }
            else
            {
                err_wrong_click temp =new err_wrong_click();
                temp.run();
            }
	
        
        {
            int sum=0;
            
        
            for(int i=0;i<No_Player;i++)
                sum+=Players[i].score;
            /*GLabel SC=new GLabel(" "+sum,500,500);
            add(SC);
            pause(10000);
            remove(SC);*/
            if(sum>=GS*GS)
            {
                //removeAll();
               // FL("Game Over  ");
                new end_game().start();
            }
        }
	}
}









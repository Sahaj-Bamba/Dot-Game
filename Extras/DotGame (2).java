/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotgame;
import java.awt.*;
import acm.graphics.*;
/**
 *
 * @author sneha_sahaj
 */

public class DotGame 
{ 
    public static int MX=8;
    
    public static int No_Player;
    public static final int MAX_PLY=MX-1;
    public static boolean GB_CNT;
    public static GLabel Ply_Scr[]=new GLabel[MAX_PLY];
    public static GLabel Ply_Scr_2[]=new GLabel[MAX_PLY];
    public static Color BG_Color;
    public static final int Grid_S=50;
    public static final int Pt_R=10;
    public static final int MX_GS=10;
    public static Player Players[]=new Player[MAX_PLY];
    public static int GS;
    public static GLabel Click_End =new GLabel("Click to End");
    public static GLine H_Line [][]=new GLine[MX_GS+1][MX_GS+1];
    public static GLine V_Line [][]=new GLine[MX_GS+1][MX_GS+1];
    public static GOval Points [][]=new GOval[MX_GS+1][MX_GS+1];
    public static GRect Rect[][]=new GRect[MX_GS][MX_GS];
    public static GRect Back=new GRect(Grid_S*MX_GS,Grid_S*MX_GS,Grid_S,Grid_S);
   
    
    public static void main(String[] args) 
    {   BG_Color=Color.YELLOW;
    GB_CNT=false;
        No_Player=2;
        for(int i=0;i<MAX_PLY;i++)
        {
            Players[i]=new Player();
            
                        
        }
        Players[0].colour=Color.red;
        Players[1].colour=Color.GREEN;
        Players[2].colour=Color.BLUE;
        Players[3].colour=Color.CYAN;
        Players[4].colour=Color.GRAY;
        Players[5].colour=Color.MAGENTA;
        Players[6].colour=Color.PINK;
        GS=2;
        Back.setFillColor(BG_Color);
        Back.setFilled(true);
        GLine a[];
         for(int i=0;i<MAX_PLY;i++)
        {
            
            Ply_Scr[i]=new GLabel("Player "+(i+1)+"   "+Players[i].score);
            Ply_Scr[i].setColor(Players[i].colour);
            Ply_Scr[i].setFont("SansSerif-30");
            Ply_Scr[i].setLabel("Player "+(i+1)+"   "+Players[i].score);
            Ply_Scr[i].setLocation(10,Grid_S-5);
            Ply_Scr_2[i]=new GLabel("Player "+(i+1)+"   "+Players[i].score);
            Ply_Scr_2[i].setColor(Players[i].colour);
            Ply_Scr_2[i].setFont("SansSerif-30");
            Ply_Scr_2[i].setLabel("Player "+(i+1)+"   "+Players[i].score);
            Ply_Scr_2[i].setLocation(1000,Grid_S*(i+2));
        }
         Click_End.setColor(Color.ORANGE);
         Click_End.setFont("SansSerif-30");
         Click_End.setLocation(1000,Grid_S*1);
        for(int i=1;i<MX_GS+1;i++)
        {
            for(int j=1;j<MX_GS+1;j++)
            {
                Rect[i-1][j-1]=new GRect(j*Grid_S,i*Grid_S,Grid_S,Grid_S);
                Rect[i-1][j-1].setFilled(true);
                Rect[i-1][j-1].setFillColor(BG_Color);
                
            }
        }
        for(int i=1;i<MX_GS+2;i++)
        {
            for(int j=1;j<MX_GS+1;j++)
            {
                H_Line[i-1][j-1]=new GLine(j*Grid_S,i*Grid_S,(j+1)*Grid_S,i*Grid_S);
                
                H_Line[i-1][j-1].setColor(BG_Color);
                
                
                
            }
        }
          for(int i=1;i<MX_GS+1;i++)
        {
            for(int j=1;j<MX_GS+2;j++)
            {
                
                V_Line[i-1][j-1]=new GLine(j*Grid_S,i*Grid_S,j*Grid_S,(i+1)*Grid_S);
                
                V_Line[i-1][j-1].setColor(BG_Color);
                
                
            }
        }
        for(int i=1;i<MX_GS+2;i++)
        {
            for(int j=1;j<MX_GS+2;j++)
            {
                Points[i-1][j-1]=new GOval(j*Grid_S-Pt_R/2,i*Grid_S-Pt_R/2,Pt_R,Pt_R);
                Points[i-1][j-1].setFilled(true);
               // Points[i-1][j-1].setColor(BG_Color);
                Points[i-1][j-1].setFillColor(Color.WHITE);
                
            }
        }
       
        
        while(!GB_CNT)
        {
            menu b=new menu();
            b.run();
        }
    }
    public static void initializer()
    {
         for(int i=0;i<MAX_PLY;i++)
        {
           
            Ply_Scr[i].setColor(Players[i].colour);
         
                        
        }
        Back.setFillColor(BG_Color);
         for(int i=1;i<MX_GS+1;i++)
        {
            for(int j=1;j<MX_GS+1;j++)
            {
                
                Rect[i-1][j-1].setFillColor(BG_Color);
                
            }
        }
         for(int i=1;i<MX_GS+2;i++)
        {
            for(int j=1;j<MX_GS+1;j++)
            {
                
                
                H_Line[i-1][j-1].setColor(BG_Color);
                
                
                
            }
        }
          for(int i=1;i<MX_GS+1;i++)
        {
            for(int j=1;j<MX_GS+2;j++)
            {
                
               
                
                V_Line[i-1][j-1].setColor(BG_Color);
                        
            }
        }
        for(int i=1;i<MX_GS+2;i++)
        {
            for(int j=1;j<MX_GS+2;j++)
            {
              
                Points[i-1][j-1].setFilled(true);
                Points[i-1][j-1].setFillColor(Color.WHITE);
                
            }
        }
         for(int i=0;i<MAX_PLY;i++)
            Players[i].score=0;
    }
    
}

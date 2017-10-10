/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotgame;
import acm.program.DialogProgram;
import java.awt.Color;
/**
 *
 * @author sneha_sahaj
 */
public class ChooseColor extends DialogProgram
{
    private boolean check(int t)
    {
        boolean f=true;
        for(int i=0;i<Counter;i++)
            if(used_colors[i]==colors[t])
            {
                f=false;
                break;
            }
        return f;
    }
    public final int MX =8;
    private static int Counter =0;
    Color[] colors;
    Color[] used_colors;
    public ChooseColor() 
    {
        used_colors = new Color[MX];
        colors = new Color[MX];
        colors[0]=Color.red;
        colors[1]=Color.GREEN;
        colors[2]=Color.BLUE;
        colors[3]=Color.CYAN;
        colors[4]=Color.GRAY;
        colors[5]=Color.MAGENTA;
        colors[6]=Color.PINK;
        colors[7]=Color.YELLOW;
    }
    public Color run(String a)
    {
        int x;
        while(true)
        {
        x=readInt("Enter the number of the color which you would like "+a+" to be of \n1- Red\n2- Green\n3- Blue\n4- Cyan\n5- Gray\n6- Magenta\n7- Pink\n8- Yellow ");
        if(x>0&&x<MX+1&&check(x-1))
            break;
        else
            print("Please Re_enter the value .\nMake sure its not repeated and correct .");
        }
        used_colors[Counter]=colors[x-1];
        Counter++;
        if(Counter>7)
                Counter=0;
        return(colors[x-1]);
    }
    
}

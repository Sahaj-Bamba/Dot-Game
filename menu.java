/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotgame;
import acm.program.DialogProgram;
/**
 *
 * @author sneha_sahaj
 */
public class menu extends DialogProgram
{
    @Override
    public void run()
    {
        int cnt;
        credits temp4=new credits();
        settings temp3=new settings();
        How_To temp2;
        temp2 = new How_To();
        
        while (true)
        {
            cnt=readInt("\tDOT GAME\n\n1- Start Game\n2- How to Play\n3- Settings \n4- Credits \n5- Exit ");
            if(cnt>0&&cnt<6)
                break;
            print("\tError \nYou Entered an incorrect value .");
        }
        switch(cnt)
        {
            case 1:new StartGame().start();
                break;
            case 2:temp2.run();
                break;
            case 3:temp3.run();
                break;
            case 4:temp4.run();
                break;
            case 5:System.exit(0);
                break;
        }
    }
    
}

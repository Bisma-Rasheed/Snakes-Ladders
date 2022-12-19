/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.laddergame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Saad Communication
 */

public class SnakeLadderGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int initialState=0;
        int[] finalState={5};
        int noOfstates=7;
        String[] input1={"1","2","3","4","5","6","Sn","St","100"}; //allowed characters for the DFA/NFA
        ArrayList<int[]> transTable=new ArrayList<>(); //
        transTable.add(new int[9]);
        transTable.get(0)[0]=2;
        transTable.get(0)[1]=2;
        transTable.get(0)[2]=2;
        transTable.get(0)[3]=2;
        transTable.get(0)[4]=2;
        transTable.get(0)[5]=1;
        for(int i=6;i<=8;i++)
        {
            transTable.get(0)[i]=6;
        }
        
        transTable.add(new int[9]);
        for(int i=0;i<=4;i++)
        {
            transTable.get(1)[i]=2;
        }
        transTable.get(1)[5]=1;
        transTable.get(1)[8]=1;
        transTable.get(1)[6]=3;
        transTable.get(1)[7]=4;
        
        transTable.add(new int[9]);
        for(int i=0;i<=5;i++)
        {
            transTable.get(2)[i]=6;
        }
        transTable.get(2)[6]=3;
        transTable.get(2)[7]=4;
        transTable.get(2)[8]=5;
        
        transTable.add(new int[9]);
        for(int i=0;i<=8;i++)
        {
            transTable.get(3)[i]=6;
        }
        //transTable.get(3)[8]=5;
        
        transTable.add(new int[9]);
        for(int i=0;i<8;i++)
        {
            transTable.get(4)[i]=6;
        }
        transTable.get(4)[8]=5;
        
        transTable.add(new int[9]);
        for(int i=0;i<=8;i++)
        {
            transTable.get(5)[i]=5;
        }
        
        transTable.add(new int[9]);
        for(int i=0;i<=8;i++)
        {
            transTable.get(6)[i]=6;
        }
        //transTable.get(5)[8]=5;
        
        
        
        
        Scanner scan=new Scanner(System.in);
        System.out.println("\t\t\t\t******************************************");
        System.out.println("\t\t\t\t WELCOME TO \"SNAKES & LADDERS\" BOARD GAME");
        System.out.println("\t\t\t\t******************************************");
        System.out.println("\t\tNOTE: SN is for Snake and LD is for Ladder in the Board");
        System.out.println("\n\t\tINSTRUCTIONS: 1. A PLAYER WILL GET LOCKED(UNABLE TO MOVE) \n\t\t\t\t IF HE REACHES BLOCK 0 BY ANY CHANCE"
                + " DURING THE GAME.");
        System.out.println("\t\t\t      2. PLAYERS CAN CHOOSE DIFFICULTY LEVEL OUT OF 3 BY MUTUAL DECISION.");
        System.out.println("\t\t\t      3. ON GETTING 6 IN A DICE ROLL, PLAYER WILL GET ANOTHER DICE ROLL.");
        System.out.println("\t\t\t      4. EASY LEVEL   : -20 BLOCKS FOR A SNAKE, +20 BLOCKS FOR A LADDER.");
        System.out.println("\t\t\t      5. MEDIUM LEVEL : -30 BLOCKS FOR A SNAKE, +23 BLOCKS FOR A LADDER.");
        System.out.println("\t\t\t      6. HARD LEVEL   : RANDOMIZED NUMBER OF DECREASING AND INCREASING \n\t\t\t\t BLOCKS FOR SNAKES AND LADDERS RESPECTIVELY.");
        System.out.println("\n\t\t    Choose Type Of Game: (WRITE 2 FOR TWO PLAYERS, 3 FOR THREE PLAYERS AND 4 FOR FOUR PLAYERS)  \n\t\t    1. 2 Player Game\n\t\t    2. 3 Player Game\n\t\t    3. 4 Player Game");
        System.out.print("\t\t   Enter Your Choice: ");
        int choice=scan.nextInt();
        String[] Name=new String[4];
        if(choice<=4 && choice>1)
        {
            System.out.print("\t\t    Choose Dificulty Level: \n\t\t    Easy\n\t\t    Medium\n\t\t    Hard");
            System.out.println("\n\t\t   Enter Your Choice: (Write e for Easy, m for Medium & h for Hard)");
            System.out.print("\t\t   ");
            String difLevel=scan.next();
        
            System.out.println("\t\t   Do You Want to Name the Players ? \n\t\t   Yes? (Press y) \n\t\t   No?  (Press n) ");
            System.out.print("\t\t   ");
            String input = scan.next();
            if("y".equals(input))
            {
                for(int i=0;i<choice;i++)
                {
                    System.out.print("\t\t   Enter Player "+(i+1)+" Name : ");
                    Name[i]=scan.next(); 
                }
                Game Game=new Game(difLevel, choice, Name);
                Game.startGame(noOfstates,input1,transTable,initialState,finalState);
            }
            else if("n".equals(input))
            {
                Game Game=new Game(difLevel, choice);
                Game.startGame(noOfstates,input1,transTable,initialState,finalState);
            }
        }
        else if(choice>4)
        {
        System.out.print("\t\t   Wrong Choice, Press F6");
        }
        
        System.out.println("\n\t\t   Do You Want To Play Again ? ");
        System.out.println("\t\t   Yes? (Press y) \n\t\t   No? (Press n) ");
        System.out.print("\t\t   ");
        String c=scan.next();
        if("y".equals(c))
        {
           main(args);
        }
        
            
    }
}
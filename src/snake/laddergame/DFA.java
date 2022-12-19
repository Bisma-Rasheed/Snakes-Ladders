/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.laddergame;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Saad Communication
 */
public class DFA {
    Matcher regexMatcher;
    int noOfstates;
    String[] allowedChar;
    ArrayList<int[]> transTable;
    int initialState;
    int[] finalStates;
    int currentBlock;
    
    public DFA(int NS,String[] allowChar,ArrayList<int[]> TT,int IS,int[] FS)
    {
        this.noOfstates = NS;
        this.allowedChar = allowChar;
        this.transTable = TT;
        this.initialState = IS;
        this.finalStates = FS;
    }
    
    public boolean Validate(String InputString)
    {
        boolean isValid = false;
        String inputTocharArray[] = InputString.split(""); //splits string input into string array as a single character at an index
        int currentState = this.initialState;
       
        for(int i = 0; i<InputString.length();i++)
        {
            currentState = Transition(currentState,inputTocharArray[i]);
        }
        for(int i = 0 ;i<finalStates.length;i++)
        {
            if(currentState == finalStates[i])
            {
                isValid = true;
                break;
            }
            else
            {
                isValid =  false;
            }
        }
        return isValid;
    }
    
    public int Transition(int currentState,String string)
    {
        int location = -1;
        for(int i = 0; i < this.allowedChar.length;i++)
        {
            Pattern p = Pattern.compile(this.allowedChar[i]); //stores the whole regular expression as a pattern in regex 
            this.regexMatcher = p.matcher(string); //
            if(this.regexMatcher.matches())
            {
                location = i; //if the character matches at the ith position stores the index-> i and breaks
                break;
            }
        }
        if(location != -1) //if the character matches with atleast one pattern in the given regex
        {
            return this.transTable.get(currentState)[location]; //returns 2D array with the index -> [currentstates][index at which char matched]
        }
        else
        {
            return this.noOfstates;
        }
    }
}
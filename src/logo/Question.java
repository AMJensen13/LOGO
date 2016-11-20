/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
 import java.util.*;
/**
 *
 * @author AMJensen13
 */
public class Question {
    String question;
    ArrayList<String> options;
    String correctAnswer;
    
    public Question(String theQuestion, String answer, ArrayList<String> allOptions)
    {
        correctAnswer = answer;
        question = theQuestion;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public ArrayList<String> getOptions()
    {
        return options;
    }
    
    public boolean CheckAnswer(int option)
    {
        for(String s : options)
        {
            if(options.get(option).equals(s))
                return true;
        }
        
        return false;
    }
    
}

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
        options = allOptions;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public ArrayList<String> getOptions()
    {
        return options;
    }
    
    public boolean CheckAnswer(String answer)
    {
        return answer.equals(correctAnswer);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
import javax.swing.ImageIcon;
import java.util.*;

/**
 *
 * @author AMJensen13
 */
public class Card {
    ImageIcon questionSide;
    ImageIcon logoSide;
    ArrayList<Question> questions;
    
    public Card(ArrayList<Question> questions)
    {
        this.questions = questions;
        questionSide = new ImageIcon(this.getClass().getResource("Resources/Template_Back.jpg"));
    }
    
    public Question getQuestion(int idx)
    {
        return questions.get(idx);
    }
    
    public ImageIcon getQuestionImage()
    {
        return questionSide;
    }
}

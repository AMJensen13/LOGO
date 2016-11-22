/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
import java.awt.Image;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

/**
 *
 * @author AMJensen13
 */
public class Card {
    public Image pictureSide;
    public ArrayList<Question> questions;
    
    public Card(ArrayList<Question> questions, String image)
    {
        this.questions = questions;
        try{
            pictureSide = ImageIO.read(this.getClass().getClassLoader().getResource("Resources/" + image));
        } catch(IOException e)
        {
            
        }
    }
}

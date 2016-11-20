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
public class PictureCard extends Card{
    
    public PictureCard(ArrayList<Question> questions, String pictureSet)
    {
        super(questions);
        logoSide = new ImageIcon(this.getClass().getResource("Resources/" + pictureSet + ".jpg"));
    }
}

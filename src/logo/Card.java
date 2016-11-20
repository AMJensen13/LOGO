/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author AMJensen13
 */
public class Card {
    ImageIcon questionSide = new ImageIcon(this.getClass().getResource("Resources/Template_Front.jpg"));
    ImageIcon logoSide = new ImageIcon(this.getClass().getResource("Resources/Template_Back.jpg"));
    ArrayList<Question> questions;
    
}

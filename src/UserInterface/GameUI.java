/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * @author AMJensen13
 */
public class GameUI extends JPanel{
    BoardUI boardUI;
    
    public GameUI()
    {
        super(new FlowLayout(FlowLayout.CENTER));
        boardUI = new BoardUI();
    }
    
    public void initUI()
    {
        boardUI.setPreferredSize(new Dimension(600, 600));
        this.add(boardUI);
        boardUI.initUI();
    }
}

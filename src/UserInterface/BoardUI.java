/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author AMJensen13
 */
public class BoardUI extends JPanel {
    Image bgImage = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("Resources/Board.jpg"));
    
    public BoardUI()
    {
        setBackground();
    }
    
    private void setBackground()
    {
        bgImage = bgImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}

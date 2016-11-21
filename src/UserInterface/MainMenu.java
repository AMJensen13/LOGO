/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author AMJensen13
 */
public class MainMenu extends JMenuBar implements ActionListener{
    
    public MainMenu()
    {
        
    }
    
    public void initUI()
    {
        JMenu file = new JMenu("File");
        this.add(file);
        
        JMenuItem close = new JMenuItem("Close");
        file.add(close);
        
        close.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

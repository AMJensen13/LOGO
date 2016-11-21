/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author AMJensen13
 */
public class MainWindow extends JFrame{
    GameUI gameUI;
    MainMenu mainMenu;
    
    public MainWindow()
    {
        super("Logo");
        gameUI = new GameUI();
        mainMenu = new MainMenu();
    }
    
    public void initUI()
    {
        gameUI.setPreferredSize(new Dimension(700,700));
        gameUI.initUI();
        mainMenu.initUI();
        this.setJMenuBar(mainMenu);
        this.add(gameUI);
    }
    
}

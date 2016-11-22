/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import logo.Card;
import logo.Enums;
import logo.Game;
import logo.Player;
import logo.Question;

/**
 *
 * @author AMJensen13
 */
public class MainWindow extends JFrame{
    GameUI gameUI;
    MainMenu mainMenu;
    CardPanel card;
    JPanel bottomPane;
    Game game;
    
    public MainWindow(Game game)
    {
        super("Logo");
        gameUI = new GameUI();
        mainMenu = new MainMenu();
        card = new CardPanel();
        bottomPane = new JPanel(new GridLayout(1, 2));
        this.game = game;
    }
    
    public void initUI(ArrayList<Player> players)
    {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        gameUI.setPreferredSize(new Dimension(600,600));
        gameUI.initUI(players);
        mainMenu.initUI();
        this.setJMenuBar(mainMenu);
        this.add(gameUI);
        
        JButton drawCard = new JButton("Draw Card");
        drawCard.addActionListener((ActionEvent e) -> 
        {
            Card theCard = game.drawCard();
            card.setCard(theCard.pictureSide);
            this.revalidate();
            this.repaint();
            game.askQuestions(theCard);
        });
        this.add(drawCard);
        
        this.add(bottomPane);
        
        JPanel playerList = new JPanel(new GridLayout(players.size(), 1));
        
        bottomPane.add(playerList);
        bottomPane.add(card);
        
        for(int i = 0; i < players.size(); i++)
        {
            JLabel player = new JLabel(players.get(i).getName());
            ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("Resources/" + textFromEnum(players.get(i).getPawn()) + "Pawn.png"));
            player.setIcon(icon);
            playerList.add(player);
        }
    }
    
    public void advancePawn(int colorIdx)
    {
        String nextColor = "";
        switch(colorIdx)
        {
            case 0:
                nextColor = "Red";
                break;
            case 1:
                nextColor = "Yellow";
                break;
            case 2: 
                nextColor = "Purple";
                break;
            case 3: 
                nextColor = "Green";
                break;
        }
        
        gameUI.boardUI.advancePawn(game.currentPlayer, nextColor);
    }
    
    private String textFromEnum(Enums.PawnType pawn)
    {
        return pawn.toString().toLowerCase();
    }
    
    public class CardPanel extends JPanel
    {
        private Image image;
        
        public CardPanel()
        {
        }
        
        public void setCard(Image theImage)
        {
            image = theImage;
        }
        
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
import UserInterface.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author AMJensen13
 */
public class Game {
    ArrayList<Card> cards = new ArrayList<>(
            Arrays.asList());
    ArrayList<Player> players;
    Deck deck;
    Player currentPlayer;
    
    MainWindow mainWindow;
    JDialog cardWindow;
    
    public Game()
    {
        deck = new Deck(cards);
        players = new ArrayList<Player>();
    }
    
    public void start()
    {
        boolean playing = true;
        setupUI();
        setupPlayers();
        
        while(playing)
        {
            
        }
    }
    
    private void setupUI()
    {
        mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(750, 750);
        mainWindow.setResizable(false);
        mainWindow.initUI();
        mainWindow.setVisible(true);
        
        cardWindow = new JDialog();
        
    }
    
    private void setupPlayers()
    {
        int playerCount = Integer.parseInt(JOptionPane.showInputDialog(null, "Pick a number of players between 3 and 6:", "Number of Players", JOptionPane.OK_OPTION));
        List<Enums.PawnType> availablePawns = new ArrayList<>(
                Arrays.asList(Enums.PawnType.RED, Enums.PawnType.BLUE, 
                              Enums.PawnType.GREEN, Enums.PawnType.YELLOW, 
                              Enums.PawnType.ORANGE, Enums.PawnType.PURPLE));
        
        for(int i = 0; i < playerCount; i++)
        {
            String name = JOptionPane.showInputDialog("Player " + (i + 1) + " please enter your name: ");
            Object pawn = JOptionPane.showInputDialog(
                    null, "Player " + (i + 1) + " please choose a pawn: ", "Choose a Pawn", 
                    JOptionPane.OK_OPTION, null, availablePawns.toArray(), availablePawns.get(0));
            
            players.add(new Player(name, (Enums.PawnType)pawn));
            availablePawns.remove((Enums.PawnType)pawn);
        }
        
        Collections.shuffle(players, new Random(System.currentTimeMillis()));
        currentPlayer = players.get(0);
    }
    
    public class CardPanel extends JPanel
    {
        private BufferedImage image;
        private ArrayList<Question> questions;
        
        public CardPanel(ArrayList<Question> questions, String imageName)
        {
            this.questions = questions;
            try {
                URL file = this.getClass().getClassLoader().getResource("Resources/.png");
                image = ImageIO.read(file);
            } catch(IOException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
import UserInterface.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author AMJensen13
 */
public class Game {
    ArrayList<Card> cards = new ArrayList<>(
            Arrays.asList(
            new Card(new ArrayList<>(
                    Arrays.asList(
                        new Question("Name three of the four animals that make up Cadbury Chocolate Animal Biscuits?", "Monkey, Lion, Tiger", 
                                new ArrayList<>(
                                        Arrays.asList(
                                            "Monkey, Lion, Tiger",
                                            "Monkey",
                                            "Kangaroo",
                                            "Gorilla"))),
                        new Question("What type of animal is COCO the COCO POPS character?", "Monkey", 
                                new ArrayList<>(
                                        Arrays.asList(
                                            "Monkey, Lion, Tiger",
                                            "Monkey",
                                            "Kangaroo",
                                            "Gorilla"))),
                        new Question("Which animal adorns a can of Foster’s lager?", "Kangaroo", 
                                new ArrayList<>(
                                        Arrays.asList(
                                            "Monkey, Lion, Tiger",
                                            "Monkey",
                                            "Kangaroo",
                                            "Gorilla"))),
                        new Question("What type of animal was playing the drums in the famous Cadbury Dairy Milk television advertisements?", "Gorilla", 
                                new ArrayList<>(
                                        Arrays.asList(
                                            "Monkey, Lion, Tiger",
                                            "Monkey",
                                            "Kangaroo",
                                            "Gorilla")))
                    )), "AnimalTheme.jpg")
            
            
            
            
            
            ));
    ArrayList<Player> players;
    Deck deck;
    public Player currentPlayer;
    
    MainWindow mainWindow;
    
    public Game()
    {
        deck = new Deck(cards);
        players = new ArrayList<>();
    }
    
    public void start()
    {
        setupPlayers();
        setupUI();
    }
    
    public Card drawCard()
    {
        return deck.drawCard();
    }
    
    public void nextPlayer()
    {
        int idx = players.indexOf(currentPlayer) + 1;
        if(idx >= players.size())
            idx = 0;
        currentPlayer = players.get(idx);
    }
    
    private void setupUI()
    {
        mainWindow = new MainWindow(this);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 650);
        mainWindow.setResizable(false); 
        mainWindow.initUI(players);  
        mainWindow.setVisible(true);     
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
}

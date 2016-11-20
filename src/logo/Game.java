/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;
import UserInterface.*;
import java.util.*;
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
    
    public Game()
    {
        deck = new Deck(cards);
        players = new ArrayList<Player>();
    }
    
    public void start()
    {
        setupUI();
        setupPlayers();
        
    }
    
    private void setupUI()
    {
        mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(750, 750);
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
            System.out.println(Arrays.toString(availablePawns.toArray()));
        }
        
        Collections.shuffle(players, new Random(System.currentTimeMillis()));
        currentPlayer = players.get(0);
    }
}

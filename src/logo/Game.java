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
                    )), "AnimalTheme.jpg"),
            
            new Card(new ArrayList<>(
                    Arrays.asList(
                        new Question("What is the name of the company with this logo?", "Amazon",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Google",
                                        "Amazon",
                                        "McDonald's",
                                        "Microsoft"))),
                        new Question("Amazon was founded by", "Jeff Bezos",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Jeff Wilke",
                                        "Andy Bezos",
                                        "John Moore",
                                        "Jeff Bezos"))),
                        new Question("Amazon started as what online business", "Book Store",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Book Store",
                                        "Apparel Store",
                                        "Toy Store",
                                        "Music Store"))),
                        new Question("In what year was Amazon founded?", "1994",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "1995",
                                        "1990",
                                        "1994",
                                        "1992"))))
                ), "AmazonPicture.jpg"),
            
            new Card(new ArrayList<>(
                    Arrays.asList(
                        new Question("What is the name of the company with this logo?", "Toyota",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "BMW",
                                        "Mercedes",
                                        "Toyota",
                                        "Ford"))),
                        new Question("When was Toyota founded?", "1937",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "1937",
                                        "1942",
                                        "1939",
                                        "1923"))),
                        new Question("Who is the founder of Toyota Motor Company?", "Kiichiro Toyoda",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Shoichiro  Toyoda",
                                        "Sakichi Takeshi",
                                        "Asado Toyoda",
                                        "Kiichiro Toyoda"))),
                        new Question("When did Toyota come to the US?", "1957",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "1949",
                                        "1962",
                                        "1953",
                                        "1957"))))
                ), "ToyotaPicture.jpg"),
            
            new Card(new ArrayList<>(
                    Arrays.asList(
                        new Question("Which type of clothing and footwear brand is named after a type of fuel?", "Diesel",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Nike",
                                        "Diesel",
                                        "BP",
                                        "Fossil"))),
                        new Question("Which luxury American car was named after the 17th Century French explorer who discovered the city of Detroit?", "Cadillac",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Ford",
                                        "Cadillac",
                                        "Chevy",
                                        "Lincoln"))),
                        new Question("What type of consumer item is a Cannon, Nikon, or Olympus?", "Camera",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Camera",
                                        "Sports Drink",
                                        "Shoes",
                                        "clothes"))),
                        new Question("With whom does Barbie have an on-off romantic relationship?", "Ken",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "James",
                                        "Ryan",
                                        "Brad",
                                        "Ken"))))
                ), "PotLuck.jpg"),
            
            new Card(new ArrayList<>(
                    Arrays.asList(
                        new Question("Name the brand of soap", "Dove",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Dove",
                                        "Turkey",
                                        "Peacock",
                                        "Hummingbird"))),
                        new Question("Name the brand of matches", "Swan Vestas",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Eagle",
                                        "Phoenix",
                                        "Goose",
                                        "Swan Vestas"))),
                        new Question("Name the brand of shoe polish", "Kiwi",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "English Pigeon",
                                        "Red Hawk",
                                        "Kiwi",
                                        "Roadrunner"))),
                        new Question("Name the brand of cider", "Woodpecker",
                                new ArrayList<>(
                                        Arrays.asList(
                                        "Crane",
                                        "Woodpecker",
                                        "Grey Goose",
                                        "Yellow Tail"))))
                ), "BirdsTheme.jpg")
            
            
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
    
    public Player nextPlayer()
    {
        int idx = players.indexOf(currentPlayer) + 1;
        if(idx >= players.size())
            idx = 0;
        currentPlayer = players.get(idx);
        return currentPlayer;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    Card currentCard;
    CardPanel card;
    JPanel bottomPane;
    Game game;
    QuestionPanel questionPane;
    
    public MainWindow(Game game)
    {
        super("Logo");
        gameUI = new GameUI();
        mainMenu = new MainMenu();
        card = new CardPanel();
        bottomPane = new JPanel();
        this.game = game;
    }
    
    public void initUI(ArrayList<Player> players)
    {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        
        card.setPreferredSize(new Dimension(339, 180));
        
        gameUI.setPreferredSize(new Dimension(400,400));
        gameUI.initUI(players);
        mainMenu.initUI();
        bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.Y_AXIS));
        bottomPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionPane = new QuestionPanel();
        this.setJMenuBar(mainMenu);
        this.add(gameUI);
        
        JButton drawCard = new JButton("Draw Card");
        drawCard.addActionListener((ActionEvent e) -> 
        {
            currentCard = game.drawCard();
            card.setCard(currentCard.pictureSide);
            this.revalidate();
            this.repaint();
            questionPane.initQuestion(currentCard, game.currentPlayer);
        });
        
        this.add(bottomPane);
        
        JPanel playerList = new JPanel(new GridLayout(1, players.size()));
        
        bottomPane.setPreferredSize(new Dimension(600,250));
        bottomPane.add(playerList);
        bottomPane.add(drawCard, BorderLayout.CENTER);
        bottomPane.add(card, BorderLayout.CENTER);
        bottomPane.add(questionPane, BorderLayout.CENTER);
        
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
    
    public class QuestionPanel extends JPanel
    {
        Card currentCard;
        Question currentQuestion;
        Player startingPlayer;
        int qNum;
        
        JLabel currentPlayer;
        JLabel question;
        ButtonGroup group;
        JRadioButton opt1;
        JRadioButton opt2;
        JRadioButton opt3;
        JRadioButton opt4;
        JButton submit;
        
        public QuestionPanel()
        {
            initUI();
        }
        
        private void initUI()
        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            currentPlayer = new JLabel();
            question = new JLabel();
            opt1 = new JRadioButton();
            opt2 = new JRadioButton();
            opt3 = new JRadioButton();
            opt4 = new JRadioButton();
            group = new ButtonGroup();
            submit = new JButton("Submit");
            
            submit.addActionListener((ActionEvent e) ->{
                checkQuestion();
            });
            
            this.add(currentPlayer);
            this.add(question);
            this.add(opt1);
            this.add(opt2);
            this.add(opt3);
            this.add(opt4);
            
            this.add(submit);
            this.setVisible(false);
        }
        
        public void initQuestion(Card card, Player startingPlayer)
        {
            this.setVisible(true);
            this.startingPlayer = startingPlayer;
            currentPlayer.setText("Current Player: " + this.startingPlayer.getName());
            currentCard = card;
            
            group.add(opt1);
            group.add(opt2);
            group.add(opt3);
            group.add(opt4);
            
            nextQuestion();
        }
        
        private void checkQuestion()
        {
            String selected;
            
            if(opt1.isSelected())
            {
                selected = opt1.getText();
                opt1.setSelected(false);
            }
            else if(opt2.isSelected())
            {
                selected = opt2.getText();
                opt2.setSelected(false);
            }
            else if(opt3.isSelected())
            {
                selected = opt3.getText();
                opt3.setSelected(false);
            }
            else
            {
                selected = opt4.getText();
                opt4.setSelected(false);
            }
            
            if(!currentQuestion.CheckAnswer(selected))
            {
                JOptionPane.showMessageDialog(this, "That answer is incorrect.");
                currentPlayer.setText("Current Player: " + game.nextPlayer().getName());
                if(startingPlayer.equals(game.currentPlayer))
                    this.setVisible(false);
            } 
            else
            {
                JOptionPane.showMessageDialog(this, "That answer is correct!");
                advancePawn(qNum);
                startingPlayer = game.currentPlayer;
                nextQuestion();
            }
        }
        
        private void nextQuestion()
        {
            qNum = currentCard.questions.indexOf(currentQuestion) + 1;
            Color col = Color.WHITE;
            switch(qNum)
            {
                case 0:
                    col = Color.RED;
                    break;
                case 1:
                    col = Color.YELLOW;
                    break;
                case 2: 
                    col = Color.MAGENTA;
                    break;
                case 3: 
                    col = Color.GREEN;
                    break;
            }
            
            if(qNum == currentCard.questions.size())
            {
                this.setVisible(false);
                return;
            }
            question.setBackground(col);
            currentQuestion = currentCard.questions.get(qNum);
            
            question.setText(currentQuestion.getQuestion());
            opt1.setText(currentQuestion.getOptions().get(0));
            opt2.setText(currentQuestion.getOptions().get(1));
            opt3.setText(currentQuestion.getOptions().get(2));
            opt4.setText(currentQuestion.getOptions().get(3));
            
        }
        
    }
}

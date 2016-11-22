/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import logo.Enums;
import logo.Player;

/**
 *
 * @author AMJensen13
 */
public class BoardUI extends JPanel {
    
    public class Tile{
        public String color;
        public List<Dimension> locs;
        
        public Tile(String color, List<Dimension> locs)
        {
            this.color = color;
            this.locs = locs;
        }
    }
    Image bgImage;
    ArrayList<Image> pawns;
    ArrayList<Player> players;
    List<Tile> tiles;
    
    public BoardUI()
    {
        super(new FlowLayout(FlowLayout.CENTER));
        tiles = new ArrayList<>();
        pawns = new ArrayList<>();
        initTiles();
    }
    
    public void initUI(ArrayList<Player> players)
    {
        this.players = players;
        try {
            URL file = this.getClass().getClassLoader().getResource("Resources/Board.png");
            bgImage = ImageIO.read(file);
            for(Player p : players)
            {
                Image img = ImageIO.read(this.getClass().getClassLoader().getResource("Resources/" + textFromEnum(p.getPawn()) + "Pawn.png"));
                pawns.add(img);
            }
        } catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        for(int i = 0; i < players.size(); i++)
        {
            players.get(i).pawnLoc = tiles.get(0).locs.get(i);
        }
    }
    
    private String textFromEnum(Enums.PawnType pawn)
    {
        return pawn.toString().toLowerCase();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, 600, 600, this);
        for(int i = 0; i < players.size(); i++)
        {
            Player p = players.get(i);
            g.drawImage(pawns.get(i), p.pawnLoc.width, p.pawnLoc.height, this);
        }
    }
    
    public void advancePawn(Player p, String nextColor)
    {
        boolean foundLoc = false;
        for(Tile t : tiles)
        {
            if(t.color.equals(p.pawnLocColor) && t.locs.contains(p.pawnLoc))
            {
                foundLoc = true;
            }
            if(foundLoc && t.color.equals(nextColor))
            {
                p.pawnLoc = t.locs.get(players.indexOf(p));
                p.pawnLocColor = t.color;
                this.revalidate();
                this.repaint();
                break;
            }
        }
    }
    
    private void initTiles()
    {
        tiles.add(new Tile("Start", new ArrayList<>(Arrays.asList(
                new Dimension(280, 508),
                new Dimension(276, 480),
                new Dimension(260, 485)
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(223, 467),
                new Dimension(220, 456),
                new Dimension(228, 447)
        ))));
        tiles.add(new Tile("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(176, 428),
                new Dimension(147, 416),
                new Dimension(113, 399)
        ))));
        tiles.add(new Tile("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(95, 351),
                new Dimension(125, 323),
                new Dimension(94, 288)
        ))));
        tiles.add(new Tile("Green", new ArrayList<>(Arrays.asList(
                new Dimension(126, 244),
                new Dimension(94, 210),
                new Dimension(118, 174)
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(134, 138),
                new Dimension(165, 127),
                new Dimension(193, 108)
        ))));
        tiles.add(new Tile("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(229, 86),
                new Dimension(262, 70),
                new Dimension(289, 51)
        ))));
        tiles.add(new Tile("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(323, 53),
                new Dimension(353, 72),
                new Dimension(380, 91)
        ))));
        tiles.add(new Tile("Green", new ArrayList<>(Arrays.asList(
                new Dimension(423, 112),
                new Dimension(456, 134),
                new Dimension(488, 146)
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(510, 194),
                new Dimension(478, 236),
                new Dimension(501, 251)
        ))));
        tiles.add(new Tile("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(475, 308),
                new Dimension(505, 348),
                new Dimension(479, 374)
        ))));
        tiles.add(new Tile("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(457, 405),
                new Dimension(430, 420),
                new Dimension(398, 440)
        ))));
        tiles.add(new Tile("Green", new ArrayList<>(Arrays.asList(
                new Dimension(375, 460),
                new Dimension(355, 461),
                new Dimension(346, 481)
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Green", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Green", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Green", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
        tiles.add(new Tile("Win", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        ))));
    }
}

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
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author AMJensen13
 */
public class BoardUI extends JPanel {
    Image bgImage;
    HashMap<String, List<Dimension>> tiles;
    
    public BoardUI()
    {
        super(new FlowLayout(FlowLayout.CENTER));
        tiles = new HashMap<>();
        initTiles();
    }
    
    public void initUI()
    {
        try {
            URL file = this.getClass().getClassLoader().getResource("Resources/Board.png");
            bgImage = ImageIO.read(file);
        } catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, 600, 600, this);
    }
    
    private void initTiles()
    {
        tiles.put("Start", new ArrayList<>(Arrays.asList(
                new Dimension(300, 520),
                new Dimension(296, 482),
                new Dimension(260, 486)
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(233, 477),
                new Dimension(205, 456),
                new Dimension(225, 437)
        )));
        tiles.put("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(176, 428),
                new Dimension(147, 416),
                new Dimension(113, 399)
        )));
        tiles.put("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(95, 351),
                new Dimension(125, 323),
                new Dimension(94, 288)
        )));
        tiles.put("Green", new ArrayList<>(Arrays.asList(
                new Dimension(126, 244),
                new Dimension(94, 210),
                new Dimension(118, 174)
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(134, 138),
                new Dimension(165, 127),
                new Dimension(193, 108)
        )));
        tiles.put("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(229, 86),
                new Dimension(262, 70),
                new Dimension(289, 51)
        )));
        tiles.put("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(323, 53),
                new Dimension(353, 72),
                new Dimension(380, 91)
        )));
        tiles.put("Green", new ArrayList<>(Arrays.asList(
                new Dimension(423, 112),
                new Dimension(456, 134),
                new Dimension(488, 146)
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(510, 194),
                new Dimension(478, 236),
                new Dimension(501, 251)
        )));
        tiles.put("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(475, 308),
                new Dimension(505, 348),
                new Dimension(479, 374)
        )));
        tiles.put("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(457, 405),
                new Dimension(430, 420),
                new Dimension(398, 440)
        )));
        tiles.put("Green", new ArrayList<>(Arrays.asList(
                new Dimension(375, 460),
                new Dimension(355, 461),
                new Dimension(346, 481)
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Green", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Green", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Purple", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Green", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Yellow", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Red", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
        tiles.put("Win", new ArrayList<>(Arrays.asList(
                new Dimension(),
                new Dimension(),
                new Dimension()
        )));
    }
}

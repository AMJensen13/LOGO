/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.awt.Dimension;

/**
 *
 * @author AMJensen13
 */
public class Player {
    String name;
    Enums.PawnType pawn;
    public Dimension pawnLoc;
    public String pawnLocColor = "Start";
    
    public Player(String name, Enums.PawnType pawnType)
    {
        this.name = name;
        this.pawn = pawnType;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Enums.PawnType getPawn()
    {
        return pawn;
    }
}

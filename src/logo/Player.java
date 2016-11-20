/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

/**
 *
 * @author AMJensen13
 */
public class Player {
    String name;
    Enums.PawnType pawn;
    
    public Player(String name, Enums.PawnType pawnType)
    {
        this.name = name;
        this.pawn = pawnType;
    }
}

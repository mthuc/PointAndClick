/***************************************************************
* file: ColorGame.java
* author: Andrew Tek, Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: This class holds the basic logic for the color game
*
****************************************************************/
package cs245p1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;


public class ColorGame {
    private int points;
    private int rounds;
    
    //method: ColorGame (Constructor)
    //purpose: Initialize class set points = 0 and rounds = 0
    public ColorGame() {
        points = 0;
        rounds = 0;
    }
    
    //method: roundProcessing
    //purpose: Method to call when a round of the game has been played. Boolean passed to it
    //indicates whether the score should be increased or not. Rounds are always incremented at the end.
    public void roundProcessing(boolean addPoints){
        if(addPoints){
            this.addPoints(100);
        }
        rounds++;
    }
    
    //method: addPoints
    //purpose: add points to the game score
    private void addPoints(int amount) {
        if(rounds < 5){ //only allow increases of points for a max of 5 rounds
            points += amount;
        }
    }
    
    //method: getPoints
    //purpose: return number of points
    public int getPoints() {
        return points;
    }
    
    //method: checkRounds
    //purpose: return the number of rounds played
    public int checkRounds(){
        return rounds;
    }
    
    //method: resetGame
    //purpose: reset points to 0 and rounds to 0
    public void resetGame() {
        points = 0;
        rounds = 0;
    }
    
    //method: configureLabel
    //purpose: Set the color and the text of a label to different colors
    public void configureLabel(JLabel label) {
        List <String> colors = new ArrayList();
        colors.add("RED");
        colors.add("BLUE");
        colors.add("YELLOW");
        colors.add("GREEN");
        colors.add("PURPLE");
        Collections.shuffle(colors);
        label.setText(colors.remove(0));
        String colorOfText = colors.remove(0);
        switch (colorOfText) {
            case "RED":
                label.setForeground(Color.RED);
                break;
            case "BLUE":
                label.setForeground(Color.BLUE);
                break;
            case "YELLOW":
                label.setForeground(Color.YELLOW);
                break;
            case "GREEN":
                label.setForeground(Color.GREEN);
                break;
            case "PURPLE":
                label.setForeground(Color.MAGENTA);
        }
        
        
    }
}

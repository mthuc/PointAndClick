/***************************************************************
* file: Scores.java
* author: Nicholas Pham
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/07/2017
*
* purpose: This class creates the object of each individual score
*
****************************************************************/

package cs245p1;

/**
 * this class stores the objects of each high score and allows for storage in the high scores list.
 */
public class Scores {
    
    // name of player or user
    private String player;
    // player's high score
    private int score;

    // method: Scores
    // purpose: constructor for player name and score
    public Scores(String player, int score) {
        this.player = player;
        this.score = score;
    }
    
    // method: Scores
    // purpose: constructor for player score
    public Scores(int score) {
        this.score = score;
    }
    
    // method: getPlayer
    // purpose: return name of player (String)
    public String getPlayer() {
        return player;
    }
    
    // method: getScore
    // purpose: return score of player
    public int getScore() {
        return score;
    }
    
    // method: setPlayer
    // purpose: set name of player
    public void setPlayer(String player) {
        this.player = player;
    }
    
    // method: setScore
    // purpose: set score of player
    public void setScore(int score) {
        this.score = score;
    }
}

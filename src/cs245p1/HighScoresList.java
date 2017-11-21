/***************************************************************
* file: HighScoresList.java
* author: Nicholas Pham, Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: This class creates the list of high scores accumulated
*
****************************************************************/

package cs245p1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.io.File;

/**
 * this class stores the high scores list to display on its respective panel.
 */
public class HighScoresList {
    
    // list of high scores (see: Scores)
    private ArrayList<Scores> highScores;
    // reader to read file
    private BufferedReader br;
    // file to write to
    private File file;
    // filewriter to write to file
    private FileWriter fw;
    // writer for file
    private BufferedWriter bw;
    
    
    // method: HighScoresList
    // purpose: constructor
    public HighScoresList() {
        highScores = new ArrayList<Scores>();
        loadFile();
    }
    
    // method: getScores
    // purpose: return list of high scores
    public ArrayList<Scores> getScores() {
        return highScores;
    }
    
    // method: loadFile
    // purpose: read in names and scores from file
    public void loadFile() {
        try {
            try {
                // [Player, Score]
                String[] info;
                // Line to read
                String textLine;
                // Player name read
                String name;
                // Player score read
                int score;
                
                // Load file to reader
                br = new BufferedReader(new FileReader("src/highscores.txt"));
                // Read file until last line
                while ((textLine = br.readLine()) != null) {
                   // Delimiter in file is ","
                    info = textLine.split(",");
                    
                    name = info[0];
                    score = Integer.parseInt(info[1]);
                    // Add player and associated score to list
                    highScores.add(new Scores(name, score));
                }
            } finally {
                // Close reader
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // method: update
    // purpose: update text file
    public void update() {
        try {
            file = new File("src/highscores.txt");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            for (int i = 0; i < 5; i++) {
                bw.write(highScores.get(i).getPlayer() + "," + highScores.get(i).getScore() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // method: addScore
    // purpose: add new high score to list - only call on a score that is already confirmed to be
    //a new high score. This method trims the high score list down to 4 items before adding the newest
    //high score (since the lowest high score should always get bumped off the list).
    public void addScore(Scores score) {
        while(highScores.size() > 4){
            highScores.remove((highScores.size()-1));
        }
        
        highScores.add(score);
    }
    
    // method: sortScores
    // purpose: sort scores from highest to lowest
    public void sortScores() {
        CompareScore comparator = new CompareScore();
        Collections.sort(highScores, comparator);
    }
    
    // method: toString
    // purpose: writes array list to string per line (mainly for testing)
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < 5; i++) {
            output += highScores.get(i).getPlayer() + ": " + highScores.get(i).getScore() + "\n";
        }
        return output;
    }
    
    // method: size
    // purpose: return size of high scores list
    public int size() {
        return highScores.size();
    }
    
    // method: checkIfHighScore
    // purpose: checks an inputted score belongs in the top 5
    public boolean checkIfHighScore(int score) {
        if (score >= highScores.get(4).getScore()) {
            return true;
        }
        else {
            return false;
        }
    }
}
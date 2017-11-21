/***************************************************************
* file: HangManGame.java
* author: Christopher Kilian, Andrew Tek
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/09/2017
*
* purpose: This class handles the actual game play functionality behind
* the Hangman game
*
****************************************************************/
package cs245p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HangManGame {
    
    //Constants and instance variables
    private static final int FAIL_SCORE = 40;
    private List<String> wordsList;
    private int points;
    private int incorrectGuesses;
    private String gameWord;
    
    //method: constructor
    //purpose: Builds the game environment by initializing score and correct points, randomly choosing a word from the database,
    //and initializing the number of correct guesses needed for a win by checking how many unique characters exist in the chosen word
    public HangManGame(){
        wordsList = new ArrayList<>();
        wordsList.add("cemetery");
        wordsList.add("nurse");
        wordsList.add("abstract");
        wordsList.add("pharmacy");
        wordsList.add("climbing");
        Collections.shuffle(wordsList);
        gameWord = wordsList.get(0);
        incorrectGuesses = 0;
        points = 100;
    }
    
    //method: getPoints
    //purpose: Getter which returns the players score
    public int getPoints(){
        return points;
    }
    
    //method: getWord
    //purpose: Getter which returns the word chosen for this game
    public String getWord () {
        return gameWord;
    }
    
    //method: getWordLength
    //purpose: A simple getter which returns the length of the chosen word so that the
    //display knows how many dashes to place
    public int getWordLength(){
        return gameWord.length();
    }
    
    //method: skipGame
    //purpose: Called when a player decides to skip a word, this method sets their score to 0
    public void skipGame(){
        points = 0;
    }
    
    //method: getIncorrect
    //purpose: Returns number of incorrect guesses this game
    public int getIncorrect(){
        return incorrectGuesses;
    }

    
    //method: checkForWin
    //purpose: A method returning a boolean which indicates whether the player has won the game or not
    public boolean checkForWin(String s){
        boolean win = false;
        if((points > FAIL_SCORE) && (gameWord.equals(s))){
            win = true;
        }
        return win;
    }

    //method: checkLetter
    //purpose: This method accepts a letter (in the form of a string) and checks the "game word"
    //(chosen at random when the game is instantiated) to see what the positons in the word (if any) are for
    //the guessed letter. An arraylist is returned, so if the letter is not found anywhere in the word it will
    //return an empty arraylist. Otherwise, the arraylist will contain all the index values of the word.
    //This method will also reduce the players score if the letter is not in the word.
    public ArrayList<Integer> checkLetter(String theLetter){
        ArrayList foundIndices = new ArrayList();
        int foundIndex = gameWord.indexOf(theLetter);
        if(foundIndex == -1){
            points -= 10;
            incorrectGuesses++;
        }
        
        while(foundIndex >= 0){
            foundIndices.add(foundIndex);
            foundIndex = gameWord.indexOf(theLetter, foundIndex+1);
        }
        
        return foundIndices;
    }
    
}

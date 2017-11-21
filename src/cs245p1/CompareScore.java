/***************************************************************
* file: CompareScore.java
* author: Nicholas Pham
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: Comparator for two score objects
*
****************************************************************/
package cs245p1;

import java.util.Comparator;

/**
 * This class compares two scores (to see if higher or lower)
 */
public class CompareScore implements Comparator<Scores> {
    // method: compare
    // purpose: compare 2 high scores to see which is higher or lower
    public int compare(Scores score1, Scores score2) {
        int val1 = score1.getScore();
        int val2 = score2.getScore();
        if (val1 > val2){
            return -1;
        }
        else if (val1 < val2){
            return 1;
        } else {
            return 0;
        }    
    }
}

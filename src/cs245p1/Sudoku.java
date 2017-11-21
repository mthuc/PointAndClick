/***************************************************************
* file: Sudoku.java
* author: Nicholas Pham
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.2
* date last modified: 10/22/2017
*
* purpose: This class is the base for the Sudoku game
*
****************************************************************/
package cs245p1;

/**
 *
 * @author Nicholas Pham
 */
public class Sudoku {
    
    // Correct solution (by row) given in PDF
    private int[] solution = {8, 3, 5, 4, 1, 6, 9, 2, 7,
                              2, 9, 6, 8, 5, 7, 4, 3, 1,
                              4, 1, 7, 2, 9, 3, 6, 5, 8,
                              5, 6, 9, 1, 3, 4, 7, 8, 2,
                              1, 2, 3, 6, 7, 8, 5, 4, 9,
                              7, 4, 8, 5, 2, 9, 1, 6, 3,
                              6, 5, 2, 7, 8, 1, 3, 9, 4,
                              9, 8, 1, 3, 4, 5, 2, 7, 6,
                              3, 7, 4, 9, 6, 2, 8, 1, 5};
    
    private int points;
    
    public Sudoku() {
        points = 540;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void subPoints() {
        points = points - 10;
    }
    
    public int[] getSolution() {
        return solution;
    }
}

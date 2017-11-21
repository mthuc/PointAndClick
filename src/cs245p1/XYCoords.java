/***************************************************************
* file: XYCoords.java
* author: Christopher Kilian
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: Data class which holds specified x and y coordinates
* for use in the absolute positioning of the randomized color button
* locations.
*
****************************************************************/
package cs245p1;

class XYCoords {
    private int x;
    private int y;
    
    //method: XYCoords
    //purpose: Constructor - saves the passed x and y coordinates
    public XYCoords(int passedX, int passedY){
        x = passedX;
        y = passedY;
    }
    
    //method: getX
    //purpose: getter for the x-coordinate
    public int getX(){
        return x;
    }
    
    //method: getY
    //purpose: getter for the y-coordinate
    public int getY(){
        return y;
    }
    
    //method: toString
    //purpose: overridden version of toString (for test printouts mainly)
    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }
}

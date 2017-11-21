/***************************************************************
* file: ColorGamePanel.java
* author: Christopher Kilian, Andrew Tek
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: The panel from which the color choosing game is played is set up
* in this code.
*
****************************************************************/
package cs245p1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;

public class ColorGamePanel extends javax.swing.JPanel {
    //Please note: Auto-generated instance variables are automatically placed at the end of the class definition and cannot be moved
    //These lists are used to hold sets of valid coordinates for the randomized button positions
    //The lists are consumed when button position is randomized and will need to be reset between games (method provided)
    private List<List<XYCoords>> randomCoords;
    private List<XYCoords> coordSet1;
    private List<XYCoords> coordSet2;
    private List<XYCoords> coordSet3;
    private List<XYCoords> coordSet4;
    private List<XYCoords> coordSet5;
    private List<XYCoords> coordSet6;
    //use to prevent multiple clicks on a button before panel has a chance to update
    private boolean buttonWaitFlag; //if true, don't wait, if false then wait
    
    // method: ColorGamePanel
    // purpose: Constructor. Builds the panel and initializes coordinate lists.
    public ColorGamePanel() {
        initComponents();
        resetCoordsSets();
        buttonWaitFlag = true;
        ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
            Date date = new Date();
            clockLabel.setText(dateFormat.format(date).toString());
            int points = CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            jLabelUserScore.setText("User Score: " + points);
        }
    };
        Timer timer = new Timer (1000, updateClock);
        timer.setRepeats(true);
        timer.start(); 
        randomizeButtons();
        CS245P1.getColorGame().configureLabel(colorLabel);
    }
    
    // method: randomizeButtons
    // purpose: randomize positions of buttons on page using the predefined lists of acceptable coordinate groups.
    //Note that these coordinates will be consumed as a part of the randomization process, and so will need to be reset
    //when the game is finished in order to play a new game (method provided).
    private void randomizeButtons(){
        Random rand = new Random();
        List<JButton> buttonList = new ArrayList();
        List<XYCoords> coordList = randomCoords.remove(rand.nextInt(randomCoords.size())); //get random set of coordinates and remove from list
        
        buttonList.add(jButtonRed);
        buttonList.add(jButtonBlue);
        buttonList.add(jButtonYellow);
        buttonList.add(jButtonGreen);
        buttonList.add(jButtonPurple);
        
        colorButtonPanel.remove(jButtonRed);
        colorButtonPanel.remove(jButtonBlue);
        colorButtonPanel.remove(jButtonYellow);
        colorButtonPanel.remove(jButtonGreen);
        colorButtonPanel.remove(jButtonPurple);
        
        while(!buttonList.isEmpty() && !coordList.isEmpty()){
            JButton currentButton = buttonList.remove(rand.nextInt(buttonList.size())); //pick a random button
            XYCoords currentCoord = coordList.remove(rand.nextInt(coordList.size())); //pick random coordinate from current list
            colorButtonPanel.add(currentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(currentCoord.getX(), currentCoord.getY()));
        }
        colorButtonPanel.repaint();

    }
    
    // method: buttonClickActions
    // purpose: These actions are common to every button in this panel, and so they are gathered in this
    //one method which is called by the click handlers. Sets buttonWaitFlag to false while operating so that only
    //one button operation is handled at a time. Runs the game method, and decision to either
    //move to the game over screen or initiate another round.
    private void buttonClickActions(boolean addPoints){
        buttonWaitFlag = false; //don't let other buttons operate while button actions being processed
        CS245P1.getColorGame().roundProcessing(addPoints);
        if(CS245P1.getColorGame().checkRounds() >= 5){
            // transitionToGameOver();
            transitionToSudoku();
        }else{
            CS245P1.getColorGame().configureLabel(colorLabel);
            randomizeButtons();
        }
        buttonWaitFlag = true; //button actions completed, allow more button operations
    }
    
    // method: resetCoordsList
    // purpose: resets the randomCoords list for a new game (since elements are consumed as a game is played)
    private void resetCoordsList(){
        randomCoords = new ArrayList();
        randomCoords.add(coordSet1);
        randomCoords.add(coordSet2);
        randomCoords.add(coordSet3);
        randomCoords.add(coordSet4);
        randomCoords.add(coordSet5);
        randomCoords.add(coordSet6);
    }
    
    // method: transitionToGameOver
    // purpose: Handles the transitioning to the game over screen once a game is done. Resets coordinate
    //values, sets the score on the game over panel, and switches to that panel.
    private void transitionToGameOver(){
        //reset panel values to initial state
        resetCoordsSets();
        //set score on game over panel and move to that panel
        GameOverPanel gameOver = (GameOverPanel)CS245P1.getPanelMap().get(CS245P1.GAME_OVER);
        gameOver.setScore();
        CS245P1.getPrimaryLayout().show(CS245P1.getPrimaryCardHolder(), CS245P1.GAME_OVER);
        gameOver.checkForHighScore();
    }
    
    private void transitionToSudoku() {
        //reset panel values to initial state
        resetCoordsSets();
        CS245P1.getPrimaryLayout().show(CS245P1.getPrimaryCardHolder(), CS245P1.SUDOKU);
    }
    
    // method: resetCoordsSets
    // purpose: initialize coordinate lists with pre-defined valid coordinates for "random" button placement
    private void resetCoordsSets(){
        coordSet1 = new ArrayList();
        coordSet1.add(new XYCoords(300, 20));
        coordSet1.add(new XYCoords(230, 170));
        coordSet1.add(new XYCoords(420, 180));
        coordSet1.add(new XYCoords(90, 70));
        coordSet1.add(new XYCoords(50, 210));
        
        coordSet2 = new ArrayList();
        coordSet2.add(new XYCoords(30, 160));
        coordSet2.add(new XYCoords(20, 10));
        coordSet2.add(new XYCoords(330, 210));
        coordSet2.add(new XYCoords(180, 130));
        coordSet2.add(new XYCoords(430, 100));
        
        coordSet3 = new ArrayList();
        coordSet3.add(new XYCoords(440, 70));
        coordSet3.add(new XYCoords(30, 190));
        coordSet3.add(new XYCoords(160, 110));
        coordSet3.add(new XYCoords(270, 20));
        coordSet3.add(new XYCoords(460, 200));
        
        coordSet4 = new ArrayList();
        coordSet4.add(new XYCoords(120, 190));
        coordSet4.add(new XYCoords(380, 30));
        coordSet4.add(new XYCoords(20, 70));
        coordSet4.add(new XYCoords(220, 110));
        coordSet4.add(new XYCoords(460, 200));
        
        coordSet5 = new ArrayList();
        coordSet5.add(new XYCoords(190, 120));
        coordSet5.add(new XYCoords(300, 210));
        coordSet5.add(new XYCoords(410, 80));
        coordSet5.add(new XYCoords(240, 10));
        coordSet5.add(new XYCoords(50, 50));
        
        coordSet6 = new ArrayList();
        coordSet6.add(new XYCoords(160, 200));
        coordSet6.add(new XYCoords(450, 180));
        coordSet6.add(new XYCoords(400, 10));
        coordSet6.add(new XYCoords(30, 60));
        coordSet6.add(new XYCoords(140, 20));
        
        resetCoordsList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clockLabel = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        colorButtonPanel = new javax.swing.JPanel();
        jButtonPurple = new javax.swing.JButton();
        jButtonRed = new javax.swing.JButton();
        jButtonGreen = new javax.swing.JButton();
        jButtonYellow = new javax.swing.JButton();
        jButtonBlue = new javax.swing.JButton();
        jLabelUserScore = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        clockLabel.setText("Clock Here");
        clockLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
        clockLabel.setPreferredSize(new java.awt.Dimension(150, 25));

        colorLabel.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        colorLabel.setText("Black");

        colorButtonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPurple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple button image small transparent.png"))); // NOI18N
        jButtonPurple.setToolTipText("");
        jButtonPurple.setBorder(null);
        jButtonPurple.setBorderPainted(false);
        jButtonPurple.setContentAreaFilled(false);
        jButtonPurple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPurpleMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonPurpleMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonPurpleMouseEntered(evt);
            }
        });
        colorButtonPanel.add(jButtonPurple, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 85, 89));

        jButtonRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red button image small transparent.png"))); // NOI18N
        jButtonRed.setToolTipText("");
        jButtonRed.setBorder(null);
        jButtonRed.setBorderPainted(false);
        jButtonRed.setContentAreaFilled(false);
        jButtonRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRedMouseExited(evt);
            }
        });
        colorButtonPanel.add(jButtonRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 85, 89));

        jButtonGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green button image small transparent.png"))); // NOI18N
        jButtonGreen.setToolTipText("");
        jButtonGreen.setBorder(null);
        jButtonGreen.setBorderPainted(false);
        jButtonGreen.setContentAreaFilled(false);
        jButtonGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGreenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonGreenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonGreenMouseExited(evt);
            }
        });
        colorButtonPanel.add(jButtonGreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 85, 89));

        jButtonYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellow button image small transparent.png"))); // NOI18N
        jButtonYellow.setToolTipText("");
        jButtonYellow.setBorder(null);
        jButtonYellow.setBorderPainted(false);
        jButtonYellow.setContentAreaFilled(false);
        jButtonYellow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonYellowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonYellowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonYellowMouseExited(evt);
            }
        });
        colorButtonPanel.add(jButtonYellow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 85, 89));

        jButtonBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue button image small transparent.png"))); // NOI18N
        jButtonBlue.setToolTipText("");
        jButtonBlue.setBorder(null);
        jButtonBlue.setBorderPainted(false);
        jButtonBlue.setContentAreaFilled(false);
        jButtonBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBlueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBlueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBlueMouseExited(evt);
            }
        });
        colorButtonPanel.add(jButtonBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 85, 89));

        jLabelUserScore.setText("User Score:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                        .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(colorButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUserScore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(colorLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // method: jButtonGreenMouseEntered
    // purpose: handles highlighting of the button
    private void jButtonGreenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGreenMouseEntered
        jButtonGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green button image highlighted.png")));
    }//GEN-LAST:event_jButtonGreenMouseEntered

    // method: jButtonGreenMouseExited
    // purpose: handles de-highlighting of the button
    private void jButtonGreenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGreenMouseExited
        jButtonGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/green button image small transparent.png")));
    }//GEN-LAST:event_jButtonGreenMouseExited

    // method: jButtonBlueMouseEntered
    // purpose: handles highlighting of the button
    private void jButtonBlueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBlueMouseEntered
        jButtonBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue button image highlighted.png"))); 
    }//GEN-LAST:event_jButtonBlueMouseEntered

    // method: jButtonBlueMouseExited
    // purpose: handles de-highlighting of the button
    private void jButtonBlueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBlueMouseExited
        jButtonBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blue button image small transparent.png"))); 
    }//GEN-LAST:event_jButtonBlueMouseExited

    // method: jButtonPurpleMouseEntered
    // purpose: handles highlighting of the button
    private void jButtonPurpleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPurpleMouseEntered
        jButtonPurple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple button image highlighted.png")));
    }//GEN-LAST:event_jButtonPurpleMouseEntered

    // method: jButtonPurpleMouseExited
    // purpose: handles de-highlighting of the button
    private void jButtonPurpleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPurpleMouseExited
        jButtonPurple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purple button image small transparent.png")));
    }//GEN-LAST:event_jButtonPurpleMouseExited

    // method: jButtonYellowMouseEntered
    // purpose: handles highlighting of the button
    private void jButtonYellowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonYellowMouseEntered
        jButtonYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellow button image highlighted.png")));
    }//GEN-LAST:event_jButtonYellowMouseEntered

    // method: jButtonYellowMouseExited
    // purpose: handles de-highlighting of the button
    private void jButtonYellowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonYellowMouseExited
        jButtonYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellow button image small transparent.png")));
    }//GEN-LAST:event_jButtonYellowMouseExited

    // method: jButtonRedMouseEntered
    // purpose: handles highlighting of the button
    private void jButtonRedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRedMouseEntered
        jButtonRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red button image highlighted.png")));
    }//GEN-LAST:event_jButtonRedMouseEntered

    // method: jButtonRedMouseExited
    // purpose: handles de-highlighting of the button
    private void jButtonRedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRedMouseExited
        jButtonRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red button image small transparent.png")));
    }//GEN-LAST:event_jButtonRedMouseExited

    // method: jButtonYellowMouseClicked
    // purpose: click handler for a button
    private void jButtonYellowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonYellowMouseClicked
        boolean pointFlag = false;
        if(buttonWaitFlag){
            if (colorLabel.getForeground() == Color.YELLOW)
                pointFlag = true;
            buttonClickActions(pointFlag);
        }
    }//GEN-LAST:event_jButtonYellowMouseClicked

    // method: jButtonBlueMouseClicked
    // purpose: click handler for a button
    private void jButtonBlueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBlueMouseClicked
        boolean pointFlag = false;
        if(buttonWaitFlag){
            if (colorLabel.getForeground() == Color.BLUE)
                pointFlag = true;
            buttonClickActions(pointFlag);
        }
    }//GEN-LAST:event_jButtonBlueMouseClicked

    // method: jButtonRedMouseClicked
    // purpose: click handler for a button
    private void jButtonRedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRedMouseClicked
        boolean pointFlag = false;
        if(buttonWaitFlag){
            if (colorLabel.getForeground() == Color.RED)
                pointFlag = true;
            buttonClickActions(pointFlag);
        }
    }//GEN-LAST:event_jButtonRedMouseClicked

    // method: jButtonGreenMouseClicked
    // purpose: click handler for a button
    private void jButtonGreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGreenMouseClicked
        boolean pointFlag = false;
        if(buttonWaitFlag){
            if (colorLabel.getForeground() == Color.GREEN)
                pointFlag = true;
            buttonClickActions(pointFlag);
        }
    }//GEN-LAST:event_jButtonGreenMouseClicked

    // method: jButtonPurpleMouseClicked
    // purpose: click handler for a button
    private void jButtonPurpleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPurpleMouseClicked
        boolean pointFlag = false;
        if(buttonWaitFlag){
            if (colorLabel.getForeground() == Color.MAGENTA)
                pointFlag = true;
            buttonClickActions(pointFlag);
        }
    }//GEN-LAST:event_jButtonPurpleMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
    private javax.swing.JPanel colorButtonPanel;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton jButtonBlue;
    private javax.swing.JButton jButtonGreen;
    private javax.swing.JButton jButtonPurple;
    private javax.swing.JButton jButtonRed;
    private javax.swing.JButton jButtonYellow;
    private javax.swing.JLabel jLabelUserScore;
    // End of variables declaration//GEN-END:variables
}

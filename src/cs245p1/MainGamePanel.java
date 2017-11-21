/***************************************************************
* file: MainGamePanel.java
* author: Christopher Kilian, Andrew Tek
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: This class defines the panel from which the game is actually played
* along with the buttons necessary to do so, as well as the display of the word
* and the hangman.
*
****************************************************************/
package cs245p1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

    
public class MainGamePanel extends javax.swing.JPanel {
    
    //Please note: Auto-generated instance variables are automatically placed at the end of the class definition and cannot be moved
    
    private static char [] word;
    private static char [] wordGuessed;
    private static String [] gallowPaths = {"../gallows1.jpg", "../gallows2.jpg",
    "../gallows3.jpg", "../gallows4.jpg", "../gallows5.jpg",
    "../gallows6.jpg", "../gallows7.jpg"};
  
    //method: Constructor
    //purpose: Call appropriate methods to initialize the panel and setup the clock  
    public MainGamePanel() {
        initComponents();
        resetMainGamePanel();
        jLabelUserScore.setText("User Score: " + CS245P1.getGame().getPoints());
        ActionListener updateClock = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
            Date date = new Date();
            clockLabel.setText(dateFormat.format(date).toString());
        }
    };
        Timer timer = new Timer (1000, updateClock);
        timer.setRepeats(true);
        timer.start(); 
        
    }
    
    //method: resetMainGamePanel
    //purpose: Resets the panel for a new game - note that a new game should always be generated before resetting the main game panel
    public void resetMainGamePanel(){
        word = CS245P1.getGame().getWord().toCharArray();
        wordGuessed = new char [word.length];
        StringBuilder dashLines = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            wordGuessed[i] = ' ';
            dashLines.append("_" + " ");
        }
        
        jLabelDashedLines.setText(dashLines.toString());
        jLabelGuessWord.setText("");
        jLabelGallow.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource(gallowPaths[0])));
        enableAllLetters();
        jLabelUserScore.setText("User Score: " + CS245P1.getGame().getPoints());
    }
    
    //method: enableAllLetters
    //purpose: Enables all of the letter buttons for a new game
    private void enableAllLetters(){
        jButtonA.setEnabled(true);
        jButtonB.setEnabled(true);
        jButtonC.setEnabled(true);
        jButtonD.setEnabled(true);
        jButtonE.setEnabled(true);
        jButtonF.setEnabled(true);
        jButtonG.setEnabled(true);
        jButtonH.setEnabled(true);
        jButtonI.setEnabled(true);
        jButtonJ.setEnabled(true);
        jButtonK.setEnabled(true);
        jButtonL.setEnabled(true);
        jButtonM.setEnabled(true);
        jButtonN.setEnabled(true);
        jButtonO.setEnabled(true);
        jButtonP.setEnabled(true);
        jButtonQ.setEnabled(true);
        jButtonR.setEnabled(true);
        jButtonS.setEnabled(true);
        jButtonT.setEnabled(true);
        jButtonU.setEnabled(true);
        jButtonV.setEnabled(true);
        jButtonW.setEnabled(true);
        jButtonX.setEnabled(true);
        jButtonY.setEnabled(true);
        jButtonZ.setEnabled(true);
    }
    
    
    //method: updateGuessedWord
    //purpose: check if the gussed letter is in the word and update the guessed word
    //Will also update the UI    
    public void updateGuessedWord(char letterPushed) {
         List <Integer> index = new ArrayList(CS245P1.getGame().checkLetter(String.valueOf(letterPushed)));

        if (index.isEmpty()) {
            System.out.println("Letter not in word");
            jLabelGallow.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource(gallowPaths[CS245P1.getGame().getIncorrect()]))); 
            jLabelUserScore.setText("User Score: " + CS245P1.getGame().getPoints());
            if(CS245P1.getGame().getIncorrect() == 6){
                transitionToColorGame();
            }
        }
        else {
            System.out.println(index.size());
            for (int i = 0; i < index.size(); i++) {
                wordGuessed[index.get(i)] = letterPushed;
            }
            updateGuessedWord();
            if (CS245P1.getGame().checkForWin(String.copyValueOf(wordGuessed))) {
                System.out.println("You WIN!");
                transitionToColorGame();
            }
        }
        System.out.println(CS245P1.getGame().getPoints());
    }
    
    //method: updateGussedWord
    //purpose: update the UI above the dashed lines
    public void updateGuessedWord() {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < wordGuessed.length; i++) {
            str.append(wordGuessed[i] + " ");
        }
        jLabelGuessWord.setText(str.toString());
    }
    
    //method: transitionToColorGame
    //purpose: Moves to the color game panel when called (to be used once hang-man game is over)
    private void transitionToColorGame(){
        CS245P1.getPrimaryLayout().show(CS245P1.getPrimaryCardHolder(), CS245P1.COLOR_GAME);
    }
    
    //method: getSkipButton
    //purpose: return skip button
    public JButton getSkipButton() {
        return skipButton;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        hangmanPanel = new javax.swing.JPanel();
        jLabelGallow = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        wordPanel = new javax.swing.JPanel();
        jLabelGuessWord = new javax.swing.JLabel();
        jLabelDashedLines = new javax.swing.JLabel();
        letterPanel = new javax.swing.JPanel();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonG = new javax.swing.JButton();
        jButtonH = new javax.swing.JButton();
        jButtonI = new javax.swing.JButton();
        jButtonJ = new javax.swing.JButton();
        jButtonK = new javax.swing.JButton();
        jButtonL = new javax.swing.JButton();
        jButtonM = new javax.swing.JButton();
        jButtonN = new javax.swing.JButton();
        jButtonO = new javax.swing.JButton();
        jButtonP = new javax.swing.JButton();
        jButtonQ = new javax.swing.JButton();
        jButtonR = new javax.swing.JButton();
        jButtonS = new javax.swing.JButton();
        jButtonT = new javax.swing.JButton();
        jButtonU = new javax.swing.JButton();
        jButtonV = new javax.swing.JButton();
        jButtonW = new javax.swing.JButton();
        jButtonX = new javax.swing.JButton();
        jButtonY = new javax.swing.JButton();
        jButtonZ = new javax.swing.JButton();
        jLabelUserScore = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        titleLabel.setFont(new java.awt.Font("Papyrus", 3, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 51, 51));
        titleLabel.setText("Hangman");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        clockLabel.setText("Clock Here");
        clockLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
        clockLabel.setPreferredSize(new java.awt.Dimension(150, 25));

        hangmanPanel.setPreferredSize(new java.awt.Dimension(0, 165));

        jLabelGallow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGallow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gallows1.jpg"))); // NOI18N

        javax.swing.GroupLayout hangmanPanelLayout = new javax.swing.GroupLayout(hangmanPanel);
        hangmanPanel.setLayout(hangmanPanelLayout);
        hangmanPanelLayout.setHorizontalGroup(
            hangmanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hangmanPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelGallow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hangmanPanelLayout.setVerticalGroup(
            hangmanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelGallow)
        );

        skipButton.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        skipButton.setText("Skip");

        jLabelGuessWord.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabelGuessWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGuessWord.setText("a b s t r a c t");
        jLabelGuessWord.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelDashedLines.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabelDashedLines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDashedLines.setText("_ _ _ _ _ _ _ _");
        jLabelDashedLines.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout wordPanelLayout = new javax.swing.GroupLayout(wordPanel);
        wordPanel.setLayout(wordPanelLayout);
        wordPanelLayout.setHorizontalGroup(
            wordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wordPanelLayout.createSequentialGroup()
                .addGroup(wordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGuessWord, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(jLabelDashedLines, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        wordPanelLayout.setVerticalGroup(
            wordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wordPanelLayout.createSequentialGroup()
                .addComponent(jLabelGuessWord, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDashedLines, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        jLabelGuessWord.getAccessibleContext().setAccessibleName("a b s t r a c t ");
        jLabelDashedLines.getAccessibleContext().setAccessibleName("_ _ _ _ _ _ _ _ ");

        letterPanel.setPreferredSize(new java.awt.Dimension(590, 100));

        jButtonA.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonA.setText("A");
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonPush(evt);
            }
        });
        letterPanel.add(jButtonA);

        jButtonB.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonB.setText("B");
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonB);

        jButtonC.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonC.setText("C");
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonC);

        jButtonD.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonD.setText("D");
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonD);

        jButtonE.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonE.setText("E");
        jButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonE);

        jButtonF.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonF.setText("F");
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonF);

        jButtonG.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonG.setText("G");
        jButtonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonG);

        jButtonH.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonH.setText("H");
        jButtonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonH);

        jButtonI.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonI.setText("I");
        jButtonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonI);

        jButtonJ.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonJ.setText("J");
        jButtonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonJ);

        jButtonK.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonK.setText("K");
        jButtonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonK);

        jButtonL.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonL.setText("L");
        jButtonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonL);

        jButtonM.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonM.setText("M");
        jButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonM);

        jButtonN.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonN.setText("N");
        jButtonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonN);

        jButtonO.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonO.setText("O");
        jButtonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonO);

        jButtonP.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonP.setText("P");
        jButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonP);

        jButtonQ.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonQ.setText("Q");
        jButtonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonQ);

        jButtonR.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonR.setText("R");
        jButtonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonR);

        jButtonS.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonS.setText("S");
        jButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonS);

        jButtonT.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonT.setText("T");
        jButtonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonT);

        jButtonU.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonU.setText("U");
        jButtonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonU);

        jButtonV.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonV.setText("V");
        jButtonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonV);

        jButtonW.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonW.setText("W");
        jButtonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonW);

        jButtonX.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonX.setText("X");
        jButtonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonX);

        jButtonY.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonY.setText("Y");
        jButtonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonYActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonY);

        jButtonZ.setFont(new java.awt.Font("Century", 1, 10)); // NOI18N
        jButtonZ.setText("Z");
        jButtonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZActionPerformed(evt);
            }
        });
        letterPanel.add(jButtonZ);

        jLabelUserScore.setText("User Score:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hangmanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelUserScore, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(skipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(letterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skipButton)
                    .addComponent(jLabelUserScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hangmanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(letterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void aButtonPush(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonPush
        updateGuessedWord('a');
        jButtonA.setEnabled(false);
       // System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_aButtonPush
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        updateGuessedWord('b');
        jButtonB.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonBActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        updateGuessedWord('c');
        jButtonC.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonCActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        updateGuessedWord('d');
        jButtonD.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonDActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        updateGuessedWord('e');
        jButtonE.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());       
    }//GEN-LAST:event_jButtonEActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
        updateGuessedWord('f');
        jButtonF.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonFActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGActionPerformed
        updateGuessedWord('g');
        jButtonG.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonGActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHActionPerformed
        updateGuessedWord('h');
        jButtonH.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonHActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIActionPerformed
        updateGuessedWord('i');
        jButtonI.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonIActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJActionPerformed
        updateGuessedWord('j');
        jButtonJ.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonJActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKActionPerformed
        updateGuessedWord('k');
        jButtonK.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonKActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLActionPerformed
        updateGuessedWord('l');
        jButtonL.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonLActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMActionPerformed
        updateGuessedWord('m');
        jButtonM.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonMActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNActionPerformed
        updateGuessedWord('n');
        jButtonN.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonNActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOActionPerformed
        updateGuessedWord('o');
        jButtonO.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonOActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPActionPerformed
        updateGuessedWord('p');
        jButtonP.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonPActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQActionPerformed
        updateGuessedWord('q');
        jButtonQ.setEnabled(false);
        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonQActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRActionPerformed
        updateGuessedWord('r');
        jButtonR.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonRActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSActionPerformed
        updateGuessedWord('s');
        jButtonS.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonSActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTActionPerformed
        updateGuessedWord('t');
        jButtonT.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonTActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUActionPerformed
        updateGuessedWord('u');
        jButtonU.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonUActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVActionPerformed
        updateGuessedWord('v');
        jButtonV.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonVActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWActionPerformed
        updateGuessedWord('w');
        jButtonW.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonWActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXActionPerformed
        updateGuessedWord('x');
        jButtonX.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonXActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYActionPerformed
        updateGuessedWord('y');
        jButtonY.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonYActionPerformed
    //method: ButtonPush
    //purpose: call update guessedWord and disable the button
    private void jButtonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZActionPerformed
        updateGuessedWord('z');
        jButtonZ.setEnabled(false);
//        System.out.println(CS245P1.getGame().getPoints());
    }//GEN-LAST:event_jButtonZActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
    private javax.swing.JPanel hangmanPanel;
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonG;
    private javax.swing.JButton jButtonH;
    private javax.swing.JButton jButtonI;
    private javax.swing.JButton jButtonJ;
    private javax.swing.JButton jButtonK;
    private javax.swing.JButton jButtonL;
    private javax.swing.JButton jButtonM;
    private javax.swing.JButton jButtonN;
    private javax.swing.JButton jButtonO;
    private javax.swing.JButton jButtonP;
    private javax.swing.JButton jButtonQ;
    private javax.swing.JButton jButtonR;
    private javax.swing.JButton jButtonS;
    private javax.swing.JButton jButtonT;
    private javax.swing.JButton jButtonU;
    private javax.swing.JButton jButtonV;
    private javax.swing.JButton jButtonW;
    private javax.swing.JButton jButtonX;
    private javax.swing.JButton jButtonY;
    private javax.swing.JButton jButtonZ;
    private javax.swing.JLabel jLabelDashedLines;
    private javax.swing.JLabel jLabelGallow;
    private javax.swing.JLabel jLabelGuessWord;
    private javax.swing.JLabel jLabelUserScore;
    private javax.swing.JPanel letterPanel;
    private javax.swing.JButton skipButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel wordPanel;
    // End of variables declaration//GEN-END:variables
}

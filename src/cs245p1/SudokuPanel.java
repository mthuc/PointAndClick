
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
import javax.swing.JTextField;

public class SudokuPanel extends javax.swing.JPanel { 
    /**
     * jTextField for all inputs for board game
     * jTextField##.setToolTipText("Enter a number from 1 to 9");
     */

    private JTextField[] enteredWord = new JTextField[81];
    private int[] intEntered = new int[81];
    private boolean[] calculated = new boolean[81];
    private Sudoku sudoku = new Sudoku();
    
    public SudokuPanel() {
        initComponents();
        // Initialize Arrays
        initializeArrays();
        // Initialize game board
        initializeGameBoard();
        
        // SUBMIT NUMBERS
        // When submit is pressed, all numbers inputted will be recorded and then calculated to see if they are correct
        submitNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // WORKS FOR FIRST ROW
                // Non-user numbers
//                if (i == 0 || i == 3 || i == 5 || i == 8 || i == 15 || i == 19 
//                        || i == 24 || i == 25 || i == 27 || i == 29 || i == 31 
//                        || i == 33 || i == 34 || i == 40 || i == 46 || i == 47 
//                        || i == 49 || i == 51 || i == 53 || i == 55 || i == 56 
//                        || i == 61 || i == 65 || i == 72 || i == 75 || i == 77 
//                        || i == 80)
//                                 continue;
                enteredWord[1].setText(jTextField1.getText());
                enteredWord[2].setText(jTextField2.getText());
                enteredWord[4].setText(jTextField3.getText());
                enteredWord[6].setText(jTextField4.getText());
                enteredWord[7].setText(jTextField5.getText());
                intEntered[1] = Integer.parseInt(enteredWord[1].getText());
                intEntered[2] = Integer.parseInt(enteredWord[2].getText());
                intEntered[4] = Integer.parseInt(enteredWord[4].getText());
                intEntered[6] = Integer.parseInt(enteredWord[6].getText());
                intEntered[7] = Integer.parseInt(enteredWord[7].getText());
                // FIRST ROW TEST
                for (int i = 0; i < 9; i++) {
                    if (intEntered[i] == sudoku.getSolution()[i]) {
                    // 3 == 3
                    System.out.println("Good | Entered: " + intEntered[i] + " Sol: " + sudoku.getSolution()[i]);
                    }
                    else {
                    System.out.println("Bad | Entered: " + intEntered[i] + " Sol: " + sudoku.getSolution()[i]);
                    }
                }
            }
        });

        ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
            Date date = new Date();
            clockLabel.setText(dateFormat.format(date).toString());
            
            // Set points to points + 540 (Sudoku)
            // ERROR HERE int points = CS245P1.getSudokuGame().getPoints() + CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            int points = CS245P1.getColorGame().getPoints() + CS245P1.getGame().getPoints();
            jLabelUserScore.setText("User Score: " + points);
        }
        };
        
        Timer timer = new Timer (1000, updateClock);
        timer.setRepeats(true);
        timer.start();
    }
    
    // method: initializeArrays
    // purpose: initialize JTextField and integer arrays to calculate user inputs for later
    public void initializeArrays() {
        for (int i = 0; i < enteredWord.length; i++) {
            enteredWord[i] = new JTextField();
            calculated[i] = false;
        }
    }
    
    // method: initliaizeGameBoard
    // purpose: adds the default numbers from pdf to game board
    private void initializeGameBoard() {
        enteredWord[0].setText("8");
        enteredWord[3].setText("4");
        enteredWord[5].setText("6");
        enteredWord[8].setText("7");
        enteredWord[15].setText("4");
        enteredWord[19].setText("1");
        enteredWord[24].setText("6");
        enteredWord[25].setText("5");
        enteredWord[27].setText("5");
        enteredWord[29].setText("9");
        enteredWord[31].setText("3");
        enteredWord[33].setText("7");
        enteredWord[34].setText("8");
        enteredWord[40].setText("7");
        enteredWord[46].setText("4");
        enteredWord[47].setText("8");
        enteredWord[49].setText("2");
        enteredWord[51].setText("1");
        enteredWord[53].setText("3");
        enteredWord[55].setText("5");
        enteredWord[56].setText("2");
        enteredWord[61].setText("9");
        enteredWord[65].setText("1");
        enteredWord[72].setText("3");
        enteredWord[75].setText("9");
        enteredWord[77].setText("2");
        enteredWord[80].setText("5");
        for (int j = 0; j < intEntered.length; j++) {
            if (enteredWord[j].getText() != null && !enteredWord[j].getText().equals("")) {
                intEntered[j] = Integer.parseInt(enteredWord[j].getText());
            }
        }
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
        jLabelUserScore = new javax.swing.JLabel();
        sudokuPanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        submitNumbers = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        mainBoard = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        clockLabel.setText("Clock Here");
        clockLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), null));
        clockLabel.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabelUserScore.setText("User Score:");

        sudokuPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        submitNumbers.setText("Submit");

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setText("6");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setText("8");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setText("4");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setText("4");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setText("7");
        jLabel5.setOpaque(true);

        mainBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SudokuBoard.png"))); // NOI18N
        mainBoard.setAlignmentX(0.5F);

        javax.swing.GroupLayout sudokuPanelLayout = new javax.swing.GroupLayout(sudokuPanel);
        sudokuPanel.setLayout(sudokuPanelLayout);
        sudokuPanelLayout.setHorizontalGroup(
            sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sudokuPanelLayout.createSequentialGroup()
                .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sudokuPanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(sudokuPanelLayout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sudokuPanelLayout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jTextField10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sudokuPanelLayout.createSequentialGroup()
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sudokuPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(sudokuPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(submitNumbers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainBoard)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        sudokuPanelLayout.setVerticalGroup(
            sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sudokuPanelLayout.createSequentialGroup()
                .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(sudokuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sudokuPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitNumbers)
                        .addGap(86, 86, 86))
                    .addGroup(sudokuPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainBoard)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clockLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sudokuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUserScore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sudokuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelUserScore;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel mainBoard;
    private javax.swing.JButton submitNumbers;
    private javax.swing.JPanel sudokuPanel;
    // End of variables declaration//GEN-END:variables
}
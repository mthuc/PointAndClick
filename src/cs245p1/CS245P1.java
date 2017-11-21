/***************************************************************
* file: CS245P1.java
* author: Christopher Kilian, Nicholas Pham, Andrew Tek
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Point and Click Game – v.1.1
* date last modified: 10/18/2017
*
* purpose: Sets up the card holder, panels, and jFrame, along with maintaining various constants
* needed throughout the game program.
* Also maintains a single static game state, so that game values (such as score)
* are easily accessible from various panels.
*
****************************************************************/
package cs245p1;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;


public class CS245P1 {
    
    //String constants here are protected so they're easily accessible from the various panel classes
    //Other private values are (when needed by other panels) accessible via getter methods
    protected static final String MAIN_MENU = "Menu";
    protected static final String CREDITS_SCREEN = "Credits";
    protected static final String START_SCREEN = "Start";
    protected static final String GAME_OVER = "Game Over";
    protected static final String HIGH_SCORES = "High Scores";
    protected static final String GAME = "Game";
    protected static final String COLOR_GAME = "Color Game";
    protected static final String SUDOKU = "Sudoku";
    private static final CardLayout CARDLAYOUT = new CardLayout();  
    private static final JPanel CARDHOLDER = new JPanel(CARDLAYOUT);
    private static HangManGame currentGame;
    private static ColorGame colorGame;
    private static Sudoku sudoku;
    private static Map allPanels; //allows access to panel methods anywhere in program
    
    //method: CS245P1 (Constructor)
    //purpose: Initializes all the necessary components of the game, including the individual panels
    //and the game object itself, as well as setting up actionlisteners for the buttons which transition
    //between panels (utilizing the CardLayout layout)
    public CS245P1(){
        initLookAndFeel();
        JFrame mainFrame = new JFrame();
        currentGame = new HangManGame();
        colorGame = new ColorGame();
        allPanels = new HashMap<String,Component>();
        CreditsPanel creditPanel = new CreditsPanel();
        allPanels.put(CREDITS_SCREEN, creditPanel);
        GameOverPanel gameOverPanel = new GameOverPanel();
        allPanels.put(GAME_OVER, gameOverPanel);
        HighScoresPanel highScoresPanel = new HighScoresPanel();
        allPanels.put(HIGH_SCORES, highScoresPanel);
        MainGamePanel mainGamePanel = new MainGamePanel();
        allPanels.put(GAME, mainGamePanel);
        MenuPanel menuPanel = new MenuPanel();
        allPanels.put(MAIN_MENU, menuPanel);
        StartPanel startPanel = new StartPanel();
        allPanels.put(START_SCREEN, startPanel);
        ColorGamePanel colorPanel = new ColorGamePanel();
        allPanels.put(COLOR_GAME, colorPanel);
        SudokuPanel sudokuPanel = new SudokuPanel();
        allPanels.put(SUDOKU, sudokuPanel);
        
        CARDHOLDER.add(creditPanel, CREDITS_SCREEN);
        CARDHOLDER.add(gameOverPanel, GAME_OVER);
        CARDHOLDER.add(highScoresPanel, HIGH_SCORES);
        CARDHOLDER.add(mainGamePanel, GAME);
        CARDHOLDER.add(startPanel, START_SCREEN);
        CARDHOLDER.add(menuPanel, MAIN_MENU);
        CARDHOLDER.add(colorPanel, COLOR_GAME);
        CARDHOLDER.add(sudokuPanel, SUDOKU);
        
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(new java.awt.Dimension(600, 400));
        mainFrame.add(CARDHOLDER);
        CARDLAYOUT.show(CARDHOLDER, START_SCREEN);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        
        ActionListener showMenuScreen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CARDLAYOUT.show(CARDHOLDER, MAIN_MENU);
            }
        };
        Timer timer = new Timer (3000, showMenuScreen);
        timer.setRepeats(false);
        timer.start(); 
                
        ActionListener buttonHandler = new ActionListener() { //all buttons which transition between panels are handled here
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuPanel.getPlayButton()) {
                    currentGame = new HangManGame();
                    colorGame.resetGame();
                    mainGamePanel.resetMainGamePanel();
                    CARDLAYOUT.show(CARDHOLDER, GAME);
                }else if(e.getSource() == menuPanel.getHighscoreButton()){
                    CARDLAYOUT.show(CARDHOLDER, HIGH_SCORES);
                }else if(e.getSource() == menuPanel.getCreditsButton()){
                    CARDLAYOUT.show(CARDHOLDER, CREDITS_SCREEN);
                }else if(e.getSource() == mainGamePanel.getSkipButton()){
                    currentGame.skipGame();
                    CARDLAYOUT.show(CARDHOLDER, COLOR_GAME);
                }else if((e.getSource() == gameOverPanel.getEndButton()) ||
                        (e.getSource() == creditPanel.getBackButton()) ||
                        (e.getSource() == highScoresPanel.getBackButton())){
                    CARDLAYOUT.show(CARDHOLDER, MAIN_MENU);
                }
                // add sudoku
            }
        };
        menuPanel.getCreditsButton().addActionListener(buttonHandler);
        menuPanel.getPlayButton().addActionListener(buttonHandler);
        menuPanel.getHighscoreButton().addActionListener(buttonHandler);
        mainGamePanel.getSkipButton().addActionListener(buttonHandler);
        gameOverPanel.getEndButton().addActionListener(buttonHandler);
        creditPanel.getBackButton().addActionListener(buttonHandler);
        highScoresPanel.getBackButton().addActionListener(buttonHandler);
    }
    
    //method: initLookAndFeel
    //purpose: Sets up the "look and feel" of the game
    private static void initLookAndFeel(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());       
        } 
        catch (UnsupportedLookAndFeelException e) {
            System.err.println("There was an UnsupportedLookAndFeelException with the following L&F: " + UIManager.getCrossPlatformLookAndFeelClassName());
            System.err.println("Using default look and feel.");
        }
        catch (ClassNotFoundException e) {
            System.err.println("There was a ClassNotFoundException with the following L&F: " + UIManager.getCrossPlatformLookAndFeelClassName());
            System.err.println("Using default look and feel.");
        }
        catch (InstantiationException e) {
            System.err.println("There was an InstantiationException with the following L&F: " + UIManager.getCrossPlatformLookAndFeelClassName());
            System.err.println("Using default look and feel.");
        }
        catch (IllegalAccessException e) {
            System.err.println("There was an IllegalAccessException with the following L&F: " + UIManager.getCrossPlatformLookAndFeelClassName());
            System.err.println("Using default look and feel.");
        }
    }
    
    //method: getGame
    //purpose: Getter for the game object
    public static HangManGame getGame(){
        return currentGame;
    }
    
    //method: getPrimaryLayout
    //purpose: Getter for the layout object (allows changing panels from within other panels)
    public static CardLayout getPrimaryLayout(){
        return CARDLAYOUT;
    }
    
    //method: getPrimaryCardHolder
    //purpose: Getter for the panel object which manages the layour (allows changing panels from within other panels)
    public static JPanel getPrimaryCardHolder(){
        return CARDHOLDER;
    }
    
    //method: getPanelMap
    //purpose: Getter for the panel map, allowing access to public panel methods from anywhere in program
    public static Map getPanelMap(){
        return allPanels;
    }
    
    //method: getColorGame
    //purpose: Getter for the color game object
    public static ColorGame getColorGame() {
        return colorGame;
    }
    
    public static Sudoku getSudokuGame() {
        return sudoku;
    }
    
    //method: main
    //purpose: Runs the game
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CS245P1 game = new CS245P1();
            }
        });
    }
    
}


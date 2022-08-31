
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class MemoryGame {
    static JFrame mainframe = new JFrame("Memory Game");//create a new JFrame

    static JPanel panel = new JPanel();//Creates a panel to show main screen
    static JPanel game = new JPanel();// the panel for the gui stuff for the board
    static JPanel ipanel = new JPanel();//creates a panel to show instructions

    static JLabel welcome = new JLabel("Welcome to The Memory Game!!");//label that writes "Welcome to The Memory Game!!"
    static JLabel instructM = new JLabel("<html> <br><br>1.When the game begins, the screen will be filled with pairs of buttons.<br><br> 2.Memorize their placement.<br><br>3.Once you press any button, they will all clear. <br><br>4.Your goal is to click the matching buttons in a row.<br><br>5.When you finish that, you win.<br><br>6.Every incorrect click gives you a point (those are bad).<br><br><br> GOOD LUCK!");

    static JButton mainmenu = new JButton("Main Menu");//creates a button that takes to main menu
    static JButton instruction = new JButton("Instructions");//creates that lead to instructions label
    static JButton Play = new JButton("Play");//button that lead to play screen
    static JButton Exit = new JButton("Exit");//button to exit the game
   
    String startRestart = "Start";
     JButton jbuttonRestart = new JButton(startRestart);//button to restart the game
    static JButton jbuttonMainMenu = new JButton("Main Menu");//button to main menu game
    int ClickCounts=0;
    JLabel  jLableClickCounts = new JLabel("ClickCounts:"+ ClickCounts);//button to exit the game
    
    
    static JButton[] JbuttonTiles = new JButton[12];//
    public static String[] containerStringBoard = new String[12];
    int[] boardQ=new int[20];
    static Random randomGenerator = new Random();
    static JButton random = new JButton("");
 int numOfTilesTurned = 0;
 
 String tempString;
 int tempInt;

    public MemoryGame() 
    {
                    mainframe.setVisible(true);//make it visible
                    mainframe.setSize(600, 450);//set it's size
                    mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit application on pressing the red button
                    mainframe.add(panel);

                    panel.setLayout(null);


                    welcome.setBounds(120, 80, 500, 25);
                    welcome.setFont(new Font("Georgia", Font.BOLD, 20));
                    panel.add(welcome);


                    instruction.setBounds(120, 150, 150, 50);
                    panel.add(instruction);


                    Play.setBounds(300, 150, 150, 50);
                    panel.add(Play);


                    Exit.setBounds(230, 300, 100, 40);
                    panel.add(Exit);
                        
                    
                    Exit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            System.exit(0);
                        }
                    });
                    instruction.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            instructionActionPerformed(evt);
                            panel.setVisible(false);
                        }
                    });

                     Play.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            instructionActionPerformed(evt);
                            panel.setVisible(false);
                            ipanel.setVisible(false);
                            game.setVisible(true);
                            game.setBackground(Color.black);
                            mainframe.add(game);
                        GameSetup();
                        
              } });
                        mainmenu.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) 
                                    {                           
                                    instructionActionPerformed(evt);
                                    ipanel.setVisible(false);
                                    
                                    panel.setVisible(true);
                                                       
                                }
                            });

   
                        
        
  
    }
    
    public void GameSetup() //will add Jbuttons to the panel , giving random text to buttons and saving them in string array 
    {
            for (int i = 0; i < 10; i++) {
                
            }
                game.setLayout(new GridLayout(5, 3));

                int i;

                for (i = 0; i < 12; i++)
                {
                    JbuttonTiles[i] = new JButton();
                     JbuttonTiles[i].addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(ActionEvent click)
                             {   JButton sourceOfClick = (JButton)click.getSource();
                             int a=indexOf(JbuttonTiles, sourceOfClick);
                                switchSpot(a);


                             } });
                     
                    game.add(JbuttonTiles[i]);
                }
game.add(jbuttonRestart);
game.add(jLableClickCounts);
game.add(jbuttonMainMenu);
jbuttonRestart.setBackground(Color.BLACK);
jbuttonRestart.setForeground(Color.green);
jbuttonMainMenu.setBackground(Color.BLACK);
jbuttonMainMenu.setForeground(Color.green);
jLableClickCounts.setForeground(Color.green);

                String[] words = {"Square", "Circle", "Rectangle", "Heart", "Diamond", "Clover"};

                for (int j = 0; j < 6; j++) 
                {
                            for (int z = 0; z < 2; z++) 
                            {while (true) 
                                        {
                                            int y = randomGenerator.nextInt(12);
                                                    if (containerStringBoard[y] == null) 
                                                    {
                                                        JbuttonTiles[y].setText(words[j]);
                                                        containerStringBoard[y] = words[j];
                                                        break;
                                                    }
                                          }
                            }

                }
                for (int M = 0; M <12 ; M++)
    {     JbuttonTiles[M].setText(containerStringBoard[M]);   }


                jbuttonRestart.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(ActionEvent click)
                             {   
                                    setAllTilesEmpty();
                                    jbuttonRestart.setText("All the best!!");
                             } });
                jbuttonMainMenu.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(ActionEvent click)
                             {   
                                    
                                   game.setVisible(false);
                                    panel.setVisible(true);
                             } });
      
               
   }





    private static void instructionActionPerformed(ActionEvent evt) 
    {

        ipanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        instructM.setBounds(80, 50, 450, 200);
        ipanel.setLayout(null);

        mainmenu.setBounds(230, 300, 100, 40);
        ipanel.add(mainmenu);
        ipanel.add(instructM);
        mainframe.add(ipanel);
    }
    
    public void setAllTilesEmpty()
    {
        
//              try
//                    {Thread.sleep(1000);}
//                    catch(InterruptedException ex)
//                    {  Thread.currentThread().interrupt();}

                 for (int i = 0; i < 12; i++) 
                   {JbuttonTiles[i].setText("");}
}
    
    
    public void switchSpot(int i)
     {//this will switch the current spot to either blank or what it should have
	   if (numOfTilesTurned<2) 
           {
                                if(containerStringBoard[i]!="done")//when a match is correctly chosen, it will no longer switch when pressed
                                {
                                            if(JbuttonTiles[i].getText()=="")
                                           {JbuttonTiles[i].setText(containerStringBoard[i]);
                                             numOfTilesTurned++;
                                             
                                          
                                                   if (numOfTilesTurned==2&& tempString==containerStringBoard[i]) 
                                                    {JbuttonTiles[i].setText(containerStringBoard[i]);
                                                        ClickCounts++;
                                                        jLableClickCounts.setText("ClickCounts:"+ ClickCounts);
                                                    try
                                                                    {Thread.sleep(500);}
                                                                    catch(InterruptedException ex)
                                                                    {  Thread.currentThread().interrupt();}
                                                            containerStringBoard[i]="Done!!!";JbuttonTiles[i].setText("Done!!!");
                                                            containerStringBoard[tempInt]="Done!!!";JbuttonTiles[tempInt].setText("Done!!!");
                                                               tempString="";
                                                        tempInt=-1;
                                                        numOfTilesTurned=0;
                                                        
                                                        
                                                    }
                                                    else if(numOfTilesTurned!=2){tempString=containerStringBoard[i];
                                                        tempInt=i;
                                                    ClickCounts++;
                                                    jLableClickCounts.setText("ClickCounts:"+ ClickCounts);
                                                    }
                                           
                                           } 
                                            
                                            
                                            else { JbuttonTiles[i].setText(""); 
                                            numOfTilesTurned--;
                                            ClickCounts++;
                                            jLableClickCounts.setText("ClickCounts:"+ ClickCounts);
                                            }
	               }
           }else if(JbuttonTiles[i].getText()!=""&&JbuttonTiles[i].getText()!="Done!!!")
           { JbuttonTiles[i].setText("");
                                           numOfTilesTurned--;
                                ClickCounts++;
           jLableClickCounts.setText("ClickCounts:"+ ClickCounts);}
     }


   public static <T> int indexOf(T[] arr, T val) {
    return Arrays.asList(arr).indexOf(val);
}
        public static void main  (String args[])
        {
            new MemoryGame  ();
        }


    
}
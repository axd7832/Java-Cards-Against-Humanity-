import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
/**
 * CardsClient is a class that will connect to a Server and play Cards Against Humanity
 */
public class CardsClient extends JFrame implements Serializable {

   private JPanel jpCenter;
   private JPanel jpNorth;
   private JPanel jpChat;
   private JPanel jpRightChat;
   private JPanel jpScore;

   private JButton cardOne;
   private JButton cardTwo;
   private JButton cardThree;
   private JButton cardFour;
   private JButton cardFive;
   private JButton cardSix;
   private JButton cardSeven;
   private JButton cardEight;
   private JButton cBlack;
   private JButton jbSend;
   private JButton jbConnect;
   
   private JTextField playerOne;
   private JTextField playerTwo;
   private JTextField playerThree;
   private JTextField playerFour;
   
   private JTextArea jtaServer;
   private JTextArea jtaClient;
   
   private JMenuBar jmb;
   private JMenu jmFile;
   private JMenuItem jmiNew;
   private JMenuItem jmiExit;

   private Socket cs = null;
   private OutputStream out = null;
   private ObjectOutputStream oos = null;
   private InputStream in = null;
   private ObjectInputStream ois = null;
   
   private String IP = "localhost";
   private final int PORT = 16789;
   
   private String clientName;
   private int winningPlayer;
   private int myNumber;
   private int turnCount;
   private ArrayList <WhiteCard> sentCards = new ArrayList <WhiteCard>();
  
   public CardsClient()
   {
      setTitle("Cards Against Humanity");
      setLayout(new BorderLayout());
      
      Dimension cardDimen = new Dimension(165, 180);
      Font cardFont = new Font("Arial", Font.BOLD, 14);
      
      //JmenuBar
      jmb = new JMenuBar();
      setJMenuBar(jmb);
      jmFile = new JMenu("File");
      jmb.add(jmFile);
      jmiNew = new JMenuItem("New Game");
      jmFile.add(jmiNew);
      jmiExit = new JMenuItem("Exit");
      jmFile.add(jmiExit);
         
      //white card 
      cardOne = new JButton();
      cardOne.setFont(cardFont);
      cardOne.setPreferredSize(cardDimen);
      cardOne.setBackground(Color.WHITE);
      cardOne.setOpaque(true);
      cardOne.setBorderPainted(false);
      cardOne.setEnabled(false);
   
      //white card 2
      cardTwo = new JButton();
      cardTwo.setFont(cardFont);
      cardTwo.setPreferredSize(cardDimen);
      cardTwo.setBackground(Color.WHITE);
      cardTwo.setOpaque(true);
      cardTwo.setBorderPainted(false);
      cardTwo.setEnabled(false);
   
      //white card 3
      cardThree = new JButton();
      cardThree.setFont(cardFont);
      cardThree.setPreferredSize(cardDimen);
      cardThree.setBackground(Color.WHITE);
      cardThree.setOpaque(true);
      cardThree.setBorderPainted(false);
      cardThree.setEnabled(false);
   
      //white card 4
      cardFour = new JButton();
      cardFour.setFont(cardFont);
      cardFour.setPreferredSize(cardDimen);
      cardFour.setBorderPainted(false);
      cardFour.setBackground(Color.WHITE);
      cardFour.setOpaque(true);
      cardFour.setEnabled(false);
   
      //white card 5
      cardFive = new JButton();
      cardFive.setFont(cardFont);
      cardFive.setPreferredSize(cardDimen);
      cardFive.setBorderPainted(false);
      cardFive.setBackground(Color.WHITE);
      cardFive.setOpaque(true);
      cardFive.setEnabled(false);
      
      //black card
      cBlack = new JButton("Black Card");
      cBlack.setFont(cardFont);
      cBlack.setBackground(Color.BLACK);
      cBlack.setForeground(Color.WHITE);
      cBlack.setPreferredSize(cardDimen);
      cBlack.setOpaque(true);
      cBlack.setBorderPainted(false);
      cBlack.setEnabled(true);
      
      //other players cards (for cardmaster)
      cardSix = new JButton("");
      cardSix.setFont(cardFont);
      cardSix.setPreferredSize(cardDimen);
      cardSix.setEnabled(false);
      
      cardSeven = new JButton("");
      cardSeven.setFont(cardFont);
      cardSeven.setPreferredSize(cardDimen);
      cardSeven.setEnabled(false);
      
      cardEight = new JButton("");
      cardEight.setFont(cardFont);
      cardEight.setPreferredSize(cardDimen);
      cardEight.setEnabled(false);
      
      
      //score keeper
      /*
      *Save the players usernames from chat and put on scoreboard
      *Set the scores to zero in un-editable texfields
      */
      jpScore = new JPanel(new GridLayout(0,2));
      playerOne = new JTextField(3);
      playerOne.setText("0");
      playerOne.setEnabled(false);
      playerTwo = new JTextField(3);
      playerTwo.setText("0");
      playerTwo.setEnabled(false);
      playerThree = new JTextField(3);
      playerThree.setText("0");
      playerThree.setEnabled(false);
      playerFour = new JTextField(3);
      playerFour.setText("0");
      playerFour.setEnabled(false);
      
      jpScore.add(new JLabel("Player 1:", JLabel.RIGHT));
      jpScore.add(playerOne);
      jpScore.add(new JLabel("Player 2:", JLabel.RIGHT));
      jpScore.add(playerTwo);
      jpScore.add(new JLabel("Player 3:", JLabel.RIGHT));
      jpScore.add(playerThree);
      jpScore.add(new JLabel("Player 4:", JLabel.RIGHT));
      jpScore.add(playerFour);
      
      
      jpNorth = new JPanel(new FlowLayout());
      jpCenter = new JPanel (new FlowLayout());
      jpChat = new JPanel(new BorderLayout());
      
      add(jpNorth, BorderLayout.NORTH);
      add(jpCenter,BorderLayout.CENTER);
      add(jpChat,BorderLayout.SOUTH);

      jpNorth.add(cBlack);
      jpNorth.add(cardSix);
      jpNorth.add(cardSeven);
      jpNorth.add(cardEight);
      jpNorth.add(jpScore);
   
      jpCenter.add(cardOne);
      jpCenter.add(cardTwo);
      jpCenter.add(cardThree);
      jpCenter.add(cardFour);
      jpCenter.add(cardFive); 
       
   
      //Chat Client
      
      //adds text area
      jtaServer = new JTextArea(15,40);
      jtaServer.setEditable(false);
      //adds line wrap
      jtaServer.setLineWrap(true);
      //adds scrollable
      JScrollPane scroll = new JScrollPane (jtaServer);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      jpChat.add(scroll, BorderLayout.CENTER);
      
      jpRightChat = new JPanel(new BorderLayout());
      jpChat.add(jpRightChat, BorderLayout.EAST);
      //client text area to send to server
      jtaClient = new JTextArea(6,20);
      //line wrap
      jtaClient.setLineWrap(true);
      //Allows for Scrolling
      JScrollPane scroll2 = new JScrollPane (jtaClient);
      scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      jbSend = new JButton("Send");
      jbConnect = new JButton("Connect");
      
      
      //jpBottom.add(scroll2);
      jpRightChat.add(scroll2 , BorderLayout.CENTER);
      
      //adds button to panel
      jpRightChat.add(jbConnect, BorderLayout.NORTH);
      jpRightChat.add(jbSend, BorderLayout.SOUTH);
      
      jbConnect.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent ae) {
               
                  //IP = JOptionPane.showInputDialog(jbConnect, "Enter the server's IP address:");
                  try{
                     //Socket
                     cs = new Socket(IP, PORT);
                     
                     //Output Stream
                     out = cs.getOutputStream();
                     oos = new ObjectOutputStream(out);
                     
                     //Input Stream
                     in = cs.getInputStream();
                     ois = new ObjectInputStream(in);
                     
                     //asks the user for a user name and sends to server
                     if(clientName == null){
                        clientName = JOptionPane.showInputDialog(jbSend,"Please enter a username");
                        oos.writeObject(clientName); 
                        oos.flush();             
                     }
                     
                     
                     //BlackCard bc = new BlackCard("black card");
                     //oos.writeObject(bc);

                     jbConnect.setEnabled(false);
                     
                     //Thread
                     ClientThread ct = new ClientThread(cs);
                     ct.start();
                     
                     //handles chat strings from client to server
                     jbSend.addActionListener(
                           new ActionListener(){
                              public void actionPerformed(ActionEvent ae) {
                                 try{
                                    //Writes message from server and appends
                                    if(jtaClient.getText().length() > 0){
                                       String clientMsg = jtaClient.getText();
                                       oos.writeObject(clientMsg);
                                       oos.flush();
                                       jtaClient.setText("");
                                    }   
                                 }
                                 catch (IOException oie) {
                                    System.out.println("IO Exception");
                                 }                                 
                              }	
                           });   
                  } 
                  catch(ConnectException ce ) { 
                     System.out.println("Server is Not Online"); 
                  }
                  catch(UnknownHostException uhe) {
                     System.out.println("no host");
                     uhe.printStackTrace();
                  }
                  catch(IOException ioe)
                  {
                     System.out.println("IO error");
                     ioe.printStackTrace();
                  }
                  catch( ArrayIndexOutOfBoundsException aioobe ) {
                     System.out.println("Array Index Out of Bounds");
                  }
               }});
      setSize(900,700);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   
   }//end constructor
   
   /**
    * main method that calls the ChatClient constructor
    * @param args Main Arguments
    */
   public static void main(String [] args) {
      
      new CardsClient();
      
   }
   /**
    * ClientThread is the thread that keeps the GUI updated
    */
   class ClientThread extends Thread implements ActionListener {
      
      //attributes
      Socket cs;
      String clientMessage;
      int playerNum;
      
      
      //constructor
      /**
       * ClientThread Constructor that takes a socket to bind on
       * @param cs Socket binding socket
       */     
      public ClientThread(Socket cs){
         this.cs = cs;
         
         //set the action listeners for the white card buttons
         cardOne.addActionListener(this);
         cardTwo.addActionListener(this);
         cardThree.addActionListener(this);
         cardFour.addActionListener(this);
         cardFive.addActionListener(this);
         cardSix.addActionListener(this);
         cardSeven.addActionListener(this);
         cardEight.addActionListener(this);         
      
      }
      /**
       * Run method that starts the thread for the client
       */  
      public void run() {
         try{
            //Always updates 
            while(true){
               Object readIn = ois.readObject();
               
               //if it's a string, it is chat. append to chat area
               if (readIn instanceof String) {
                  clientMessage = (String) readIn;
                  //change to append to text area
                  jtaServer.append(clientMessage+"\n");
               }
               //if it is integer
               else if (readIn instanceof Integer) {
                  //if turn count is zero, then this is going to be the player number
                  if (turnCount == 0) {
                     myNumber = (Integer) readIn;
                     if (myNumber == 1) {
                        jtaServer.append("**You are player number " + myNumber + "**\nYou will be the CardMaster for the first turn.");
                     }
                     else {
                        jtaServer.append("**You are player number " + myNumber + "**\n");
                     }
                     turnCount++;
                     if (turnCount != myNumber) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                     }    
                  }
                  //if the turn count isnt zero, then it is the number 
                  //of the winning player for that round
                  else if (turnCount > 0) {
                     winningPlayer = (Integer) readIn;
                     int currScore;
                     
                     //if the winning player is 1, add one to their score
                     if (winningPlayer == 1) {
                        currScore = Integer.parseInt(playerOne.getText());
                        currScore++;
                        playerOne.setText("" + currScore); 
                        resetBoard();
                     }
                     //if the winning player is 2
                     else if (winningPlayer == 2) {
                        currScore = Integer.parseInt(playerTwo.getText());
                        currScore++;
                        playerTwo.setText("" + currScore);
                        resetBoard();                         
                     }                  
                     //if the winning player is 3
                     else if (winningPlayer == 3) {
                        currScore = Integer.parseInt(playerThree.getText());
                        currScore++;
                        playerThree.setText("" + currScore);
                        resetBoard();     
                     }  
                     //if the winning player is 4
                     else if (winningPlayer == 4) {
                        currScore = Integer.parseInt(playerFour.getText());
                        currScore++;
                        playerFour.setText("" + currScore);
                        resetBoard();   
                     }
                  }
               }    
               //if the object is a Black Card  
               else if (readIn instanceof BlackCard) {
                  BlackCard msg = (BlackCard)readIn;
                  String cardmsg = msg.getMessage();
                  //call the html method and set the text to the black card
                  cardmsg = toHtml(cardmsg, 18);
                  cBlack.setText("<html><center>" + cardmsg + "</center></html>");
               }
               //if its a whiteCard  
               else if (readIn instanceof WhiteCard) {
                  WhiteCard test = (WhiteCard) readIn;
                  //for testing
                  //System.out.println(test.getMessage() + test.getPlayerNumber());
                  //go thru the buttons and see which ones are empty
                  
                  //if empty, set the text
                  if (cardOne.getText().equals("")) {
                     setWhiteText(cardOne, readIn);
                  }
                  else if (cardTwo.getText().equals("")) {
                     setWhiteText(cardTwo, readIn);
                  }
                  else if (cardThree.getText().equals("")) {
                     setWhiteText(cardThree, readIn);
                  }
                  else if (cardFour.getText().equals("")) {
                     setWhiteText(cardFour, readIn);
                  }
                  else if (cardFive.getText().equals("")) {
                     setWhiteText(cardFive, readIn);
                  }
                  else if(cardSix.getText().equals("")) {
                     cardSix.setText(test.getMessage());
                     sentCards.add(test);
                     if (turnCount == myNumber) {
                        cardSix.setEnabled(true);
                     }
                  }
                  else if(cardSeven.getText().equals("")) {
                     cardSeven.setText(test.getMessage());
                     sentCards.add(test);
                     if (turnCount == myNumber) {
                        cardSeven.setEnabled(true);
                     }
                  }
                  else if(cardEight.getText().equals("")) {
                     cardEight.setText(test.getMessage());
                     sentCards.add(test);
                     if (turnCount == myNumber) {
                        cardEight.setEnabled(true); 
                     }
                  }
               }
            }
         }
         
         catch(ConnectException ce ) { 
            System.out.println("Server is Not Online"); 
         }
         catch(ClassNotFoundException cnfe) {
            System.out.println("class not found");
         }
         catch(UnknownHostException uhe) {
            System.out.println("no host");
         }
         catch(IOException ioe) {
            System.out.println("Server was terminated...");
         }
       
      }
      
      //actionPerformed      
      public void actionPerformed(ActionEvent ae) {
         Object choice = ae.getSource();
         
         //if clicked button 1-5, send to server and disable after
            if (choice == cardOne) {
            WhiteCard wc = new WhiteCard(cardOne.getText());
            wc.setPlayerNumber(playerNum);
            Object o = wc;
            try {
               oos.writeObject(o);
               oos.flush();
               cardOne.setText("");
               disable(); 
            }
            catch (IOException ioe) {
               System.out.println("IO Exception");
            }     
         }
         else if (choice == cardTwo) {
            WhiteCard wc = new WhiteCard(cardTwo.getText());
            wc.setPlayerNumber(playerNum);
            Object o = wc;
            try {
               oos.writeObject(o);
               oos.flush();
               cardTwo.setText("");
                disable(); 
            }
            catch (IOException ioe) {
               System.out.println("IO Exception");
            }   
         }
         else if (choice == cardThree) {
            WhiteCard wc = new WhiteCard(cardThree.getText());
            wc.setPlayerNumber(playerNum);
            Object o = wc;
            try {
               oos.writeObject(o);
               oos.flush();
               cardThree.setText("");
                disable(); 
            }
            catch (IOException ioe) {
               System.out.println("IO Exception");
            }    
         }
         else if (choice == cardFour) {
            WhiteCard wc = new WhiteCard(cardFour.getText());
            wc.setPlayerNumber(playerNum);
            Object o = wc;
            try {
               oos.writeObject(o);
               oos.flush();
               cardFour.setText("");
                disable(); 
            }
            catch (IOException ioe) {
               System.out.println("IO Exception");
            }   
         }
         else if (choice == cardFive) {
            WhiteCard wc = new WhiteCard(cardFive.getText());
            wc.setPlayerNumber(playerNum);
            Object o = wc;
            try {
               oos.writeObject(o);
               oos.flush();
               cardFive.setText(""); 
                disable();
            }
            catch (IOException ioe) {
               System.out.println("IO Exception");
            }
         }
         //if 6-8, send the card to the server as the winning card
         else if (choice == cardSix) {
            if (cardSix.getText().equals("")) {
               return;
            }
            for (WhiteCard thisCard : sentCards) {
               if (thisCard.getMessage().equals(cardSix.getText())) {
                  Object send = thisCard;
                  try {
                     oos.writeObject(send);
                     oos.flush();
                  }
                  catch(IOException ioe) {
                     System.out.println("IOException");
                  }
               }
            }  
         }
         else if (choice == cardSeven) {
            if(cardSeven.getText().equals("")) {
               return;
            }
            for (WhiteCard thisCard : sentCards) {
               if (thisCard.getMessage().equals(cardSeven.getText())) {
                  Object send = thisCard;
                  try {
                     oos.writeObject(send);
                     oos.flush();
                  }
                  catch(IOException ioe) {
                     System.out.println("IOException");
                  }
               }
            }  
         }
         else if (choice == cardEight) {
            if (cardEight.getText().equals("")) {
               return;
            }
            for (WhiteCard thisCard : sentCards) {
               if (thisCard.getMessage().equals(cardEight.getText())) {
                  Object send = thisCard;
                  try {
                     oos.writeObject(send);
                     oos.flush();
                  }
                  catch(IOException ioe) {
                     System.out.println("IOException");
                  }
               }
            }  
         }
      }
      
      /**
       * Disable method to disable the player's 5 cards
       * only used when they are the cardMaster
       */
      public void disable() {
         cardOne.setEnabled(false);
         cardTwo.setEnabled(false);
         cardThree.setEnabled(false);
         cardFour.setEnabled(false);
         cardFive.setEnabled(false);
      }
      /** SetWhiteText gets the string from the white card, calls the toHtml method, puts it on
        * the jButton with the html and center  tags
        * @param jb JButton Button to set text to
        * @param _readIn Object in which to take text from
        */
      public void setWhiteText(JButton jb, Object _readIn) {
         WhiteCard wc = (WhiteCard)_readIn;
         playerNum = wc.getPlayerNumber();
         String wcMsg = wc.getMessage();
         wcMsg = toHtml(wcMsg, 18);
         System.out.println(wcMsg);
         jb.setText("<html><center>" + wcMsg + "</center></html>");   
      }
      
      /** toHtml calls the create method in a loop to add all the break tags
       *  @param text String text that formats to the card
       *  @param number int *magic* number that fits the card's wrap
       *  @return text String formatted
       */
      public String toHtml(String text, int number) {
         StringBuilder sb = new StringBuilder(text);
         int loc = 0;
         String space = " ";
         loc = loc + number;
         while (loc < sb.length()) {
            createLine(loc, sb);
            loc = loc + number;  
         }
         text = sb.toString();
         return text;
      }
      /** createLine method to put breaks in the card strings so they are readable
       *  @param _loc int inserts br tags
       *  @param _sb StringBuilder where to add text
       */
      public void createLine(int _loc, StringBuilder _sb) {
         if (_sb.charAt(_loc) == ' ') {
            _sb.insert(_loc, "<br>");
         }
         else {
            _loc--;
            createLine(_loc, _sb);
         }
      }
      /** resetBoard resets board after each turn */
      public void resetBoard() {
         //remove the potential winning cards after winner is picked
         cardSix.setText("");
         cardSeven.setText("");
         cardEight.setText("");
         
         //change turn count
         if (turnCount == 4) {
            turnCount = 1;
         }
         else {
            turnCount++;  
         }
         
         //if the player isnt the cardmaster, enable their cards
         if (turnCount != myNumber) {
            cardOne.setEnabled(true);
            cardTwo.setEnabled(true);
            cardThree.setEnabled(true);
            cardFour.setEnabled(true);
            cardFive.setEnabled(true); 
            cardSix.setEnabled(false);
            cardSeven.setEnabled(false);
            cardEight.setEnabled(false);  
         }
         if (turnCount == myNumber) {
            cardSix.setEnabled(true);
            cardSeven.setEnabled(true);
            cardEight.setEnabled(true);
            JOptionPane.showMessageDialog(null, "You are the CardMaster for this turn.");
         }
      }
   
   }
}
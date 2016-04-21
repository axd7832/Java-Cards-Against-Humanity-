import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class CardsClient extends JFrame //implements ActionListener
{

   private static final long serialVersionUID = 1L;

   public volatile static String winner = "";

   private boolean sendCards = false;
   private boolean beginRound = false;
   private boolean judge = false;
   private boolean player = false;
   private boolean judgeDecision = false;

   private int outInt = 0;
   private int playerScore = 0;
   private String sentenceString;

   private Map<Integer, String> playerCards;
   ArrayList<Integer> keyList = new ArrayList<Integer>();

   private JPanel jpCenter;
   private JPanel jpNorth;
   private JPanel chatPanel;

   private JTextArea sentenceArea;

   private JButton c1;
   private JButton c2;
   private JButton c3;
   private JButton c4;
   private JButton c5;
   private JButton cBlack;

   private JTextArea cardLabel1;
   private JTextArea cardLabel2;
   private JTextArea cardLabel3;
   private JTextArea cardLabel4;
   private JTextArea cardLabel5;
   private JTextArea cardLabel6;

   private JPanel jpChat;
   private JPanel jpRightChat;
   
   private JPanel jpTop;
   private JPanel jpBottom;
   private JPanel jpServerConnect;
   
   private JFrame frame;
   
   private JTextArea jtaServer;
   private JTextArea jtaClient;
   
   private JButton jbSend;
   private JButton jbConnect;
   
   private JMenuBar jmb;
   private JMenu jmFile;
   private JMenuItem jmiNew;
   private JMenuItem jmiExit;

   private Socket ss = null;
   
   private OutputStream out = null;
   private PrintWriter pout = null;
   //IP
   private final String IP = "localhost";
   //PORT #
   private final int PORT = 16789;
   
   private String clientName;
   

   public CardsClient()
   {
      setTitle("Cards Against Humanity Online");
      setLayout(new BorderLayout());
   
      Font sentenceFont = new Font("Arial", Font.ITALIC + Font.BOLD, 15);
   
      Dimension cardDimen = new Dimension(165, 180);
      Font cardLabelFont = new Font("Arial", Font.BOLD, 16);
      Font cardFont = new Font("Arial", Font.BOLD, 20);
      Color backgroundColor = new Color(238, 238, 238);
      
      //JmenuBar
      jmb = new JMenuBar();
      setJMenuBar(jmb);
         jmFile = new JMenu("File");
         jmb.add(jmFile);
            jmiNew = new JMenuItem("New Game");
            jmFile.add(jmiNew);
            jmiExit = new JMenuItem("Exit");
            jmFile.add(jmiExit);
         
      //white card 1
      c1 = new JButton("1");
      c1.setFont(cardFont);
      c1.setVerticalAlignment(SwingConstants.BOTTOM);
      c1.setLayout(new BorderLayout());
      cardLabel1 = new JTextArea();
      cardLabel1.setLineWrap(true);
      cardLabel1.setWrapStyleWord(true);
      cardLabel1.setFont(cardLabelFont);
      cardLabel1.setEditable(false);
      cardLabel1.setBackground(backgroundColor);
      c1.setPreferredSize(cardDimen);
      c1.add(BorderLayout.NORTH, cardLabel1);
      c1.setEnabled(false);
   
      //white card 2
      c2 = new JButton("2");
      c2.setFont(cardFont);
      c2.setVerticalAlignment(SwingConstants.BOTTOM);
      c2.setLayout(new BorderLayout());
      cardLabel2 = new JTextArea();
      cardLabel2.setLineWrap(true);
      cardLabel2.setWrapStyleWord(true);
      cardLabel2.setFont(cardLabelFont);
      cardLabel2.setEditable(false);
      cardLabel2.setBackground(backgroundColor);
      c2.setPreferredSize(cardDimen);
      c2.add(BorderLayout.NORTH, cardLabel2);
      c2.setEnabled(false);
  
      //white card 3
      c3 = new JButton("3");
      c3.setFont(cardFont);
      c3.setVerticalAlignment(SwingConstants.BOTTOM);
      c3.setLayout(new BorderLayout());
      cardLabel3 = new JTextArea();
      cardLabel3.setLineWrap(true);
      cardLabel3.setWrapStyleWord(true);
      cardLabel3.setFont(cardLabelFont);
      cardLabel3.setEditable(false);
      cardLabel3.setBackground(backgroundColor);
      c3.setPreferredSize(cardDimen);
      c3.add(BorderLayout.NORTH, cardLabel3);
      c3.setEnabled(false);
   
      //white card 4
      c4 = new JButton("4");
      c4.setFont(cardFont);
      c4.setVerticalAlignment(SwingConstants.BOTTOM);
      c4.setLayout(new BorderLayout());
      cardLabel4 = new JTextArea();
      cardLabel4.setLineWrap(true);
      cardLabel4.setWrapStyleWord(true);
      cardLabel4.setFont(cardLabelFont);
      cardLabel4.setEditable(false);
      cardLabel4.setBackground(backgroundColor);
      c4.setPreferredSize(cardDimen);
      c4.add(BorderLayout.NORTH, cardLabel4);
      c4.setEnabled(false);
   
      //white card 5
      c5 = new JButton("5");
      c5.setFont(cardFont);
      c5.setVerticalAlignment(SwingConstants.BOTTOM);
      c5.setLayout(new BorderLayout());
      cardLabel5 = new JTextArea();
      cardLabel5.setLineWrap(true);
      cardLabel5.setFont(cardLabelFont);
      cardLabel5.setEditable(false);
      cardLabel5.setBackground(backgroundColor);
      c5.setPreferredSize(cardDimen);
      c5.add(BorderLayout.NORTH, cardLabel5);
      c5.setEnabled(false);
      
      //black card
      cBlack = new JButton("Black Card");
      cBlack.setFont(cardFont);
      cBlack.setVerticalAlignment(SwingConstants.BOTTOM);
      cBlack.setLayout(new BorderLayout());
      cardLabel6 = new JTextArea();
      cardLabel6.setLineWrap(true);
      cardLabel6.setFont(cardLabelFont);
      cardLabel6.setEditable(false);
      cardLabel6.setBackground(backgroundColor);
      cBlack.setPreferredSize(cardDimen);
      cBlack.add(BorderLayout.NORTH, cardLabel6);
      cBlack.setEnabled(false);

   
      //c1.addActionListener(this);
      //c2.addActionListener(this);
      //c3.addActionListener(this);
      //c4.addActionListener(this);
      //c5.addActionListener(this);
      
      jpNorth = new JPanel(new FlowLayout());
      jpCenter = new JPanel (new FlowLayout());
      jpChat = new JPanel(new BorderLayout());
      
      add(jpNorth, BorderLayout.NORTH);
      add(jpCenter,BorderLayout.CENTER);
      add(jpChat,BorderLayout.SOUTH);
   
      jpNorth.add(cBlack);

      jpCenter.add(c1);
      jpCenter.add(c2);
      jpCenter.add(c3);
      jpCenter.add(c4);
      jpCenter.add(c5); 
       
   
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
                  try{
                     //Socket
                     ss = new Socket( IP , PORT);
                     //Output Stream
                     out = ss.getOutputStream();
                     //Input Stream
                     pout = new PrintWriter(out);
                     //Thread to Update the Text Area
                     ClientThread ct = new ClientThread(ss);
                     ct.start();
                     
                     
                     jbSend.addActionListener(
                           new ActionListener(){
                              public void actionPerformed(ActionEvent ae) {
                                 //try{
                                   //Client enters username
                                 if(clientName == null){
                                    clientName = JOptionPane.showInputDialog(jbSend,"Please enter a username");
                                 }
                                 if(jtaClient.getText().length() > 0){
                                    String clientMsg = jtaClient.getText();
                                       //Writes then flushes
                                    pout.println(clientName + ": " + clientMsg);		// Writes some String to server
                                    pout.flush();
                                    jtaClient.setText("");
                                    	// forces the data through to server
                                 }   
                                 // }
                              //                                  catch( ArrayIndexOutOfBoundsException aioobe ) {
                              //                                     System.out.println("\nUsage: java Day10Server hostname some-word");
                              //                                  }
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
                     System.out.println("\nUsage: java Day10Server hostname some-word");
                  }
               }});
   
      //add(jpCenter);
      setSize(900,700);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   
   }//end constructor

   public static void main(String [] args)
   {
      new CardsClient();
   //new ChatClient();
   }
   class ClientThread extends Thread{
      InputStream in = null;
      BufferedReader bin = null;
      Socket ss2 = null;
      
      public ClientThread(Socket ss){
         ss2 = ss;
      }  
      public void run(){
         try{
            in = ss2.getInputStream();
            bin = new BufferedReader(new InputStreamReader(in));
            //Always updates 
            while(true){
               String serverMsg = bin.readLine();
               jtaServer.append("\n" + serverMsg);
            }
         }
         catch(ConnectException ce ) { 
            System.out.println("Server is Not Online"); 
         }
         catch(UnknownHostException uhe) {
            System.out.println("no host");
         }
         catch(IOException ioe)
         {
            System.out.println("Server was terminated...");
         }
         
      }
   }

}//end class
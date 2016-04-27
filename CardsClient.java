
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class CardsClient extends JFrame {

   private JPanel jpCenter;
   private JPanel jpNorth;
   private JPanel jpChat;
   private JPanel jpRightChat;
   private JPanel jpScore;

   private JButton c1;
   private JButton c2;
   private JButton c3;
   private JButton c4;
   private JButton c5;
   private JButton c6;
   private JButton c7;
   private JButton c8;
   private JButton cBlack;
   private JButton jbSend;
   private JButton jbConnect;
   
   private JTextField jtf1;
   private JTextField jtf2;
   private JTextField jtf3;
   private JTextField jtf4;
   
   private JTextArea jtaServer;
   private JTextArea jtaClient;
   
   private JMenuBar jmb;
   private JMenu jmFile;
   private JMenuItem jmiNew;
   private JMenuItem jmiExit;

   private Socket ss = null;
   
   private OutputStream out = null;
   private PrintWriter pout = null;
   
   private final String IP = "localhost";
   private final int PORT = 16789;
   
   private String clientName;
   

   public CardsClient()
   {
      setTitle("Cards Against Humanity");
      setLayout(new BorderLayout());
      
      Dimension cardDimen = new Dimension(165, 180);
      Font cardFont = new Font("Arial", Font.BOLD, 20);
      
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
      c1.setPreferredSize(cardDimen);
      c1.setEnabled(false);
   
      //white card 2
      c2 = new JButton("2");
      c2.setFont(cardFont);
      c2.setPreferredSize(cardDimen);
      c2.setEnabled(false);
   
      //white card 3
      c3 = new JButton("3");
      c3.setFont(cardFont);
      c3.setPreferredSize(cardDimen);
      c3.setEnabled(false);
   
      //white card 4
      c4 = new JButton("4");
      c4.setFont(cardFont);
      c4.setPreferredSize(cardDimen);
      c4.setEnabled(false);
   
      //white card 5
      c5 = new JButton("5");
      c5.setFont(cardFont);
      c5.setPreferredSize(cardDimen);
      c5.setEnabled(false);
      
      //black card
      cBlack = new JButton("Black Card");
      cBlack.setFont(cardFont);
      cBlack.setBackground(Color.BLACK);
      cBlack.setForeground(Color.BLACK);
      cBlack.setPreferredSize(cardDimen);
      cBlack.setOpaque(true);
      cBlack.setEnabled(false);
      
      //other players cards (for cardmaster)
      c6 = new JButton("");
      c6.setFont(cardFont);
      c6.setPreferredSize(cardDimen);
      c6.setEnabled(false);
      
      c7 = new JButton("");
      c7.setFont(cardFont);
      c7.setPreferredSize(cardDimen);
      c7.setEnabled(false);
      
      c8 = new JButton("");
      c8.setFont(cardFont);
      c8.setPreferredSize(cardDimen);
      c8.setEnabled(false);
      
      
      //score keeper
      /*
      *Save the players usernames from chat and put on scoreboard
      *Set the scores to zero in un-editable texfields
      */
      jpScore = new JPanel(new GridLayout(0,2));
      jtf1 = new JTextField(3);
         jtf1.setText("0");
         jtf1.setEnabled(false);
      jtf2 = new JTextField(3);
         jtf2.setText("0");
         jtf2.setEnabled(false);
      jtf3 = new JTextField(3);
         jtf3.setText("0");
         jtf3.setEnabled(false);
      jtf4 = new JTextField(3);
         jtf4.setText("0");
         jtf4.setEnabled(false);
      jpScore.add(new JLabel("Player 1:", JLabel.RIGHT));
      jpScore.add(jtf1);
      jpScore.add(new JLabel("Player 2:", JLabel.RIGHT));
      jpScore.add(jtf2);
      jpScore.add(new JLabel("Player 3:", JLabel.RIGHT));
      jpScore.add(jtf3);
      jpScore.add(new JLabel("Player 4:", JLabel.RIGHT));
      jpScore.add(jtf4);
      
      
   
   
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
      jpNorth.add(c6);
      jpNorth.add(c7);
      jpNorth.add(c8);
      jpNorth.add(jpScore);
   
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
}

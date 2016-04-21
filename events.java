import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class events {
   private JPanel jpTop;
   private JPanel jpBottom;
   private JPanel jpServerConnect;
   
   private JTextArea jtaServer;
   private JTextArea jtaClient;
   
   private JButton jbSend;
   private JButton jbConnect;
   
   JPanel jpChat = null;
  
   private Socket ss = null;
   
   private OutputStream out = null;
   private PrintWriter pout = null;
   //IP
   private final String IP = "localhost";
   //PORT #
   private final int PORT = 16789;
   
   private String clientName;
   
   public static void main (String args[]) {
      ChatClient chatTest = null;   
      JFrame mainJFrame;
      mainJFrame = new JFrame();
      chatTest = new ChatClient();
      mainJFrame.add(chatTest);
        // Coding by magic!
        //mainJFrame.setLayout(BorderLayout());
      mainJFrame.setLayout(new BorderLayout());
      mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // don't do this, just call pack() later
        //mainJFrame.setSize(600,400);
      mainJFrame.setLayout(new BorderLayout());
      mainJFrame.setTitle("Test");
      mainJFrame.pack();
        // should be last.
      mainJFrame.setVisible(true);
   }
   class ChatClient{
      public ChatClient(){
         jpChat = new JPanel();
      
         jpChat.setLayout(new BorderLayout());
      
      //Top of the GUI
         jpServerConnect = new JPanel(new FlowLayout());
         jpChat.add(jpServerConnect, BorderLayout.NORTH);      
      //Middle of the GUI
         jpTop = new JPanel();
         jpChat.add(jpTop, BorderLayout.CENTER);
      //adds text area
         jtaServer = new JTextArea(20,50);
         jtaServer.setEditable(false);
      //adds line wrap
         jtaServer.setLineWrap(true);
      //adds scrollable
         JScrollPane scroll = new JScrollPane (jtaServer);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         jpTop.add(scroll , BorderLayout.CENTER);
      
      //Bottom Half of the GUI
         jpBottom = new JPanel();
         jpChat.add(jpBottom , BorderLayout.SOUTH);
      //client text area to send to server
         jtaClient = new JTextArea(5,20);
      //line wrap
         jtaClient.setLineWrap(true);
      //Allows for Scrolling
         JScrollPane scroll2 = new JScrollPane (jtaClient);
         scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         jbSend = new JButton("Send");
         jbConnect = new JButton("Connect");
      
         jpServerConnect.add(jbConnect);
      //jpBottom.add(scroll2);
         jpBottom.add(scroll2 , BorderLayout.SOUTH);
      //adds button to panel
      
         jpBottom.add(jbSend);
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
                        //ClientThread ct = new ClientThread(ss);
                        //ct.start();
                     
                     
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
         jpChat.setSize(300,300);
         jpChat.setVisible(true);
      }
   }
}


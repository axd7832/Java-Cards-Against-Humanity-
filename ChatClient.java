import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** 
 * ChatClient is used to communicate between Clients through ChatServer
 * @author Andrew Diana
 * @version 4-2-16
 */
public class ChatClient extends JPanel {//implements ActionListener{
   private JPanel jpChat;
   
   private JPanel jpTop;
   private JPanel jpBottom;
   private JPanel jpServerConnect;
   
   private JFrame frame;
   
   private JTextArea jtaServer;
   private JTextArea jtaClient;
   
   private JButton jbSend;
   private JButton jbConnect;

   private Socket ss = null;
   
   private OutputStream out = null;
   private PrintWriter pout = null;
   //IP
   private final String IP = "localhost";
   //PORT #
   private final int PORT = 16789;
   
   private String clientName;
   /** 
   * main that creates ChatClient object
   */
   //public static void main(String[] args){
   //   new ChatClient();
   //}
  /** 
   * ChatClient constructor that creates the GUI 
   * Also connects to server and sends/recieves messages
   */
   public ChatClient(){
      
   
      jpChat.setLayout(new BorderLayout());
      //Menu Bar
     
      //Action Listener for the exit menu item
  
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
      add(jpChat);
   }
   /** 
    * ClientThread that creates a Socket on the port and ip and updates the Text Area 
    */
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
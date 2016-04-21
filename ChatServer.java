import java.net.*;
import java.io.*;
import java.util.*;

/** 
 * ChatServer is used to communicate between Clients 
 * @author Andrew Diana
 * @version 4-2-16
 */
public class CardsServer {
   
   //Array of PrintWriters
   Vector <PrintWriter> toClients = new Vector <PrintWriter>();
   
   /**
    * main method that calls the ChatServer constructor
    */
    
   public static void main(String [] args) {
      new CardsServer();
   }
   /**
    * ChatServer constructor that opens the ServerSocket and the Socket and runs the ThreadServer
    */
   public CardsServer()
   {
      ServerSocket ss = null;
      try {
         ss = new ServerSocket(16789);
         Socket cs = null;
         while(true){ 		// run forever once up     
            cs = ss.accept(); 				// wait for connection
            ThreadServer ths = new ThreadServer( cs );
            ths.start();
         } // end while
      }     
      catch( BindException be ) {
         System.out.println("Server already running on this computer, stopping.");
      } 
      catch( IOException ioe ) {
         System.out.println("Connection Failure");
      }
   } // end main
   /**
    * ThreadServer that extends Thread.
    * Thread that reads/wr
    ites to PrintWriter and BufferedReader
    */
   class ThreadServer extends Thread {
      Socket cs;
      public ThreadServer( Socket cs ) {
         this.cs = cs;
      }
      public void run() {
         BufferedReader br;
         PrintWriter opw;
         String clientMsg;
         try {
            //Input
            br = new BufferedReader(new InputStreamReader( cs.getInputStream()));
            //Output
            opw = new PrintWriter( new OutputStreamWriter(cs.getOutputStream()));				
            toClients.add(opw); //adds to output list
            opw.println("Welcome to the Server!");
            opw.flush();
            while((clientMsg = br.readLine() ) != null ){  ///continuously reads lines of input     
               for(PrintWriter pw: toClients){ //writes to all clients
                  System.out.println(clientMsg);
                  pw.println(clientMsg);	//to client
                  pw.flush(); //clears the remaining data in the PrintWriter
               }
            }
         }
         catch( SocketException se ) { 
            System.out.println("Client Disconnected..."); 
         }
         catch( IOException e ) { 
            System.out.println("Connection Failed"); 
         }
      } // end while
   } // end class ThreadServer 
} // end ChatServer
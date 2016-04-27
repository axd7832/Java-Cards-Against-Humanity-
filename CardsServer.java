import java.net.*;
import java.io.*;
import java.util.*;

/** 
 * ChatServer is used to communicate between Clients 
 * @author Andrew Diana
 * @version 4-2-16
 */
public class CardsServer implements Serializable{
   
   //Array of PrintWriters
   Vector <ObjectOutputStream> AllClients = new Vector <ObjectOutputStream>(); //Players + CardMaster
   Vector <BlackCard> blackArray  = new Vector<BlackCard>();  
   int playerNumber;
   int cardMaster;
   String generic = null;
   
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
         System.out.println("Server Running...");
         System.out.println("Accepting Clients..");
         while(true){ 
            // run forever once up     
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
   class ThreadServer extends Thread {
      Socket cs;
      Object to = null;
      int playerNumber;
      public ThreadServer( Socket cs ) {
         this.cs = cs;
      }
      public int getPlayerNumber(){
         return this.playerNumber;
      }
      public void setPlayerNumber(int num){
         this.playerNumber = num;
      }
      public void run() {
         InputStream in;
         OutputStream out;
         String clientMsg;
         String clientName = null;
         try {
            //Input
            synchronized(AllClients){
               ++this.playerNumber;
               setPlayerNumber(this.playerNumber);
            }
            out = cs.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            
            in = cs.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            
            AllClients.add(oos); //adds Client to the Vector list 
            
            
            
            while( (to = ois.readObject() )  != null ){
               
            
               //STRING SENT FROM CLIENT
               if (to instanceof String){ 
                  //Sets Username
                  if(clientName == null){
                     clientName = (String)to;
                     System.out.println("Client Name: "+ clientName);
                  }
                  //Username + Input
                  else{
                     clientMsg = (String)to;
                     System.out.println("Client Message: "+ clientMsg);
                     for(ObjectOutputStream client: AllClients){ //writes to all clients
                        client.writeObject(clientName + ": " + clientMsg);	//to client
                        client.flush(); //clears the remaining data in the PrintWriter
                     }
                  }
               }
            //                else if(to instanceof BlackCard){
            //                   
            //                }
            //                else if(to instanceof WhiteCard){
            //                   
            //                }      			
            }
         }
         catch( SocketException se ) { 
            System.out.println("Client Disconnected...");
            clientName = null; 
         }
         catch( IOException e ) { 
            System.out.println("Connection Failed");
            clientName = null;  
         }
         catch(ClassNotFoundException cnfe){
            System.out.println("Class Not Found!");
         }
      } // end while
   } // end class ThreadServer 
} // end ChatServer
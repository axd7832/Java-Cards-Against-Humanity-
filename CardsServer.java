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
   CardsList cl = new CardsList();//use to get random cards for the players
   BlackCard currentBc;
   int numPlayers;
   
     
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
         
         //get first black card
         String bc = cl.sendBlack();
         currentBc = new BlackCard(bc);
         
         int playerID = 1;
            
         while(numPlayers < 4){ 
            // run forever once up     
            cs = ss.accept(); 				// wait for connection
            numPlayers++;
            ThreadServer ths = new ThreadServer(cs, playerID, currentBc);
            ths.start();
            playerID++;
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
      int playerID; // 1 through 4 assigned to each player
      CardsList clist = new CardsList();
      BlackCard currentBc;
      ArrayList<WhiteCard> submissions = new ArrayList<WhiteCard>(); //holds the cards picked by the players
           
      public ThreadServer(Socket cs, int playerID, BlackCard _bc) {
         this.cs = cs;
         currentBc = _bc;
         this.playerID = playerID;
      }
      
      public int getPlayerID() {
         return playerID;
      }

      public void run() {
         InputStream in;
         OutputStream out;
         String clientMsg;
         String clientName = null;
         int turn = 1; //use to determine cardmaster, adds 1 after each turn
         
         try {
            
            out = cs.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            
            in = cs.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            
            AllClients.add(oos); //adds Client to the Vector list            
            
            //send 5 white cards to player
            for (int i = 0; i < 5; i++) {
               String sendCard = clist.sendWhite();
               WhiteCard wc = new WhiteCard(sendCard);
               oos.writeObject(wc);
               oos.flush();
            }
            
            oos.writeObject(currentBc);
            oos.flush();
            
            
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
               else if (to instanceof WhiteCard) {
               
                  //if the player is not the cardMaster
                  if (turn % playerID != 0) {
                     submissions.add(to);
                     if (submissions.size() == 3) {
                        //send to the cardmaster
                        
                     }
                  } 
               }
 
            }//end while
         }//end try
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
   
   class Player {
   
      public Player(String clientName, int playerID) {
         this.clientName = clientName;
         this.playerID = playerID;   
      }
   } 
} // end ChatServer
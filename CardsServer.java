import java.net.*;
import java.io.*;
import java.util.*;

/** 
 * ChatServer is used to communicate between Clients to play Cards Against Humanity 
 * @author Andrew Diana
 * @author Jenna Tilotson
 * @version 5-18-16
 */
public class CardsServer implements Serializable{
   
   //Array of PrintWriters
   private Vector <ObjectOutputStream> allClients = new Vector <ObjectOutputStream>(); //Players + CardMaster
   private Vector <BlackCard> blackCardList  = new Vector<BlackCard>(); 
   private Vector <WhiteCard> submissions = new Vector<WhiteCard>(); //holds the cards picked by the players 
   private ArrayList <String> clientNames = new ArrayList<String>();
   private WhiteCard winningCard = null;
   private int winningPlayer;
   private int cardMaster = 1;
   private CardsList cl = new CardsList();//use to get random cards for the players
   private final int MAX_PLAYER_COUNT = 4;
   private int numPlayers;
   private int turn = 1;
   /**
    * main method that calls the ChatServer constructor
    * @param args Main Arguments
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
         
         //sends 5 black cards to the ThreadClients
         synchronized(allClients){
            for(int x = 0 ; x < 5; x++){
               String bc = cl.sendBlack();
               blackCardList.add(new BlackCard(bc) );
            }
         }
         int playerID = 1;
         //starts playerID off as 1   
         while(numPlayers < MAX_PLAYER_COUNT){     
            cs = ss.accept();
            numPlayers++;
            ThreadServer ths = new ThreadServer(cs, playerID, blackCardList);
            for(BlackCard c : blackCardList){
               System.out.println(c.getMessage());
            }
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
   }
   /**
    * Thread Server to accept clients and assigns them an identifier
    */
   class ThreadServer extends Thread {
      Socket cs;
      Object to = null;
      Vector <BlackCard> bc;
      int playerID; // 1 through 4 assigned to each player
      /**
       * Thread constructor takes socket, playerID, and BlackCard to send to player
       * @param cs Socket to bind on 
       * @param playerID int player indentifier
       * @param _bc Vector Array of black cards sent to clients
       */     
      public ThreadServer(Socket cs, int playerID, Vector<BlackCard> _bc) {
         this.cs = cs;
         bc = _bc;
         this.playerID = playerID;
      }
      /**
       * returns the playerID
       * @return playerID int
       */
      public int getPlayerID() {
         return playerID;
      }
      /**
       * run method of the thread
       */
      public void run() {
         InputStream in;
         OutputStream out;
         String clientMsg;
         String clientName = null;
          //use to determine cardmaster, adds 1 after each turn
         try {
         //output
            out = cs.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
         //input
            in = cs.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            //synchronized add clients to the Vector of clients
            synchronized(allClients){
               allClients.add(oos); //adds Client to the Vector list            
            }
            //starts by sending 5 white cards to the clients
            for (int i = 0; i < 5; i++) {
               synchronized(allClients){
                  String sendCard = cl.sendWhite();
                  WhiteCard wc = new WhiteCard(sendCard);
                  wc.setPlayerNumber(playerID);
                  oos.writeObject(wc);
                  oos.flush();
               }
            }
            //sends turn count 
            oos.writeObject(bc.get(turn));
            oos.flush();
            //sends playerID
            oos.writeObject((Integer) playerID); //writes player ID to client
            oos.flush();   
            while( (to = ois.readObject() )  != null ){
               //STRING SENT FROM CLIENT
               if (to instanceof String){ 
                  //Sets Username
                  if(clientName == null){
                     clientName = (String)to;
                     clientNames.add(clientName);
                     System.out.println("Player Number: "+ playerID + " : " + clientName + " : ");
                  }
                  //Username + Input
                  else{
                     clientMsg = (String)to;
                     System.out.println("Client Message: "+ clientMsg);
                     for(ObjectOutputStream client: allClients){ //writes to all clients
                        client.writeObject("Player Number: "+ playerID + " : " + clientName + " : " + clientMsg);	//to client
                        client.flush(); //clears the remaining data in the PrintWriter
                     }
                  }
               }
               else if (to instanceof WhiteCard) {
                  WhiteCard wc = (WhiteCard) to;
                  //if the player is not the cardMaster
                  if (cardMaster == playerID ) {
                     System.out.println(cardMaster + " Cardmaster");
                     System.out.println(playerID + " PlayerID");
                     winningCard = wc;
                     winningPlayer = winningCard.getPlayerNumber();
                     ++turn;
                     for(ObjectOutputStream toEveryone: allClients){
                        toEveryone.writeObject((Integer) winningPlayer);
                        toEveryone.flush(); //sends winning player
                        toEveryone.writeObject("The Card Master chose " + playerID + "'s card : " + winningCard.getMessage() );
                        toEveryone.flush();//sends winning White Card
//PROBLEM               
                        System.out.println(bc.get(turn).getMessage());
                        toEveryone.writeObject(bc.get(turn)); //sends next black card in BlackCard array
                        toEveryone.flush();
//PROBLEM
                     }
                     //New Round
                     winningCard = null;
                     winningPlayer = 0;
                     //Removes cards from submissions
                     for(int subCount = 0; subCount < 3 ; ++subCount){
                        submissions.remove(0);
                     }
                     //loops back cardmaster count back to 1
                     if(cardMaster == 4){
                        cardMaster = 1;
                     }
                     else{
                        cardMaster++;
                     }
                     System.out.println(cardMaster + " new Cardmaster");       
                  }
                  else{ //not the cardMaster
                     //while less than 3 cards
                     if(submissions.size() < 4){
                        submissions.add(wc);
                     }
                     System.out.println("Added : " + wc.getPlayerNumber() + "to submission");
                     synchronized(allClients){
                        String newCard = cl.sendWhite();
                        WhiteCard wc2 = new WhiteCard(newCard);
                        wc2.setPlayerNumber(playerID);
                        System.out.println("Sent to jenna : " + wc2.getPlayerNumber() + ":"   + wc2.getMessage());
                        oos.writeObject(wc2);
                        oos.flush();
                     }
                  } 
               }
               //if 3 submissions are collected
               if(submissions.size() == 3){
                  for(ObjectOutputStream toEveryone: allClients){
                     for(WhiteCard cmSubs: submissions){
                        toEveryone.writeObject(cmSubs);
                        toEveryone.flush();
                        System.out.println("Sent card: " + cmSubs.getMessage() + " to player" + cmSubs.getPlayerNumber() );
                     }
                  }
               }
               //if 4 players are connected
               if(numPlayers == 4 ){
                  for(ObjectOutputStream toEveryone: allClients){
                     toEveryone.writeObject("The players currently connected: ");
                     for(String name: clientNames){
                        toEveryone.writeObject(name);
                        toEveryone.flush();
                     }
                     System.out.println("Sent name array to client");
                  }
               }
            }//end while
         }//end try
         catch( SocketException se ) { 
            System.out.println("Client Disconnected...");
            clientName = null; 
         }
         catch( IOException e ) { 
            System.out.println("Player : " + playerID + " disconnected...");
            clientName = null;  
         }
         catch(ClassNotFoundException cnfe){
            System.out.println("Class Not Found...");
         }
      } // end while
   } // end class ThreadServer
} // end ChatServer
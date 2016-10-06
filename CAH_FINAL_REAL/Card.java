import java.io.*;
/**
 * Card to be sent over the server
 * @author Andrew Diana
 * @author Jenna Tillotson
 */
public class Card implements Serializable {

   //attributes
   private String message;
   protected String cardType;
   protected int playerNumber;
   /**
    * Card constructor to set message
    * @param _message String message to card
    */
   public Card(String _message) {   
      message = _message;
      cardType = null;      
   } 
   /**
    * getMessage returns the card's message
    * @return message String cards message
    */
   public String getMessage() {
      return message;  
   }
   /**
    * setPlayerNumber constructor to set message
    * @param num int playerNumber 
    */
   public void setPlayerNumber(int num){
      this.playerNumber = num;
   }
   /**
    * getPlayerNumber constructor to set message
    * @return playerNumber int playerNumber
    */
   public int getPlayerNumber(){
      return this.playerNumber;
   } 
}
   /** BlackCard sent across the Server    */ 
class BlackCard extends Card {
   /** BlackCard sets the message for the card
    *  @param _message cards text
    */  
   public BlackCard(String _message) {
      super(_message);
      cardType = "BLACK";
   }
}
  /** WhiteCard sent across the Server   */ 
class WhiteCard extends Card {
   /** WhiteCard sets the message for the card
    * @param _message cards text
    */ 
   public WhiteCard(String _message) {
      super(_message);
      cardType = "WHITE";
   }
}
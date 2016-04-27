import java.io.*;

public class Card implements Serializable {

   //attributes
   private String message;
   protected String cardType;

   //constructor
   public Card(String _message) {   
      message = _message;
      cardType = null;
           
   } 
   
   //get the message from the card
   public String getMessage() {
      return message;  
   } 
   
}

class BlackCard extends Card {

    
   public BlackCard(String _message) {
      super(_message);
      cardType = "BLACK";
   }

}

class WhiteCard extends Card {

   public WhiteCard(String _message) {
      super(_message);
      cardType = "WHITE";
   }

}
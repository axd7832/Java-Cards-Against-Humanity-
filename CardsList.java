import java.util.*;

/**
*Class to hold the vectors of black and white cards
*When objects of the class are created, they can be used to send a black
or white card to the player.

*/

public class CardsList {
   
   Vector<String> whiteCards = new Vector <String>();
   Vector<String> blackCards = new Vector<String>();     
   
   public CardsList() {
      addWhite();
      addBlack();     
   }
   
   //add all the cards into the arraylist when object of class is created
   public void addWhite() {
      whiteCards.add("1");
      whiteCards.add("2");
      whiteCards.add("3");
      whiteCards.add("4");
      whiteCards.add("5");
      whiteCards.add("6");
      whiteCards.add("7");
      whiteCards.add("8");
      whiteCards.add("9");
      whiteCards.add("10");
      whiteCards.add("11");
      whiteCards.add("12");
      whiteCards.add("13");
      whiteCards.add("14");
      whiteCards.add("15");
      whiteCards.add("16");
      whiteCards.add("17");
      whiteCards.add("18");
      whiteCards.add("19");
      whiteCards.add("20");
      
   }
   
   //add all the black cards to the vector
   public void addBlack() {
      blackCards.add("1");
      blackCards.add("2");
      blackCards.add("3");
      blackCards.add("4");
      blackCards.add("5");
      blackCards.add("6");
      blackCards.add("7");
   }
   
   //get a random card, return the card and remove from list
   public String sendWhite() {
      Random r = new Random();
      int wcard = r.nextInt(whiteCards.size());
      String send = whiteCards.get(wcard);
      whiteCards.remove(wcard);
      return send;    
   }
   
   //get a random card, retirn and remove from list 
   
   public String sendBlack() {
      Random r = new Random();
      int bcard = r.nextInt(blackCards.size());
      String send = blackCards.get(bcard);
      blackCards.remove(bcard);
      return send;    
   }


}
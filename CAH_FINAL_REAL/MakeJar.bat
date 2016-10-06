javac *.java

jar -cefv CardsServer CardsServer.jar CardsServer*.class Card.class CardsList.class



jar -cefv CardsClient CardsClient.jar CardsClient*.class Card.class CardsList.class



javadoc -d doc -private -author -version *.java
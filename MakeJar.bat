javac *.java

jar -cefv CardsServer CardsServer.jar *.class
jar -cefv CardsClient CardsClient.jar *.class
javadoc -d doc -private -author -version *.java
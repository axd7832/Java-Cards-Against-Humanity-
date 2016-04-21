javac *.java

jar -cefv ChatServer ChatServer.jar *.class images/*.* 

jar -cefv CharClient ChatClient.jar *.class images/*.*

java ChatServer.jar

java -jar ChatClient.jar


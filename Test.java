import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** 
 * Test is used to communicate between Clients through ChatServer
 * @author Andrew Diana
 * @version 4-2-16
 */
public class Test extends JFrame {
 
   public static void main(String[] args){
       //Test c1 = new Test();
       ChatClient c1 = new ChatClient();
       JFrame frame = new JFrame();
       frame.add(c1); // Add JPanel with components to JFrame
       frame.setSize(300,300);
       frame.setVisible(true);
       
   }

 
}
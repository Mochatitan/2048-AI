import java.awt.AWTException;   
import java.awt.Robot;   
import java.awt.event.KeyEvent;   
import java.io.*;   
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Desktop;
import java.net.URI;
import java.util.Random;

public class Main
{   
    static JFrame frame;

    static TextField x, y;

    Main(){
        //constructor
    }

public static void main(String args[]) throws IOException, AWTException, InterruptedException, Exception  
{   

Desktop desk = Desktop.getDesktop();

//default browser
desk.browse(new URI("https://play2048.co/")); 
try   
{   
//delay 4ms  
Thread.sleep(14000);   
}   
catch (InterruptedException e)   
{   

e.printStackTrace();   
}   

//loops over and over and over and over and over and over and over and over and over and over and over
for(var m = 9;m<1000;m++){


brainOfRobot();}





}
   
   
public static void click(int x, int y) throws AWTException{

    Robot bot = new Robot();
    bot.mouseMove(x,y);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    System.out.println("clicked");
}

public static void brainOfRobot() throws InterruptedException, AWTException{
    Robot roboto = new Robot();
    Random random = new Random(); 

    for(var x = 0;x<1000;x++){

        int rand = 0;
        while(true){
            rand=random.nextInt(5);
            if(rand!=0){break;}
        }   
        switch(rand){
            case 1:
            //up
            roboto.keyPress(KeyEvent.VK_UP);   
            Thread.sleep(20); 
            break;
            case 2:
        //right
        roboto.keyPress(KeyEvent.VK_RIGHT);   
        Thread.sleep(20); 
            break;
            case 3:
        //down
        roboto.keyPress(KeyEvent.VK_DOWN);   
        Thread.sleep(20); 
            break;
            case 4:
        //left
        roboto.keyPress(KeyEvent.VK_LEFT);   
        Thread.sleep(20); 
            break;
            default:
            System.out.println("error lol");
            
        }
        var a = roboto.getPixelColor(950,580);
System.out.println(a.getRed()+"   "+a.getGreen()+"    "+a.getBlue());
if(a.getRed() == 143 && a.getGreen() == 122 && a.getBlue() == 102){x=1001;}
}

  
 
Thread.sleep(1000);



click(950,580);
roboto.delay(1000);
}



}   
  
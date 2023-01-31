import java.awt.AWTException;   
import java.awt.Robot;   
import java.awt.event.KeyEvent;   
import java.io.*;   
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller
{   
    static JFrame frame;

    static TextField x, y;

    Controller(){
        //constructor
    }


   
   
public static void click(int x, int y) throws AWTException{

    Robot bot = new Robot();
    bot.mouseMove(x,y);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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

public List<Integer> getBlocks(){
    List<Integer> blocks = new ArrayList<Integer>(16);
    //0 = 205 193 180
    //2 = 238 228 218
    //4 = 238 225 201
    //8 = 243 178 122
    //16 = 246 150 100
    //32 = 247 124 95
    //64 = 247 95 59
    //128 = 237 208 115
    //256 237 204 98

        //x 720
        //x 840
        //x 960
        //x 1080

        //y 320
        //y 440
        //y 560
        //y 680

        // for(var)

   return blocks;
}

public void launchGame() throws IOException, URISyntaxException{
Desktop desk = Desktop.getDesktop();
//default browse
desk.browse(new URI("https://play2048.co/")); 
}
}   
  
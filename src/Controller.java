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
    public final static int MOVE_INTERVAL = 10000;

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
   
    // String direction = getDirection();
    
    Robot roboto = new Robot();
    Random random = new Random(); 

    for(var x = 0;x<1000;x++){
        String direction = getDirection();
        int rand = 0;
        while(true){
            rand=random.nextInt(3);
            if(rand!=0){break;}
        }   

        if(direction=="Up"){
            if(rand==1){roboto.keyPress(KeyEvent.VK_DOWN);}
                     else{roboto.keyPress(KeyEvent.VK_UP);}
            Thread.sleep(MOVE_INTERVAL); 

        }else if(direction =="Right"){
            if(rand==1){roboto.keyPress(KeyEvent.VK_RIGHT);}
                     else{roboto.keyPress(KeyEvent.VK_LEFT);}
            Thread.sleep(MOVE_INTERVAL); 
        }else{
            int rando = 0;
            while(true){
                rando=random.nextInt(5);
                if(rando!=0){break;}
            }   
        

        switch(rando){


            case 1:
                //up
                roboto.keyPress(KeyEvent.VK_UP);   
                Thread.sleep(MOVE_INTERVAL); 
            break;


            case 2:
                //right
                roboto.keyPress(KeyEvent.VK_RIGHT);   
                Thread.sleep(MOVE_INTERVAL); 
            break;


            case 3:
                //down
                roboto.keyPress(KeyEvent.VK_DOWN);   
                Thread.sleep(MOVE_INTERVAL); 
            break;


            case 4:
                //left
                roboto.keyPress(KeyEvent.VK_LEFT);   
                Thread.sleep(MOVE_INTERVAL); 
            break;






            default:
            System.out.println("error lol");
            
        }

        }

        var a = roboto.getPixelColor(950,580);
// System.out.println(a.getRed()+"   "+a.getGreen()+"    "+a.getBlue());
if(a.getRed() == 143 && a.getGreen() == 122 && a.getBlue() == 102){x=1001;}
}

  
 
Thread.sleep(1000);



click(950,580);
roboto.delay(1000);
}

public static List<Integer> getBlocks() throws AWTException{
    List<Integer> blocks = new ArrayList<Integer>(16);
    Robot john = new Robot();
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

        for(var x=0; x<4; x++){
            for(var y=0; y<4; y++){
                var b = john.getPixelColor(720+(x*120),320+(y*120));
                
                switch(b.getBlue()){

                    case 180:
                        blocks.add(0);
                        break;

                    case 218:
                        blocks.add(2);
                        break;

                    case 201:
                        blocks.add(4);
                        break;

                    case 122:
                        blocks.add(8);
                        break;

                    case 100:
                        blocks.add(16);
                        break;

                    case 95:
                        blocks.add(32);
                        break;

                    case 59:
                        blocks.add(64);
                        break;

                    case 115:
                        blocks.add(128);
                        break;

                    case 98:
                        blocks.add(256);
                        break;

                    default:
                        blocks.add(69);

                    }

                }
        }
        
            return blocks;
        

  
}

public static String getDirection() throws AWTException{
    String direction = "RANDOM";
    List<Integer> blocksList = getBlocks();
    int verticalScore = 0;
    int horizontalScore = 0;
    

    //define rows/columns
    List<Integer> columnOne = blocksList.subList(0, 4);
    List<Integer> columnTwo = blocksList.subList(4, 8);
    List<Integer> columnThree = blocksList.subList(8, 12);
    List<Integer> columnFour = blocksList.subList(12, 16);

    List<Integer> rowOne = new ArrayList<Integer>(4);
    rowOne.set(0, blocksList.get(0));
    rowOne.set(1, blocksList.get(4));
    rowOne.set(2, blocksList.get(8));
    rowOne.set(3, blocksList.get(12));

    List<Integer> rowTwo = new ArrayList<Integer>(4);
    rowTwo.set(0, blocksList.get(1));
    rowTwo.set(1, blocksList.get(5));
    rowTwo.set(2, blocksList.get(9));
    rowTwo.set(3, blocksList.get(13));

    List<Integer> rowThree = new ArrayList<Integer>(4);
    rowThree.set(0, blocksList.get(2));
    rowThree.set(1, blocksList.get(6));
    rowThree.set(2, blocksList.get(10));
    rowThree.set(3, blocksList.get(14));

    List<Integer> rowFour = new ArrayList<Integer>(4);
    rowFour.set(0, blocksList.get(3));
    rowFour.set(1, blocksList.get(7));
    rowFour.set(2, blocksList.get(11));
    rowFour.set(3, blocksList.get(15));

    //get vertical score
    if(columnOne.get(3)==columnOne.get(2)){verticalScore+=columnOne.get(3)*2;}
    if(columnOne.get(2)==columnOne.get(1)){verticalScore+=columnOne.get(2)*2;}
    if(columnOne.get(1)==columnOne.get(0)){verticalScore+=columnOne.get(1)*2;}

    if(columnTwo.get(3)==columnTwo.get(2)){verticalScore+=columnTwo.get(3)*2;}
    if(columnTwo.get(2)==columnTwo.get(1)){verticalScore+=columnTwo.get(2)*2;}
    if(columnTwo.get(1)==columnTwo.get(0)){verticalScore+=columnTwo.get(1)*2;}

    if(columnThree.get(3)==columnThree.get(2)){verticalScore+=columnThree.get(3)*2;}
    if(columnThree.get(2)==columnThree.get(1)){verticalScore+=columnThree.get(2)*2;}
    if(columnThree.get(1)==columnThree.get(0)){verticalScore+=columnThree.get(1)*2;}

    if(columnFour.get(3)==columnFour.get(2)){verticalScore+=columnFour.get(3)*2;}
    if(columnFour.get(2)==columnFour.get(1)){verticalScore+=columnFour.get(2)*2;}
    if(columnFour.get(1)==columnFour.get(0)){verticalScore+=columnFour.get(1)*2;}

    //get horizontal score
    if(rowOne.get(3)==rowOne.get(2)){horizontalScore+=rowOne.get(3)*2;}
    if(rowOne.get(2)==rowOne.get(1)){horizontalScore+=rowOne.get(2)*2;}
    if(rowOne.get(1)==rowOne.get(0)){horizontalScore+=rowOne.get(1)*2;}

    if(rowTwo.get(3)==rowTwo.get(2)){horizontalScore+=rowTwo.get(3)*2;}
    if(rowTwo.get(2)==rowTwo.get(1)){horizontalScore+=rowTwo.get(2)*2;}
    if(rowTwo.get(1)==rowTwo.get(0)){horizontalScore+=rowTwo.get(1)*2;}

    if(rowThree.get(3)==rowThree.get(2)){horizontalScore+=rowThree.get(3)*2;}
    if(rowThree.get(2)==rowThree.get(1)){horizontalScore+=rowThree.get(2)*2;}
    if(rowThree.get(1)==rowThree.get(0)){horizontalScore+=rowThree.get(1)*2;}

    if(rowFour.get(3)==rowFour.get(2)){horizontalScore+=rowFour.get(3)*2;}
    if(rowFour.get(2)==rowFour.get(1)){horizontalScore+=rowFour.get(2)*2;}
    if(rowFour.get(1)==rowFour.get(0)){horizontalScore+=rowFour.get(1)*2;}

    


    //get direction
    if(verticalScore>=horizontalScore){
        direction="Up";
    } else{
        direction="Right";
    }
    System.out.println(verticalScore);
    System.out.println(horizontalScore);

    return direction;
}



public void launchGame() throws IOException, URISyntaxException{
Desktop desk = Desktop.getDesktop();
//default browse
desk.browse(new URI("https://play2048.co/")); 
}
}   
  
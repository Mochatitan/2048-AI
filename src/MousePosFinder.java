import java.awt.AWTException;
import java.awt.Point;
import java.awt.MouseInfo;


public class MousePosFinder {

    MousePosFinder(){

    }

   

    public static void main(String[] args) throws AWTException{
        
        
        Point p = MouseInfo.getPointerInfo().getLocation();
        while(true){
        p = MouseInfo.getPointerInfo().getLocation();
        // System.out.println(ro.getPixelColor(p.x, p.y));
        System.out.println("X: "+p.x+"    Y: "+p.y);
        
        }







    }
}

/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;
import edu.princeton.cs.introcs.*;
import java.util.Scanner; 
import java.io.*; 
/**
 *
 * @author 
 */
public class PoliticalMap {
    public static void main(String[] args) throws Exception{
//***********Variable Declarations **************************//
        double coordinates;
        File USA = new File("USA.txt"); 
        Scanner scan = new Scanner(System.in); 
        System.out.print(USA);
//*********************Public Methods**********************// 
        StdDraw.setCanvasSize(1000,1000);//sets the size of the window 
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5); 
      //  StdDraw.polygon(x, y);
//*******************Private Methods***********************//
         
          
    }
}

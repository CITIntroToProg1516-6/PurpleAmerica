/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.introcs.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author hcps-pendyals
 */
public class white {
    private static ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    private static Coordinate minCoord;
    private static Coordinate maxCoord;
    
    public static void main(String[] args) {
        String fileName = "USA.txt";
        String line = null;
       try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
                
            int i=0;

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                line = line.trim();
                String[] values = line.split("  ");
                
                
                if (i==0) {
                    System.out.println("Min long: " + values[0].trim());
                    System.out.println("Min lat: " + values[1].trim());
                    minCoord = new Coordinate(values[0].trim(), values[1].trim());
                } else if (i==1) {
                    System.out.println("Max long: " + values[0].trim());
                    System.out.println("Max lat: " + values[1].trim());
                    maxCoord = new Coordinate(values[0].trim(), values[1].trim());
                }
                
                i++;
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  

        }  
       
        
        
        
        StdDraw.setCanvasSize(1000,1000);//sets the size of the window
         
    StdDraw.setCanvasSize(1000,1000);
    StdDraw.setPenRadius(.02);
    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
    double[] x = { .1, .2, .3, .2 };
    double[] y = { .2, .3, .2, .1 };
    StdDraw.filledPolygon(x, y);
    
    
    StdDraw.setPenRadius(.003);
    StdDraw.setPenColor(StdDraw.BLACK);
    double[] xx = { .1, .2, .3, .2 };
    double[] yy = { .2, .3, .2, .1 };
    StdDraw.polygon(xx, yy);
    
    
            
            
    }
    
}
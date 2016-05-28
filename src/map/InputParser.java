/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.awt.Color;
import java.util.Scanner;


/**
 *
 * @author hcps-taylorsd
 */
import java.io.File;
import java.io.FileNotFoundException;
public class InputParser {
    
    
    
    
    Coordinate max; // this holds the largest  coordinate value for the bounding box 
    Coordinate min; // this holds the smallest coordinate value for the bounding box
    int numPoints; //this value is decided in pointFinder() and tells the program how many points to read
    int numCounty; // this value is decided in pointFinder() and tells the program how many counties are in the file
    Coordinate[] points; //this is an array of coordinates that hold all the coordinates in a state's document and is filled in pointFinder()
    Scanner scan; //this is the scanner used to read the file and all the values the selected file holds
    Votes[] total;
    String vLine;
    String[] votes;
    /*
    *  This constructor allows the program to read files using a scanner.
    *
    * @param    state   holds the file that will be read into the program so it can gather data
    *
    */
    public InputParser(String state) throws Exception{
        
        scan = new Scanner(new File("src\\data\\" + state +".txt") );
        
    }
    
    //This method is used to all of the points within a single county
    Coordinate[] pointFinder(boolean albersSelected, int year) throws FileNotFoundException{
                
            double minX = scan.nextDouble();
            double minY = scan.nextDouble();
            double maxX = scan.nextDouble();
            double maxY = scan.nextDouble();
            numCounty = scan.nextInt();

            for(int x = 0; x < numCounty; x++){
                scan.nextLine();
                scan.nextLine();
                scan.nextLine();
                scan.nextLine();
                numPoints = scan.nextInt();
                points = new Coordinate[numPoints];

                for(int i = 0; i < numPoints; i ++){

                        double a = scan.nextDouble();
                        double b = scan.nextDouble();
                        points[i] = new Coordinate(a, b);  


                }
                
                findVotes(year);
                FillColor fill = new FillColor();
                Color[] purple = fill.draw(total);
                LineDrawer drawer = new LineDrawer(points, numPoints, minX, minY, maxX, maxY, purple);
                
                if(albersSelected){
                   drawer.drawAlbers(); 
                }//end if
                else{
                    drawer.draw();
                }//end else
                

            }


        return points;
    }
    
        /*
        * Finds the biggest coordinate values in order to create a point for the bounding box of a region
        *
        * @return Coordinate max
        */
         Coordinate getMax(){
                 
             double a = scan.nextDouble();
             double b = scan.nextDouble();
             max = new  Coordinate(a, b);
             
             return max;
         }
         
         /*
         * Finds the smallest coordinate values in order to create a point for the bounding box of a region 
         * 
         * @return Coordinate min
         */
         
         Coordinate getMin(){
             
             double c = scan.nextDouble();
             double d = scan.nextDouble();
             min = new Coordinate(c, d);
             
             return min;
         }
       
         Votes[] findVotes(int year) throws FileNotFoundException{
            Scanner scanYr = new Scanner(new File("src\\data\\"+year+".txt"));
            scanYr.nextLine();
            int i = 0;
            while(scanYr.hasNextLine()){
                    
                    vLine = scanYr.nextLine(); 
                    votes = vLine.split(",", 4);
                    int rep = Integer.parseInt(votes[1]);
                    int dem = Integer.parseInt(votes[2]);
                    int oth = Integer.parseInt(votes[3]);
                    Votes results = new Votes(rep, dem, oth);
                    total[i] = results;
                    i++;
            }
         return total;
        }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;
import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
/**
 *
 * @author hcps-davidsoqs
 */
public class StateDraw {
            //global variables for the color of the states

    public static double red = 0.0;
    public static double green = 0.0;
    public static double blue = 0.0;
    
    public static void drawState(File stateName, File year, int byState, String state, boolean scale) throws Exception{
        int numCounties;
        int numPoints;
        //double arrays that hold the coords for the map
        double[] pointAryX;
        double[] pointAryY;
        
              
        double sum = 0.0;
        
        Scanner scan = new Scanner(stateName); //instantiating a new scanner
        Scanner pollScan = new Scanner(year); //instantiating a new scanner
        scan.nextLine();//reading through the data
        scan.nextLine();
        numCounties = scan.nextInt();
        String lastCounty = "";
        //loop to scan through the data for the states
        for(int x = 0; x < numCounties; x++){ //start of for loop
            scan.nextLine();
            scan.nextLine();
            String nextCounty = scan.nextLine();
            scan.nextLine();
            numPoints = scan.nextInt();
            scan.nextLine();
            
            pointAryX = new double[numPoints];
            pointAryY = new double[numPoints];
            
//            double xshift = 0;
//            double yshift = 0;
//            if(scale==true){
//                
//                for (int i = 0; i < numPoints; i++) { //start of for loop
//                    double xcoord = scan.nextDouble();
//                    double ycoord = scan.nextDouble();
//                    if(i==0){
//                        xshift = xcoord-.5; //shift to diplay in middle
//                        yshift = ycoord-.5; //same
//                    }
//                    
//                    pointAryX[i] = (((xcoord + 124.731216) / 60) + .03) - xshift;
//                    pointAryY[i] = (((ycoord - 24.544102) / 30) + .03) - yshift;
//                } //end of for loop
//            }else{
//                for (int i = 0; i < numPoints; i++) { //start of for loop
//                    pointAryX[i] = (((scan.nextDouble() + 124.731216) / 60) + .03);
//                    pointAryY[i] = (((scan.nextDouble() - 24.544102) / 30) + .03);
//                } //end of for loop
//            
            if(byState == 1){
                for(int i = 0; i < numPoints; i++){
                   // System.out.println(numPoints);
                    pointAryX[i] = (((scan.nextDouble() + 124.731216)/ 60) + .03);
                    pointAryY[i] = (((scan.nextDouble() - 24.544102)/ 30) + .03);
                }
            }
            else{
                double pointX;
                double pointY;
                for(int i = 0; i < numPoints; i++){
                    pointX = scan.nextDouble();
                    pointY = scan.nextDouble();
                    
                    if(state.toUpperCase().equals("AK")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) - .2);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .2);
                    }
                    else if(state.toUpperCase().equals("AL")){
                        pointAryX[i] = (((pointX + 124.731216)/ 16) - 1.9);
                        pointAryY[i] = (((pointY - 24.544102)/ 8) - .5);
                    }
                    else if(state.toUpperCase().equals("AR")){
                        pointAryX[i] = (((pointX + 124.731216)/ 10) - 2.7);
                        pointAryY[i] = (((pointY - 24.544102)/ 5) - 1.5);
                    }
                    else if(state.toUpperCase().equals("AZ")){
                        pointAryX[i] = (((pointX + 124.731216)/ 16) - .4);
                        pointAryY[i] = (((pointY - 24.544102)/ 8) - .7);
                    }
                    else if(state.toUpperCase().equals("CA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 24) + .3);
                        pointAryY[i] = (((pointY - 24.544102)/ 12) - .5);
                    }
                    else if(state.toUpperCase().equals("CO")){
                        pointAryX[i] = (((pointX + 124.731216)/ 12) - 1.1);
                        pointAryY[i] = (((pointY - 24.544102)/ 6) - 1.85);
                    }
                    else if(state.toUpperCase().equals("CT")){
                        pointAryX[i] = (((pointX + 124.731216)/ 12) - 3.8);
                        pointAryY[i] = (((pointY - 24.544102)/ 6) - 2.2);
                    }
                    else if(state.toUpperCase().equals("DC")){
                        pointAryX[i] = (((pointX + 124.731216)/ 10) - 4.3);
                        pointAryY[i] = (((pointY - 24.544102)/ 5) - 2.1);
                    }
                    else if(state.toUpperCase().equals("DE")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("FL")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("GA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("HI")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("IA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("ID")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("IL")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("IN")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("KS")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("KY")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("LA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MD")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("ME")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MI")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MN")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MO")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MS")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("MT")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NC")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("ND")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NE")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NH")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NJ")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NM")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NV")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("NY")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("OH")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("OK")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("OR")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("PA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("RI")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("SC")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("SD")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("TN")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("TX")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("USA")){
                        pointAryX[i] = (((scan.nextDouble() + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((scan.nextDouble() - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("UT")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("VA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 14) - 2.7);
                        pointAryY[i] = (((pointY - 24.544102)/ 7) - 1.3);
                    }
                    else if(state.toUpperCase().equals("VT")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("WA")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("WI")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("WV")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                    else if(state.toUpperCase().equals("WY")){
                        pointAryX[i] = (((pointX + 124.731216)/ 60) + .03);
                        pointAryY[i] = (((pointY - 24.544102)/ 30) + .03);
                    }
                }
            }
            
            if(!nextCounty.equals(lastCounty)){
                pollScan.nextLine();
                String poll = pollScan.next();
                //System.out.println(poll);
                while(poll.length() < 10){ //start of while loop
                    poll = pollScan.next();
                }//end of while loop
                poll = poll.replaceAll(",", " ");       // replaces all the commas in the data to a space so that the scanner can read through them


                Scanner stringScan = new Scanner(poll);//instantiating a new scanner
                stringScan.next();
                //giving poll data to the variables
                red = stringScan.nextInt();
                blue = stringScan.nextInt();
                green = stringScan.nextInt();
                //making a sum for the purple america formula
                sum = red + blue + green;
                lastCounty = nextCounty;
            }
            //methods to draw the states, counties, and color the mape in            
            StdDraw.setPenColor((int)(((red/sum) * 100) + 40), (int)(((green/sum) * 100) + 40), (int)(((blue/sum) * 100)) + 40); 
            StdDraw.filledPolygon(pointAryX, pointAryY);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.polygon(pointAryX, pointAryY);
        } //end of for loop
    }
}
//}
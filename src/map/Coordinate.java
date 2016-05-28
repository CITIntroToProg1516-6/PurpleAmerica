/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.util.Scanner;

/**
 *
 * @author hcps-taylorsd
 */
public class Coordinate {
    
    double lat; //the x value of the coordinate that is taken from the state file 
    double lon; //the y value of the coordinate that is taken from the state file
 
    /*
    * This constructor creates a coordinate that holds the x and y value on each line of the file
    *
    *@param double x value
    *@param double y value
    */

    Coordinate (double x, double y){
        
        lat = x;
        lon =y;
        
    }
    
    /*
    * This method is a getter that takes the x value from coordinates
    * @return double this is the latitude from the coordinate object
    */
    
    public double getX(){
        
        return lat;
        
    }
    
       /*
    * This method is a getter that takes the y value from coordinates
    * @return double this is the longitude from the coordinate object
    */
    
    public double getY(){
        
        return lon; 
        
    }
    
       /*
    * This is a toString() that prints out the two coordinate object values
    * @return double this is the latitude and longitude values from the coordinate object
    */
    
    public String toString(){
        String str = "";
        
        str += lat;
        str+= " " + lon;
        
        return str;
    }
    
}

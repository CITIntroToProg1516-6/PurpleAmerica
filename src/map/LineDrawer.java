/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;
import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author hcps-mabrysh
 */
public class LineDrawer {
    
    //*******************Variables******************
    Coordinate[] coords; //coordinates of the county/state being drawn
    int points; //the number of coordinates
    double[] xcoords; //x coordinates of the county/state being drawn
    double[] ycoords; //y coordinates of the county/state being drawn
    double[] xcoordsAlbers;//x coordinates in Albers Equal-Area conic projection
    double[] ycoordsAlbers;//y coordinates in Albers Equal-Area conic projection
    double xMax; //max x value of bounding box
    double xMin; //min x value of bounding box
    double yMax; //max y value of bounding box
    double yMin; //min y value of bounding box
    double xMaxAlbers; //max x value of Albers bounding box
    double xMinAlbers; //min x value of Albers bounding box
    double yMaxAlbers; //max y value of Albers bounding box
    double yMinAlbers; //min y value of Albers bounding box
    double x; //x Albers coordinate
    double y; //y Albers coordinate
    double rho; //variable for converting to Albers projection
    double rho0; //variable for converting to Albers projection
    double theta; //variable for converting to Albers projection
    double n; //variable for converting to Albers projection
    double c; //variable for converting to Albers projection
    double lambda; //variable for converting to Albers projection
    double lambda0; //variable for converting to Albers projection
    double phi; //variable for converting to Albers projection
    double phi0; //variable for converting to Albers projection
    double phi1; //variable for converting to Albers projection
    double phi2; //variable for converting to Albers projection    
    Color[] purple; //array of colors
          
    //******************Constructor*****************
    public LineDrawer(Coordinate[] c, int dots, double minx, double miny, double maxx, double maxy, Color[] pur){
        points = dots;
        coords = new Coordinate[points];
        coords = c;
        xcoords = new double[points];
        ycoords = new double[points]; 
        xcoordsAlbers = new double[points];
        ycoordsAlbers = new double[points];
        xMax = maxx;
        xMin = minx;
        yMax = maxy;
        yMin = miny;
        lambda0 = 0;
        phi0 = 0;
        phi1 = -60;
        phi2 = 0;
        purple = pur;
    }
    
    //*****************Public Methods****************
    
    /*
    Converts the Mercator coordinates into Albers
    */
    public void convertCoords(){
        for(int i = 0; i < xcoords.length; i++){ 
            lambda = coords[i].getX(); //lambda is x
            phi = coords[i].getY(); //phi is y
            n = .5*(Math.sin(phi1)+Math.sin(phi2)); //bunch of equations used to convert the coordinates
            theta = n*(lambda-lambda0);
            c = Math.pow(Math.cos(phi1), 2)+ 2*n*Math.sin(phi1);
            rho = (Math.sqrt(c-(2*n*Math.sin(phi))))/n;
            rho0 = (Math.sqrt(c-(2*n*Math.sin(phi0))))/n;
            x = rho*Math.sin(theta);
            y = rho0 - rho*Math.cos(theta);
            xcoordsAlbers[i] = x; //sets x and y equal to the Albers converted x and y
            ycoordsAlbers[i] = y;
        }//end for
                
    }//end convertCoords
    
    /*
    Converts the minimum bounding box Mercator coordinates into Albers
    */
    public void convertMin(){
        lambda = xMin; //lambda is x
        phi = yMin; //phi is y
        n = .5*(Math.sin(phi1)+Math.sin(phi2)); //bunch of equations used to convert the coordinates
        theta = n*(lambda-lambda0);
        c = Math.pow(Math.cos(phi1), 2)+ 2*n*Math.sin(phi1);
        rho = (Math.sqrt(c-(2*n*Math.sin(phi))))/n;
        rho0 = (Math.sqrt(c-(2*n*Math.sin(phi0))))/n;
        x = rho*Math.sin(theta);
        y = rho0 - rho*Math.cos(theta);
        xMinAlbers = x;
        yMinAlbers = y;
                
    }//end convertMin
        
    /*
    Converts the maximum bounding box Mercator coordinates into Albers
    */
    public void convertMax(){        
        lambda = xMax; //lambda is x
        phi = yMax; //phi is y
        n = .5*(Math.sin(phi1)+Math.sin(phi2)); //bunch of equations used to convert the coordinates
        theta = n*(lambda-lambda0);
        c = Math.pow(Math.cos(phi1), 2)+ 2*n*Math.sin(phi1);
        rho = (Math.sqrt(c-(2*n*Math.sin(phi))))/n;
        rho0 = (Math.sqrt(c-(2*n*Math.sin(phi0))))/n;
        x = rho*Math.sin(theta);
        y = rho0 - rho*Math.cos(theta);
        xMaxAlbers = x;
        yMaxAlbers = y;
                
    }//end convertMax
        
    /*
    Draws the counties/states
    */
    public void draw(){
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);
        for(int n = 0; n < points; n++){
            xcoords[n] = coords[n].getX(); //takes the x coordinate from each coordinate
            ycoords[n] = coords[n].getY(); //takes the y coordinate from each coordinate
        }//end for loop
        
        for(int i = 0; i < points; i++){
            StdDraw.setPenRadius(.005);
            FillColor paint = new FillColor();
            StdDraw.setPenColor(purple[i]);
            StdDraw.filledPolygon(xcoords, ycoords);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.polygon(xcoords, ycoords); //draws a polygon with the x and y coordinates w/ .005 radius and the color black
        }//end for loop        
    }//end draw
    
    /*
    Draws the counties/states in Albers projection.
    */
    public void drawAlbers(){
        convertMin();
        convertMax();
        StdDraw.setXscale(xMinAlbers, xMaxAlbers);
        StdDraw.setYscale(yMinAlbers, yMaxAlbers);
        convertCoords();//calls the convert coordinates function to convert from Mercator to Albers
        
        for(int i = 0; i < points; i++){
            StdDraw.setPenRadius(.005);
            FillColor paint = new FillColor();
            StdDraw.setPenColor(purple[i]);
            StdDraw.filledPolygon(xcoordsAlbers, ycoordsAlbers);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.polygon(xcoordsAlbers, ycoordsAlbers); //draws a polygon with the Albers x and y coordinates w/ .005 radius and the color black
        }//end for loop        
    }//end draw
    
}//close class

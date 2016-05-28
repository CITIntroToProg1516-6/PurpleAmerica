/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 *
 * @author hcps-taylorsd
 */

public class StateNamer  {
    
         Coordinate max;
         Coordinate min;
         double maxX;
         double maxY;
         double minX;
         double minY;
         double width; 
         double height;
         double centerX;
         double centerY;
         Coordinate center; 
            
        StateNamer(String name) throws Exception{
            String stateN = name;
            InputParser state = new InputParser(stateN);
            
             max = state.getMax();
             min = state.getMin();
            
            //use max + min to find center of shape by using a formula
            //1st find the bounding box
            //2nd find the center of the box
                    // take the x values to find the total length 
                    // and the y values for the total height 
            //3rd use those to make a new coordinate of the center so that the name will be loacted there
            
             maxX = max.getX();
             maxY = max.getY();
             minX = max.getX();
              minY = min.getY();
             
              width = maxX - minX;
              height = maxY - minY;
             
              centerX = width/2;
              centerY = height/2;
             
              center = new Coordinate(centerX, centerY);
        }
             
             
            
    
    
    
    
    
    
    
}

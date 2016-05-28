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
public class State {
    
    Coordinate [] vertices;
    Coordinate centroid;
    String name;
    String abbrev;
    
    State(Coordinate[] v, String n){
        
        vertices = v;
        name = n;
        //centroid = findCentroid(v);
        //abbrev = findAbbrev(n);
        
        
    }       
    
    
    /*private Coordinate findCentroid(Coordinate[] v){
        
        //takes average of x + y values in order to find the centeroid coordinate
    }
    
    private String findAbbrev(String n){
        
        //checks if state exsits in order to make the proper abbrev. 
    }
    
    public void drawAbbrev(){
        
        
    }*/
    
    
}

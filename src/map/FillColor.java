/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;
import edu.princeton.cs.introcs.*;
import java.awt.Color;

/**
 *
 * @author hcps-kamencinb
 */
public class FillColor {
    
    @SuppressWarnings("empty-statement")
    Color map;
    int rep;//will be republicans for every county and state
    int dem;//wil be democrats for every country and state
    int other;//will be third party or non voting
    Color[] purpleShades;
    
    public Color[] draw(Votes[] colors){
      for(int i = 0; i < colors.length; i++){
          rep = colors[i].getRep();
          other = colors[i].getOth();
          dem = colors[i].getDem(); 
          map = new Color((rep/(rep+dem+other)),(dem/(rep+dem+other)),(other/(rep+dem+other)));//makes an rgb color of how all 3 ints relate to one another
          purpleShades[i] = map;
      }//end for
      return purpleShades;
    }
                                                                                                                                                                                        
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hcps-vizdosdj
 */
public class VoteColor {
    public static int r;
    public static int g;
    public static int b;
    
    public static void getStateColor(){
    Scanner scan = new Scanner(System.in);
    String fileName = ("USA2012.txt");
    File in = new File(fileName);   //read in UT text file
    
    
    while (scan.hasNext()) {
        String line = scan.next();
        String[] values = lines.split(",");
        String stateName = values[0];
        int repub = Integer.parseInt(values[1]);
        int lib = Integer.parseInt(values[2]);
        int unpledged = Integer.parseInt(values[3]);
        
        r = (repub/(repub+lib+unpledged));
        g = (unpledged/(repub+lib+unpledged));
        b = (lib/(repub+lib+unpledged));
           
    }
}
}
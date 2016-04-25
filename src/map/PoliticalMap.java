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
import java.util.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author 
 */
public class PoliticalMap {
    public static void main(String[] args) throws Exception{
        StdDraw.setCanvasSize(700,700);
        
        File[] fileAry = new File[51];
        fileAry[0] = new File(PoliticalMap.class.getResource("/data/USA.txt").toURI());
        
        for(int i = 0; i < 1; i++){
            StateDraw.drawState(fileAry[i]);
            
        }
    }
}

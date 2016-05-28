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
import java.io.*;
import java.util.*;

public class Votes {
    
        int democrat;
        int republican;
        int other;        
        String cName;
        
        Votes(int rep, int dem , int oth){
            
             democrat = dem;
             republican = rep;
             other = oth;
             
            
        }
        
        
        int getDem(){
            
            return democrat; 
            
        }
        
        int getRep(){
            
            return republican; 
        }
        
        int getOth(){
            
            return other; 
        }
        
        String splitVotes(){
            
            
            
            
            
            return cName;
        }
        
    
    
}

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
    public static String[] stateNameAry = new String[51]; //holds the names of the states
    public static int year = 0;
    public static void main(String[] args) throws Exception{
                //makes the canvas on which the points will be mapped onto

        StdDraw.setCanvasSize(1300,600);
        
        
                //elements of the array for the states of the US

        stateNameAry[0] = "AK";
        stateNameAry[1] = "AL";
        stateNameAry[2] = "AR";
        stateNameAry[3] = "AZ";
        stateNameAry[4] = "CA";
        stateNameAry[5] = "CO";
        stateNameAry[6] = "CT";
        stateNameAry[7] = "DC";
        stateNameAry[8] = "DE";
        stateNameAry[9] = "FL";
        stateNameAry[10] = "GA";
        stateNameAry[11] = "HI";
        stateNameAry[12] = "IA";
        stateNameAry[13] = "ID";
        stateNameAry[14] = "IL";
        stateNameAry[15] = "IN";
        stateNameAry[16] = "KS";
        stateNameAry[17] = "KY";
        stateNameAry[18] = "LA";
        stateNameAry[19] = "MA";
        stateNameAry[20] = "MD";
        stateNameAry[21] = "ME";
        stateNameAry[22] = "MI";
        stateNameAry[23] = "MN";
        stateNameAry[24] = "MO";
        stateNameAry[25] = "MS";
        stateNameAry[26] = "MT";
        stateNameAry[27] = "NC";
        stateNameAry[28] = "ND";
        stateNameAry[29] = "NE";
        stateNameAry[30] = "NH";
        stateNameAry[31] = "NJ";
        stateNameAry[32] = "NM";
        stateNameAry[33] = "NV";
        stateNameAry[34] = "NY";
        stateNameAry[35] = "OH";
        stateNameAry[36] = "OK";
        stateNameAry[37] = "OR";
        stateNameAry[38] = "PA";
        stateNameAry[39] = "RI";
        stateNameAry[40] = "SC";
        stateNameAry[41] = "SD";
        stateNameAry[42] = "TN";
        stateNameAry[43] = "TX";
        stateNameAry[44] = "UT";
        stateNameAry[45] = "VA";
        stateNameAry[46] = "VT";
        stateNameAry[47] = "WA";
        stateNameAry[48] = "WI";
        stateNameAry[49] = "WV";
        stateNameAry[50] = "WY";
           //instantiating the StateClickListener in the main class     
        StateClickListener listener = new StateClickListener();
        //creates a scanner        
        Scanner scan = new Scanner(System.in);
        boolean isCorrect = false;
        
        int byState = 0;
        //loop to select what year the user would like to see the poll data for        
        while(isCorrect == false){ //start of while loop
            isCorrect = true;
            System.out.print("Enter 1 if you want the whole country by county or 2 if you want a single state: ");
            byState = scan.nextInt();
            
            if(byState <= 0 && byState >= 3){
                isCorrect = false;
                System.out.println("Enter 1 or 2");
            }
        }//end of while loop
        
        isCorrect = false;
        
        while(isCorrect == false){ //start of while loop
            isCorrect = true;
            System.out.print("Enter the year that you want to see the data for (1960 - 2012): ");
            year = scan.nextInt();
            
            if((year % 4 != 0) || year < 1960 || year > 2012){
                isCorrect = false;
                System.out.println("Enter a proper year please");
            }
        }//end of while loop
        listener.start(); //starts the listener 
        //loop to get the data from the files        
        for(int i = 1; i < 51; i++){ //start of for loop
            if(!(i == 11)){
                StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + ".txt").toURI()), new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + year + ".txt").toURI()), byState, "", true); 
            }
        }
        if(byState == 1){
            for(int i = 1; i < 51; i++){
                if(!(i == 11)){
                    StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + ".txt").toURI()), new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + year + ".txt").toURI()), 1,"", false); 
                }
            }
        }
        else{
            String state;
            System.out.print("Enter the abreviation for the state you want or USA for the whole country not by county: ");
            state = scan.next();
            boolean isProper = false;
            
            if(state.length() != 2){
                while(!isProper){
                    System.out.print("Enter a proper abreviation: ");
                    state = scan.next();
                    if(state.length() == 2){
                        isProper = true;
                    }
                }
            }
            
            if(state.equals("USA")){
                StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/USA.txt").toURI()), new File(PoliticalMap.class.getResource("/data/USA" + year + ".txt").toURI()), 1, state, false);
            }
            
            isProper = false;
            
            for(int i = 0; i < 51; i++){
                if(stateNameAry[i].equals(state.toUpperCase())){
                    StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + ".txt").toURI()), new File(PoliticalMap.class.getResource("/data/" + stateNameAry[i] + year + ".txt").toURI()), 2, state, false);
                    isProper = true;
                }
            }
            if(!isProper){
                System.out.println("your didn't enter a proper state abreviation and thus the program won't work");
                System.out.println("restart and use the program correctly");
            }
        }
        
        //the following line is for Quentin's additional feature
        //StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/USA.txt").toURI()), new File(PoliticalMap.class.getResource("/data/USA" + year + "Ages.txt").toURI()));
        
    }
}
/*
 * Political Map Project
 * Name: Sid Chiang
 * Block: 6
 * 
 * Class Purpose: This class holds the methods to run a thread that listens for user
clicks on the map. It establishes a hashmap to determine the borders of the states
and utilizes that data to determine which state the user is clicking on. The thread
also runs in an infinite loop to constantly look for user clicks and stops after 
reciving a single click on a valid state border. The thread has a sleep timer 
to prevent the Java program from crashing. This class dispays the selected state
and the abreviation to that state as well as the poll data for the three political
parties.
 *
 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author hcps-chiangs1
 */
public class StateClickListener extends Thread {
    HashMap<Path2D,String> states; //making a new hasmap
    
    boolean viewingSingleState; //a boolean to control the amount of times a user can click
    
    public StateClickListener() throws Exception{
        //load states into HashMap
        
        viewingSingleState = false; 
        states = new HashMap<>();
        //loop to establish state borders 
        for (String state : PoliticalMap.stateNameAry) { //start of for loop
            File stateName = new File(PoliticalMap.class.getResource("/data/" + state + ".txt").toURI());
        
            Scanner scan = new Scanner(stateName); //instantiating a new scanner
            scan.nextLine();
            scan.nextLine();
            int numCounties = scan.nextInt();
            String lastCounty = "";

            for (int x = 0; x < numCounties; x++) { //start of for loop
                scan.nextLine();
                scan.nextLine();
                String nextCounty = scan.nextLine();
                scan.nextLine();
                int numPoints = scan.nextInt();
                scan.nextLine();

                double[] pointAryX = new double[numPoints];
                double[] pointAryY = new double[numPoints];

                for (int i = 0; i < numPoints; i++) { //start of for loop
                    pointAryX[i] = (((scan.nextDouble() + 124.731216) / 60) + .03);
                    pointAryY[i] = (((scan.nextDouble() - 24.544102) / 30) + .03);
                } //end of for loop
                
                Path2D stateBorder = new Path2D.Double();
                stateBorder.moveTo(pointAryX[0], pointAryY[0]);
                for (int i = 1; i < pointAryX.length; i++) { //start of for loop
                    stateBorder.lineTo(pointAryX[i], pointAryY[i]);
                } //end of for loop
                stateBorder.closePath();
                states.put(stateBorder, state);
            } //end of for loop
        } //end of for loop
        
    }

    @Override
    public void run() { // method to identify where the user has click on the map
        while(true){
            //pauses the thread to prevent the java program from crashing
            try{
               Thread.sleep(10);
            
            
            //check if back button is clicked
            if(viewingSingleState){
                if(StdDraw.isKeyPressed(KeyEvent.VK_BACK_SPACE)){
                    viewingSingleState = false;
                    StdDraw.clear();
                    for (int i = 1; i < 51; i++) { //start of for loop
                        if (!(i == 11)) {
                            StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/" + PoliticalMap.stateNameAry[i] + ".txt").toURI()), new File(PoliticalMap.class.getResource("/data/" + PoliticalMap.stateNameAry[i] + PoliticalMap.year + ".txt").toURI()), 1, "", false);
                        }
                    } //end of for loop
                    
                }
            }
            //checks if state is clicked on
            if(!viewingSingleState && StdDraw.mousePressed()){
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                for (Path2D path : states.keySet()) { //start of for loop
                    
                    if(path.contains(x, y)){
                        String statename = states.get(path);
                        System.out.println("Printing statename: ");
                        System.out.println(statename);
                        drawSingleState(statename);
                        viewingSingleState = true;
                        break; //Andriy informed me that a break would be the best way of writing this click method
                    }
                } //end of for loop
            }
            }catch(Exception e){
            }    
        }
    }
    //method to draw the statw that was clicked on 
    public void drawSingleState(String statename) throws Exception{
        System.out.println("Drawing: "+statename);
        StdDraw.clear(); //clears canvas to display only thr state that was selected
        StdDraw.textRight(.1, .3, statename);
        StdDraw.text(.17, .25, String.valueOf(StateDraw.red) + " Republican Party");
        StdDraw.text(.17, .18, String.valueOf(StateDraw.blue) + " Democratic Party");
        StdDraw.text(.17, .10, String.valueOf(StateDraw.green) + " Other Party");
        StdDraw.show(0);
        
        StateDraw.drawState(new File(PoliticalMap.class.getResource("/data/" + statename + ".txt").toURI()), new File(PoliticalMap.class.getResource("/data/" + statename + PoliticalMap.year + ".txt").toURI()),2,statename, false);
    }
}

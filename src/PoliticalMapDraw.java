/*
 * Political Map Project
 * Name: Lauren Mayer
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
import StdDraw.java;

public class PoliticalMapDraw {
    private int N;
    private int[] votes;
    private int voteTotal;

   public void PoliticalMap(String filename, int year) {
   ReadIn FileReader = new ReadIn(filename+".txt");//I changed this ~lauren
   int[] inPoints = FileReader.readPoints(filename + ".txt");          // read in polygon points from txt file
   int[] inVotes  = FileReader.readVotes(filename + year + ".txt");   // read in votes data from txt file
   N       = inPoints.length;;                             // store total number of polygon points  
   for (int i = 0; i < N; i++) {
     String  candidateName = FileReader.readCandidate();
     int voteCount = inVotes[i];
     voteTotal += voteCount;
     }
    drawMap(inPoints);
    }

   public int getColor(int voteCount) {
   return ((voteCount/voteTotal)*255);  
   }
   
   public void drawMap(int[] aryMapPoints) {
   int numberOfPoints = aryMapPoints.length;  
   for (int i = 0; i < numberOfPoints; i++) {
     //   StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenColor(getColor(votes[i]));
   }    
 } 
 } 
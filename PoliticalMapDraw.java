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

public class PoliticalMapDraw {
    private int N;
    private int[] votes;
    private int voteTotal;

   public void PoliticalMap(String filename, int year) {
   ReadIn inPoints = new ReadIn(filename + ".txt");          // read in polygon points from txt file
   ReadIn inVotes  = new ReadIn(filename + year + ".txt");   // read in votes data from txt file
   N       = inPoints.getPointsNum();                             // store total number of polygon points  
   for (int i = 0; i < N; i++) {
     String  candidateName = ReadIn.read();
     int  voteCount = ReadIn.read();
     votes[i]     = voteCount;
     voteTotal += voteCount;
     }
    }

   public void drawMap() {
   for (int i = 0; i < N; i++) {
   StdDraw.setPenColor(votes[i].getColor());
   regions[i].draw();       
   }    
 } 
 } 
import edu.princeton.cs.introcs.StdDraw;
import java.util.*;
import java.io.*;

public class DrawMap {
//    private static int numOfPts;         // number of boundary points
//    private static double[] Xpts, Ypts;  // the points (x[i], y[i])
    private static double[] aryLongX, aryLatY;  // the points (x[i], y[i])

    // The name of the file to open.
      static String fileName = "USA.txt";   //"AL-AZ-MAP.txt";    //"UTAH-NM-MAP.txt";

      public static void main(String[] args) throws Exception {

       //**  PurpleAmerica  **// 
       //** Read file and store Long, Lat values as X, Y values in arrays  **//
   //   File in = new File ("USA.txt");
      File in = new File(fileName);   //read in UT text file
      Scanner scan = new Scanner(in);
      
        System.out.println(fileName); //debug show variable on console
     // System.setOut(new PrintStream(out));

        double xmin=scan.nextDouble();
        double ymin=scan.nextDouble();
        double xmax=scan.nextDouble();
        double ymax=scan.nextDouble();
        int numberOfUSAregions=scan.nextInt();
     //   int numberOfSubregions=scan.nextInt();
        String stateName;
        boolean manyStateNames=true;
        String countryName;
        int numberOfSubregions;

        System.out.println("xmin="+xmin); //debug show variable on console
        System.out.println("xmax="+xmax); //debug show variable on console
        System.out.println("ymin="+ymin); //debug show variable on console
        System.out.println("ymax="+ymax); //debug show variable on console
        
        //System.out.println(scan.nextLine());//copies stuff in input.txt and creates a new file called output.txt
                                             //when you put input.txt output.txt in the Run Arguments bar

//    double[] aryLongX = new double[numberOfSubregions];
//    double[] aryLatY = new double[numberOfSubregions];

      setupMap();     //setupMap() method calls StdDraw.setCanvasSize and draws title 
        
      while(scan.hasNext()){
        stateName=scan.next();
        if (stateName==""){stateName=scan.nextLine();}
        System.out.println(stateName); //debug show variable on console
     System.out.println("about to scan country"); //debug show variable on console
    // System.out.println(scan.next()); //debug show variable on console
        countryName=scan.next();
        System.out.println(countryName); //debug show variable on console
        manyStateNames=true;
        while(manyStateNames==true){
          if (countryName.equals("USA")){
            System.out.println("Country is USA = "+countryName); //debug show variable on console
            manyStateNames=false;  //set flag to false because country is USA so now ok to leave while loop and continue
          }else{
            stateName=stateName+" "+countryName;
            countryName=scan.next();
            manyStateNames=true;  //set flag to true because country was NOT USA so state has many names
            System.out.println("State now= "+stateName); //debug show variable on console
            System.out.println("Country now= "+countryName); //debug show variable on console
          }
        }
        numberOfSubregions=scan.nextInt();
        System.out.println(numberOfSubregions); //debug show variable on console

        aryLongX = new double[numberOfSubregions];
        aryLatY = new double[numberOfSubregions];

        //put X,Y coordinates in arrays
        for(int i=0;i<numberOfSubregions;i++){  
//        System.out.println(scan.next()); //show next on console
          aryLongX[i] = scan.nextDouble();
          aryLatY[i]  = scan.nextDouble();
        }

        System.out.println("finished loading arrays for state="+stateName); //debug show variable on console
        drawState(aryLongX, aryLatY);     //drawState() method calls StdDraw.filledPolygon() AND StdDraw.polygon() in black for border 
      }     

//      //StdDraw.setPenColor(StdDraw.BLUE);                 //1 Colore version of PenColor method
//      //StdDraw.setPenColor(int red, int green, int blue); //RGB version of PenColor method
//           StdDraw.text(0.5, 0.97, "Purple America");        //draw text on the screen at x,y coordinates
//           StdDraw.setPenColor(150, 100, 100);    //write a getColor method to set RGB based on votes
//            //StdDraw.setXscale(double xmin, double xmax);
//            //StdDraw.setYscale(double ymin, double ymax);
//         StdDraw.setXscale(-66.980385,-124.731216);   //values from USA.txt file
//         StdDraw.setYscale( 24.544102, 49.384365);    //values from USA.txt file 
//            //  StdDraw.filledPolygon(Xpts, Ypts);   //draw polygon using pts stored in arrays
//         //  StdDraw.filledPolygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
//           StdDraw.setPenRadius(0.001);        //set pen radius to 0.0 which is 1 pixel and smaller than (0.005 default)
//           StdDraw.polygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
//        //   fill();     //fill() method just calls StdDraw.filledPolygon()
       }

//      public static void fill() { StdDraw.filledPolygon(Xpts, Ypts); }

      public static void setupMap() {
           StdDraw.setCanvasSize(1200, 710);           // change canvas size, default is 512x512
           StdDraw.setPenColor(StdDraw.MAGENTA);       //1 Color version of PenColor method
           StdDraw.text(0.5, 0.98, "Purple America");  //draw text on the screen at x,y coordinates
           }
           
       public static void drawState(double[] aryLongX, double[] aryLatY) {
   //      StdDraw.setXscale(-124.731216,-66.980385);   //values from USA.txt file
         StdDraw.setXscale(-125.5,-66.0);   //values from USA.txt file
   //      StdDraw.setYscale( 24.544102, 49.384365);    //values from USA.txt file add to max to leave room for title 
         StdDraw.setYscale( 24.0, 50.5);    //values from USA.txt file add to max to leave room for title 
         StdDraw.setPenRadius(0.001);        //set pen radius to 0.0 which is 1 pixel and smaller than (0.005 default)
         StdDraw.setPenColor(250, 100, 100);    //write a getColor method to set RGB based on votes
         StdDraw.filledPolygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
         StdDraw.setPenColor(StdDraw.BLACK);   //1 Color version of PenColor method
         StdDraw.polygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
       }

       public static void loadStateXY(int numberOfSubregions, Scanner scan) {
         double[] aryX = new double[numberOfSubregions];
         double[] aryY = new double[numberOfSubregions];
         for(int i=0;i<numberOfSubregions;i++){  
           aryX[i] = scan.nextDouble();
           aryY[i]  = scan.nextDouble();
         }
       }
   }
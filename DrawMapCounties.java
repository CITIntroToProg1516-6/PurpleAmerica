import edu.princeton.cs.introcs.StdDraw;
import java.util.*;
import java.io.*;
import map.VoteColor;

public class DrawMapCounties{
//    private static int numOfPts;          // number of boundary points
//    private static double[] Xpts, Ypts;   // the points (x[i], y[i])
    private static double[] aryLongX, aryLatY;  // the points (x[i], y[i])
    public static String[] aryStateAbbrev = {"AL","AZ","AR","CA","CO","CT","DE","DC","FL","GA","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY","AK","HI"};   // the state abbreviations
    static VoteColor vc = new VoteColor();
    
    // The name of the file to open.
      static String fileName = "USA.txt";   //"AL-AZ-MAP.txt";    //"UTAH-NM-MAP.txt";
      
      public static void main(String[] args) throws Exception { 
       //**  PurpleAmerica  **// 
       //** Read file and store Long, Lat values as X, Y values in arrays  **//
   //   File in = new File ("USA.txt")
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
        String stateAbbreviation="";
        String previousStateName="";
        int stateNumber=0;
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
        
        //USA-AK-HI----------------------------------------------------
      String testCountryName="";  //USA-AK-HI--
      for(int f=0;f<3;f++){  //read in USA-AK-HI
        if (f==0){fileName = "USA-county.txt";}  //USA.txt OR USA-county.txt
        else if(f==1){fileName = "AK.txt";}
        else if(f==2){fileName = "HI.txt";}
        in = new File(fileName);   //read in USA or State text file
        scan = new Scanner(in);
        xmin=scan.nextDouble();
        ymin=scan.nextDouble();
        xmax=scan.nextDouble();
        ymax=scan.nextDouble();
        numberOfUSAregions=scan.nextInt();
        //USA-AK-HI----------------------------------------------------
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
        if(f==0){testCountryName = "USA";}      //USA-AK-HI-----
        if (fileName.equals("USA-county.txt")){testCountryName = countryName;   //}  //first state in USA-county.txt
          if(countryName.length() > 2 ){testCountryName = "";}  //if length is >2 then it is NOT a state abbreviation
          if(countryName.equals("of") ){testCountryName = "";}  // counties with 2 letter words
          if(countryName.equals("Fe") ){testCountryName = "";}  // counties with 2 letter words
          if(countryName.equals("du") ){testCountryName = "";}  // counties with 2 letter words
        }
        else if(f==1){testCountryName = "AK";}  //USA-AK-HI-----
        else if(f==2){testCountryName = "HI";}  //USA-AK-HI-----
        //USA-AK-HI-----  if (countryName.equals("USA")){
          if (countryName.equals(testCountryName)){     //USA-AK-HI-----
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
      if(f==0){          //USA-AK-HI-----
        if (stateName.equals(previousStateName)){
          stateAbbreviation="";
        }else{
          if (fileName.equals("USA-county.txt")){  //first state in USA-county.txt
            if (testCountryName.equals(previousStateName)){   // ("AL")){
            }else{  
              previousStateName = testCountryName;
              stateAbbreviation=aryStateAbbrev[stateNumber];
              stateNumber+=1;
            }
          }else{
            previousStateName = stateName;
            stateAbbreviation=aryStateAbbrev[stateNumber];
            stateNumber+=1;
          }
        }  
          if (fileName.equals("USA-county.txt")){  // USA-county.txt
            drawCounty(aryLongX, aryLatY, stateAbbreviation);     //drawState() method calls StdDraw.filledPolygon() AND StdDraw.polygon() in black for border 
          }else{  
            drawState(aryLongX, aryLatY, stateAbbreviation);     //drawState() method calls StdDraw.filledPolygon() AND StdDraw.polygon() in black for border 
          } 
        }else{          //USA-AK-HI-----
          stateAbbreviation=testCountryName;  //USA-AK-HI-----
          drawCounty(aryLongX, aryLatY, stateAbbreviation);     //drawState() method calls StdDraw.filledPolygon() AND StdDraw.polygon() in black for border 
          
      }               //USA-AK-HI-----
        
 //USA-AK-HI-----       drawState(aryLongX, aryLatY, stateAbbreviation);     //drawState() method calls StdDraw.filledPolygon() AND StdDraw.polygon() in black for border 
      }     
      }          //USA-AK-HI----------------------------------------------------
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
           
       public static void drawCounty(double[] aryLongX, double[] aryLatY, String stateAbbreviation) {
         double min_x = aryLongX[0];
         double min_y = aryLatY[0];
         double max_x = aryLongX[aryLongX.length-1];
         double max_y = aryLatY[aryLatY.length-1];
         double Xpos = 0;
         double Ypos = 0;
       if(stateAbbreviation.equals("AK")){     
         StdDraw.setXscale(-180,-10.0);   //max value is much larger so Alaska is drawn below US
         StdDraw.setYscale( 50.0, 150.0);   //max value is much larger so Alaska is drawn below US 
         Xpos = -170.00;
         Ypos =  60.00;
       }else if(stateAbbreviation.equals("HI")){
         StdDraw.setXscale(-200.0,-60.0);   //max value is much larger so Hawaii is drawn below US 
         StdDraw.setYscale( 15.0,50.5);     //max value is much larger so Hawaii is drawn below US 
         Xpos = -160.00;
         Ypos =  20.00;
       }else{
        StdDraw.setXscale(-125.5,-66.0);   //values from USA.txt file
        StdDraw.setYscale( 24.0, 50.5);    //values from USA.txt file add to max to leave room for title 
       }
         StdDraw.setPenRadius(0.001);        //set pen radius to 0.0 which is 1 pixel and smaller than (0.005 default)
         StdDraw.setPenColor(vc.r, vc.g, vc.b);    //write a getColor method to set RGB based on votes
         StdDraw.filledPolygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
         StdDraw.setPenColor(StdDraw.WHITE);   //1 Color version of PenColor method
         StdDraw.polygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays

         drawStateAbbreviation(Xpos, Ypos, stateAbbreviation); //draw state abreviation on state
       }

       public static void drawState(double[] aryLongX, double[] aryLatY, String stateAbbreviation) {
         double min_x = aryLongX[0];
         double min_y = aryLatY[0];
         double max_x = aryLongX[aryLongX.length-1];
         double max_y = aryLatY[aryLatY.length-1];
   //      StdDraw.setXscale(-124.731216,-66.980385);   //values from USA.txt file
         StdDraw.setXscale(-125.5,-66.0);   //values from USA.txt file
   //      StdDraw.setYscale( 24.544102, 49.384365);    //values from USA.txt file add to max to leave room for title 
         StdDraw.setYscale( 24.0, 50.5);    //values from USA.txt file add to max to leave room for title 
         StdDraw.setPenRadius(0.001);        //set pen radius to 0.0 which is 1 pixel and smaller than (0.005 default)
         StdDraw.setPenColor(vc.r, vc.g, vc.b);    //write a getColor method to set RGB based on votes
         StdDraw.filledPolygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
         StdDraw.setPenColor(StdDraw.WHITE);   //1 Color version of PenColor method
         StdDraw.polygon(aryLongX, aryLatY);   //draw polygon using pts stored in arrays
         for(int i=0;i<aryLongX.length-1;i++){  
           if (min_x > aryLongX[i]){
             min_x = aryLongX[i];
           }
           if (max_x < aryLongX[i]){
             max_x = aryLongX[i];
           }
           if (min_y > aryLatY[i]){
             min_y = aryLatY[i];
           }
           if (max_y < aryLatY[i]){
             max_y = aryLatY[i];
           }
         }
         //meanX = meanX/aryLongX.length;
         //meanY = meanY/aryLongX.length;
    double Xpos = min_x + (max_x - min_x)/2;
    double Ypos = min_y + (max_y - min_y)/2;   
         if(stateAbbreviation.equals("VA")){Xpos += 1.5;}     
         if(stateAbbreviation.equals("FL")){Xpos += 2;}     
         if(stateAbbreviation.equals("ID")){Xpos -= 1.5;}     
         if(stateAbbreviation.equals("KY")){Xpos += 0.75;}     
         if(stateAbbreviation.equals("LA")){Xpos -= 1.25;}     
         if(stateAbbreviation.equals("WA")){Xpos += 2;Ypos -= 2;}     
         if(stateAbbreviation.equals("WI")){Ypos -= 2;}     
         if(stateAbbreviation.equals("NH")){Ypos -= 1;}     
         if(stateAbbreviation.equals("MI")){Xpos += 2;Ypos -= 2;}     
         drawStateAbbreviation(Xpos, Ypos, stateAbbreviation); //draw state abreviation on state
       }

      public static void drawStateAbbreviation(double meanX, double meanY, String stateAbbreviation) {
           StdDraw.setPenColor(StdDraw.BLACK);       //1 Color version of PenColo method
           StdDraw.text(meanX, meanY, stateAbbreviation);  //draw text on the screen at x,y coordinates
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
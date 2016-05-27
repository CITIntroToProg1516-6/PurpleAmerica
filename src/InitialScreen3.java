import java.util.*;

public class InitialScreen3{
   public static void main(String[] args){
   
      System.out.println("Please enter the year you would like to see election results for between 1960 and 2012.");
      System.out.println("Note: Elections occur every four years, so only enter a year that is a multiple of four.");
      
          Scanner scanUserInput = new Scanner(System.in);
          int yearEntered= scanUserInput.nextInt();
          
          boolean yearEnteredIsValid=false;
          
          while(yearEnteredIsValid==false){
            if(yearEntered%4!=0){
               System.out.println("Please enter a year between 1960 and 2012 that is evenly divisible by 4.");
                yearEntered= scanUserInput.nextInt();
            }else if(yearEntered>2012){
                System.out.println("Please enter a year between 1960 and 2012 that is evenly divisible by 4.");
               yearEntered= scanUserInput.nextInt();
            }else if(yearEntered<1960){
                System.out.println("Please enter a year between 1960 and 2012 that is evenly divisible by 4.");
                yearEntered= scanUserInput.nextInt();
            }else{
               yearEnteredIsValid=true;
            }//end of else
          }//end of while loop
          
          //**************************Works*****************************
          System.out.println("Enter 1 for whole USA.  Enter 2 for a state.");
          int wholeUSAOrState= scanUserInput.nextInt();
          
          boolean wholeUSAOrStateIsValid=false;

          while(wholeUSAOrStateIsValid==false){
            if(wholeUSAOrState!=1 && wholeUSAOrState!=2){
              System.out.println("Please enter either a 1 or a 2.");
              wholeUSAOrState= scanUserInput.nextInt();
            }else{
               wholeUSAOrStateIsValid=true;
            }
          }
          
          if(wholeUSAOrState==1){
                 System.out.println("Enter 1 for NO counties.  Enter 2 for counties.");
                 int USACountiesOrNo = scanUserInput.nextInt();
             boolean USACountiesOrNoIsValid=false;
   
             while(USACountiesOrNoIsValid==false){
               if(USACountiesOrNo!=1 && USACountiesOrNo!=2){
                 System.out.println("Please enter either a 1 or a 2.");
                 USACountiesOrNo= scanUserInput.nextInt();
               }else{
                  USACountiesOrNoIsValid=true;
               }//end if else
             }//end while
            
            if(USACountiesOrNo==1){
               System.out.println("You want the map of the USA with NO counties.");//will be code to call the USA to be drawn with given election year and NO counties
            }
            
            if (USACountiesOrNo==2){
               System.out.println("You want the map of the USA with counties.");//will be code to call the USA to be drawn with given election year and counties            
            } 
         }//end if
         
        if(wholeUSAOrState==2){         
            System.out.println("Enter the abbreviation of the state you wish to view in CAPITAL LETTERS.");
            String stateDesiredByUser=scanUserInput.next();
            boolean stateDesiredByUserIsValid=false;
         String[] aryStateAbbrev1 = {"AL","AZ","AR","CA","CO","CT","DE","DC","FL","GA","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY","AK","HI"};   // the state abbreviations
           while(stateDesiredByUserIsValid==false){
            for(int q=0; q<aryStateAbbrev1.length; q++){
              if(stateDesiredByUser.equals(aryStateAbbrev1[q])){
                 stateDesiredByUserIsValid=true;
              }//end of if
            }//end of for
            if(stateDesiredByUserIsValid==false){
            System.out.println("Enter the abbreviation of the state you wish to view in CAPITAL LETTERS.");
            stateDesiredByUser=scanUserInput.next();
          }
          
          if(stateDesiredByUserIsValid==true){
               //code for drawing just state itself with counties and election data for that year
            }
            //System.out.println(""+stateDesiredByUserIsValid+"");//debugging
         //*************************************Works************************************
            
         }

/*while(stateDesiredByUserIsValid==false){
            
            for(int q=0; q<aryStateAbbrev1.length; q++){
              if(scanUserInput.hasNext(aryStateAbbrev1[q])==true){
                 stateDesiredByUserIsValid=true;
              }//end of if
            }//end of for
            System.out.println(""+stateDesiredByUserIsValid+"");//debugging
         //*************************************Works************************************
            
         }//end of while
*/
  }      
        }//end of main method 

   }//end of class
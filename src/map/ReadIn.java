/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author hcps-vizdosdj
 */
import java.io.*;

public class ReadIn {

    public static void read() {

        // Array of names of files to open.
        String[] fileName = {"AK.txt","AL.txt","AR.txt","AZ.txt","CA.txt","CO.txt","CT.txt","DC.txt","DE.txt","FL.txt","GA.txt","HI.txt","IA.txt","ID.txt","IL.txt","IN.txt","KS.txt","KY.txt","LA.txt","MA.txt","MD.txt","ME.txt","MI.txt","MN.txt","MO.txt","MS.txt","MT.txt","NC.txt","ND.txt","NE.txt","NH.txt","NJ.txt","NM.txt","NV.txt","NY.txt","OH.txt","OK.txt","OR.txt","PA.txt","RI.txt","SC.txt","SD.txt","TN.txt","TX.txt","UT.txt","VA.txt","VT.txt","WA.txt","WI.txt","WV.txt","WY.txt",};

        String line = null;
        
        for(int i = 0; i < fileName.length; i ++){
        try {
            FileReader fileReader = new FileReader(fileName[i]);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("ugh");              
        }
        catch(IOException ex) {
            System.out.println("welp");
        }
        }
    }
}


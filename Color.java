/**
 * @(#)Color.java
 *
 *
 * @author 
 * @version 1.00 2016/5/13
 */


public class Color {

public String getStateColor(String state) {

    //read USA1960.txt
    String fileName = "USA1960.txt";
    File in = new File(fileName);   //read in UT text file
    Scanner scan = new Scanner(in);
    
    while (scan.hasNext()) {
        String line = scan.next();
        String[] values = lines.split(",");
        String stateName = values[0];
        int nixon = Integer.parseInt(values[1]);
        int kennedy = Integer.parseInt(values[2]);
        int unpledged = Integer.parseInt(values[3]);
        
        String color;
        
        if (nixon > kennedy && nixon > unpledged)
            color = "red";
        else if (kennedy > nixon && kennedy > unpledged)
            color = "blue";
        else if (unpledged > nixon && unpledged > kennedy)
            color = "white";
       
        if (state.equals("stateName")) {
            break;
        }
        
        
    }
    
    return color;
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hcps-pendyals
 */
public class Coordinate {
    private String longitude;
    private String latitude;
    
    public Coordinate(String longi, String lati) {
        longitude = longi;
        latitude = lati;
    }
    
    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

}

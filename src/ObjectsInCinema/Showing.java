/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectsInCinema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hubert
 */
public class Showing {
    // showing - seans (zawiera informacje o tytule filmu, numerze sali i godzinie)
    
    private Movie movie;
    private int hallNumber;
    private String hour;
        
    public Showing(Movie movie, int hallNumber, String hour) {
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.hour = hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public String getHour() {
        return hour;
    }
 
    
    
    public String dateToString(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = dateFormat.format(currentDate);
        System.out.println(currentDate);
        return dateString;
    }
    
    public Date stringToDate() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateString = "04.08.2015 07:42:00";
        Date date = dateFormat.parse(dateString);
        return date;
    }
    
    public static int hoursToPartsOFTime(String hour){
        int boxNumber = Integer.valueOf(hour.substring(0, 2))*6+Integer.valueOf(hour.substring(3, 5))/10;
        return boxNumber;
    }
    
    
    
}

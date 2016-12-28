/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectsInCinema;

import java.util.ArrayList;

/**
 *
 * @author Hubert
 */
public class Repertoire {
    
    public void makingNewShowing (Movie movie, int hallNumber, String hour, ArrayList cinemaHalls){
        Showing showing = new Showing(null, 0 , null);
        CinemaHall neededHall = new CinemaHall(0,0,0,null,null);
        boolean possibleToAdd = true;
        for (Object cinemaHall : cinemaHalls) {
                CinemaHall cH = (CinemaHall) cinemaHall;
                if(cH.getNumber() == hallNumber)
                   neededHall = cH;
        }
        int part = Showing.hoursToPartsOFTime(hour);
        int duration = movie.getDuration()/10;
        if(part+duration<=neededHall.getTimeEngaged().length){
        for (int j=part-1; j<part+duration; j++){
            if(neededHall.getTimeEngaged()[j]==1)
                possibleToAdd = false;
        }
        if(possibleToAdd == true){
            showing = new Showing(movie, hallNumber, hour);
            for (int j=part-1; j<part+duration; j++){
            neededHall.getTimeEngaged()[j]=1;
            }
            System.out.println("Seans pomyślnie dodany !");
        }
        else{
                    System.out.println("Nie możesz dodać takiego seansu !");
                    }
        }/*else{
            for (int j=part-1; j<neededHall.timeEngaged.length; j++){
            if(neededHall.timeEngaged[j]!=0)
                possibleToAdd = false;
        }
            
        if(possibleToAdd == true){
            showing = new Showing(movie, hallNumber, hour);
            for (int j=part-1; j<neededHall.timeEngaged.length; j++){
            neededHall.timeEngaged[j]=1;
            }
            System.out.println("Seans pomyślnie dodany !");
        }
        else{
                    System.out.println("Nie możesz dodać takiego seansu !");
                    }
            
        }*/
        }
    
}

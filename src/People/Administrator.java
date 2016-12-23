/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import ObjectsInCinema.CinemaHall;
import ObjectsInCinema.Movie;
import ObjectsInCinema.Showing;
import java.util.ArrayList;

/**
 *
 * @author Hubert
 */
public class Administrator {
    private String id;
    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private String login;
    private String password;

    public Administrator(String id, String name, String surname, int phoneNumber, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
    }
    
    public void makingNewShowing (Movie movie, int hallNumber, String hour, ArrayList cinemaHalls){
        Showing showing = new Showing(null, 0 , null);
        CinemaHall neededHall = new CinemaHall(0,0,0);
        CinemaHall cH = new CinemaHall(0,0,0);
        boolean possibleToAdd = true;
        for (Object cinemaHall : cinemaHalls) {
                cH = (CinemaHall) cinemaHall;
                if(cH.getNumber()==hallNumber)
                    neededHall = cH;
        }
        int part = Showing.hoursToPartsOFTime(hour);
        int duration = movie.getDuration()/10;
        if(part+duration<=neededHall.engaged.length){
        for (int j=part-1; j<part+duration; j++){
            if(neededHall.engaged[j]!=0)
                possibleToAdd = false;
        }
            
        if(possibleToAdd == true){
            showing = new Showing(movie, hallNumber, hour);
            for (int j=part-1; j<part+duration; j++){
            neededHall.engaged[j]=1;
            }
            System.out.println("Seans pomyślnie dodany !");
        }
        else{
                    System.out.println("Nie możesz dodać takiego seansu !");
                    }
        }
        }
    }



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Memory.MoviesInMemory;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.Showing;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aga
 */
public class MovieTest {
    
    public MovieTest() {
    }

     @Test
    public void loadAndSavePeopleDontThrowException(){
       Exception ex = null;
       HashMap movies = MoviesInMemory.load();
       try{MoviesInMemory.save(movies);}
       catch(Exception e){
           ex =e;
       }
       assertEquals(null, ex);
    }
      
    @Test
    public void loadPeopleFromExistingFile(){
        HashMap movies = MoviesInMemory.load("moviesTest.txt");
        Movie movie = (Movie) movies.get("Film1");
        
        Movie movieExpected = new Movie("Film1", "Dir1", MovieType.ACTION, 16, 111);
        
        assertEquals(movie.getAge(), movie.getAge());
        assertEquals(movie.getDirector(), movie.getDirector());
        assertEquals(movie.getDuration(), movie.getDuration());
        assertEquals(movie.getTitle(), movie.getTitle());
        assertEquals(movie.getType(), movie.getType());
         
    }
    
    @Test
    public void hourToParts(){
        int part = Showing.hoursToPartsOFTime("14:20");
        
        assertEquals(86, part);
    }
    
    @Test
    public void showingConstructorWithAllParams(){
        Movie movie = new Movie("title", "dir", MovieType.WAR, 12, 120);
        Showing showing = new Showing(movie, 1, "12:02");
        
        assertEquals(showing.getHallNumber(), 1);
        assertEquals(showing.getHour(), "12:02");
        assertEquals(showing.getMovie(), movie);
        
    }
    
    @Test
    public void setHourWhenMovieIsStarted(){
        int hour = Showing.hourStart("14:20");
        
        assertEquals(14, hour);
    }
    
    @Test
    public void setHourWhenMovieIsStartedAndHourUnderTen(){
        int hour = Showing.hourStart("7:20");
        
        assertEquals(7, hour);
    }
    
    
    @Test
    public void setMinutesWhenMovieIsStarted(){
        int minutes = Showing.minuteStart("14:20");
        
        assertEquals(20, minutes);
    }
    
    
    
    
}

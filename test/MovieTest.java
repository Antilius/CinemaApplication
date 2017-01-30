/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Memory.MoviesInMemory;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
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
    public void LoadAndSavePeopleDontThrowException(){
       Exception ex = null;
       HashMap movies = MoviesInMemory.load();
       try{MoviesInMemory.save(movies);}
       catch(Exception e){
           ex =e;
       }
       assertEquals(null, ex);
    }
      
    @Test
    public void LoadPeopleFromExistingFile(){
        HashMap movies = MoviesInMemory.load("moviesTest.txt");
        Movie movie = (Movie) movies.get("Film1");
        
        Movie movieExpected = new Movie("Film1", "Dir1", MovieType.ACTION, 16, 111);
        
        assertEquals(movie.getAge(), movie.getAge());
        assertEquals(movie.getDirector(), movie.getDirector());
        assertEquals(movie.getDuration(), movie.getDuration());
        assertEquals(movie.getTitle(), movie.getTitle());
        assertEquals(movie.getType(), movie.getType());
        
        
    }
    
    
}

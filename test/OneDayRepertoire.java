/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Memory.MoviesInMemory;
import Memory.OneDayRepertoireInMemory;
import ObjectsInCinema.Movie;
import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aga
 */
public class OneDayRepertoire {
    
    public OneDayRepertoire() {
    }
    
    @Test(expected=NullPointerException.class)
    public void loadOneDayRepertoireWithoutDate(){
        OneDayRepertoireInMemory.load(null);
    }
    
    @Test(expected=NullPointerException.class)
    public void saveOneDayRepertoireWithoutRepertoireAndWithoutDate(){
        OneDayRepertoireInMemory.save(null, null);
    }
    
    @Test(expected=NullPointerException.class)
    public void saveOneDayRepertoireWithoutDate(){
        ObjectsInCinema.OneDayRepertoire repertoire = new ObjectsInCinema.OneDayRepertoire(new DateFormatting());
        OneDayRepertoireInMemory.save(repertoire, null);
    }
    
    @Test(expected=NullPointerException.class)
    public void saveOneDayRepertoireWithoutRepertoire(){
        OneDayRepertoireInMemory.save(null, new DateFormatting());
    }
    
    @Test
    public void saveWithBoolCorrectSave(){
        ObjectsInCinema.OneDayRepertoire repertoire = new ObjectsInCinema.OneDayRepertoire(new DateFormatting());
        boolean saved = OneDayRepertoireInMemory.saveWithBool(repertoire, new DateFormatting());
        
        assertTrue(saved);
    }
    
    @Test(expected=NullPointerException.class)
    public void saveWithBoolsIncorrectSave(){
        ObjectsInCinema.OneDayRepertoire repertoire = new ObjectsInCinema.OneDayRepertoire(new DateFormatting());
        boolean savedWithull = OneDayRepertoireInMemory.saveWithBool(null, null);
        boolean savedWithNoRepertoire = OneDayRepertoireInMemory.saveWithBool(null, new DateFormatting());
        boolean savedWithNoData = OneDayRepertoireInMemory.saveWithBool(repertoire, null);
        
    }
    
    @Test
    public void setRepertoireOfADay(){
        HashMap movies = MoviesInMemory.load("moviesTest.txt");
        Showing showing1 = new Showing((Movie) movies.get("Film1"),1 , "12:00");
        Showing showing2 = new Showing((Movie) movies.get("Film2"), 2, "13:00");
        ObjectsInCinema.OneDayRepertoire repertoire = new ObjectsInCinema.OneDayRepertoire(new DateFormatting());
        ArrayList movieList = new ArrayList();
        movieList.add(showing1);
        movieList.add(showing2);
        repertoire.setRepertoireForDay(movieList);
        
        assertEquals(movieList, repertoire.getRepertoireForDay());
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Memory.ViewOfHallInMemory;
import ObjectsInCinema.CinemaHall;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.Showing;
import ObjectsInCinema.ViewOfHall;
import People.Person;
import PersonalizedDates.DateFormatting;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aga
 */
public class HallTest {
    
    public HallTest() {
    }

    @Test
    public void cinemaHallConstructorTest(){
        int[] array = new int[1];
        array[0]=1;
        CinemaHall hall = new CinemaHall(1, 2, 3,array);
        
        assertEquals(1,hall.getNumber());
        assertEquals(2,hall.getNumberOfRows());
        assertEquals(3,hall.getSeatsInRow());
        assertArrayEquals(array, hall.getTimeEngaged());
    }
    
      @Test(expected=NullPointerException.class)
   public void saveViewOfHallwithNulls(){
       ViewOfHallInMemory.save(null, null);
    }
   
   @Test(expected=NullPointerException.class)
   public void saveViewOfHallwithoutName(){
       ViewOfHall hall = new ViewOfHall(1, 2);
       ViewOfHallInMemory.save(hall, null);
   }
   @Test(expected=NullPointerException.class)
   public void saveViewOfHallwithoutViewOfHall(){
       ViewOfHallInMemory.save(null, "name");
   }
   @Test
   public void saveViewOfHall(){
       ViewOfHall hall = new ViewOfHall(1, 2);
       ViewOfHallInMemory.save(hall, "name");
   }
   
   @Test(expected=NullPointerException.class)
   public void loadViewOfHallWithNulls(){
       ViewOfHallInMemory.load(null, null);
   }
    @Test(expected=NullPointerException.class)
    public void loadViewOfHallWithNoDate(){
        Movie movie = new Movie("tytul1", "rezyser1", MovieType.ANIMATED,16,120);
        Person person = new Person("Imie", "Nazwisko", 2,"email","login","password", false);
        DateFormatting date = new DateFormatting();
        Showing showing = new Showing (movie,2,"20.00");
        ViewOfHallInMemory.load(showing, null);
    }
    
    @Test(expected=NullPointerException.class)
    public void loadViewOfHallWithNoShowing(){
        ViewOfHallInMemory.load(null,new DateFormatting());
    }
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Memory.HallsForDayInMemory;
import ObjectsInCinema.BookedPlace;
import ObjectsInCinema.Booking;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.OneDayRepertoire;
import ObjectsInCinema.Showing;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aga
 */
public class BookingTest {
    
    public BookingTest() {
    
    }

     @Before
    public void setUp() {
       
    }
    
    
    //testowac osobno, razem error
    @Test
    public void bookFreePlace(){

        Movie movie = new Movie("tytul", "rezyser", MovieType.ANIMATED,16,120);
        Person person = new Person("Imie", "Nazwisko", 2,"email","login","password", false);
        DateFormatting date = new DateFormatting();
        BookedPlace place = new BookedPlace(1,7);//zmieniac za kazdym razem
        Showing showing = new Showing (movie,1,"20.00");
      
        Booking booking = new Booking(date,person, showing, place);
        
       
        assertTrue( booking.acceptingBooking(booking));
        
    }
    
    @Test 
    public void bookTakenPlace(){
        Movie movie = new Movie("tytul1", "rezyser1", MovieType.ANIMATED,16,120);
        Person person = new Person("Imie", "Nazwisko", 2,"email","login","password", false);
        DateFormatting date = new DateFormatting();
        Showing showing = new Showing (movie,2,"20.00");
        BookedPlace place = new BookedPlace(1, 2); //zmieniac za kazdym razem
        Booking booking = new Booking(date, person,showing, place);
        Booking booking2 = new Booking(date, person,showing, place);
        booking.acceptingBooking(booking);
        assertFalse(booking2.acceptingBooking(booking));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

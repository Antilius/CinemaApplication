/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ObjectsInCinema.BookedPlace;
import ObjectsInCinema.Booking;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.Showing;
import People.Person;
import PersonalizedDates.DateFormatting;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aga
 */
public class BookingTest {
    
    public BookingTest() {
    
    }
    
    @Test
    public void bookFreePlace(){
        //given
        Movie movie = new Movie("tytul", "rezyser", MovieType.ANIMATED,16,120);
        Person person = new Person("Imie", "Nazwisko", 2,"email","login","password", false);
        DateFormatting date = new DateFormatting();
        BookedPlace place = new BookedPlace(1,8);//zmieniac za kazdym razem
        Showing showing = new Showing (movie,1,"20.00");
      
        Booking booking = new Booking(date,person, showing, place);
        
       
        assertTrue( booking.acceptingBooking(booking));
        
    }
    
    @Test 
    public void bookTakenPlace(){
        
        //given
        
        Movie movie = new Movie("tytul1", "rezyser1", MovieType.ANIMATED,16,120);
        Person person = new Person("Imie", "Nazwisko", 2,"email","login","password", false);
        DateFormatting date = new DateFormatting();
        Showing showing = new Showing (movie,2,"20.00");
        BookedPlace place = new BookedPlace(1, 3); //zmieniac za kazdym razem
        Booking booking = new Booking(date, person,showing, place);
        Booking booking2 = new Booking(date, person,showing, place);
        //then
        booking.acceptingBooking(booking);
        assertFalse(booking2.acceptingBooking(booking));
    }
    
    @Test
    public void BookingConstructorTest(){
        //given
        DateFormatting date = new DateFormatting();
        Movie movie = new Movie("title", "dir",MovieType.WAR, 12, 120);
        Showing showing = new Showing(movie,1,"120");
        Person person = new Person ("a", "b", 11, "email", "login", "password", true);
        BookedPlace place = new BookedPlace(1, 2);
        Booking booking = new Booking(date,person,showing,place);
        
       //then
        assertEquals(date, booking.getDate());
        assertEquals(showing, booking.getShowing());
        assertEquals(person, booking.getPerson());
        assertEquals(place, booking.getPlace());
    }
 
    @Test
    public void BookedPlaceConstructorTest(){
        BookedPlace place = new BookedPlace(1,2);
        assertEquals(1, place.getRow());
        assertEquals(2, place.getPlace());
    }
    
    
}

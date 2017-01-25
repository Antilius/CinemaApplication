package ObjectsInCinema;

import Memory.BookingInMemory;
import Memory.ViewOfHallInMemory;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.util.ArrayList;

public class Booking {
    
    DateFormatting date;
    Person person;
    Showing showing;
    BookedPlace place;

    public Booking(DateFormatting date, Person person, Showing showing, BookedPlace place) {
        this.date = date;
        this.person = person;
        this.showing = showing;
        this.place = place;
    }

    public DateFormatting getDate() {
        return date;
    }
    
    public Person getPerson() {
        return person;
    }

    public Showing getShowing() {
        return showing;
    }

    public BookedPlace getPlace() {
        return place;
    }
    
    public boolean acceptingBooking(Booking booking){
        boolean canBeAdd = false;
        ViewOfHall viewOfHall = ViewOfHallInMemory.load(this.showing, this.date);
        ArrayList<Booking> bookings = new ArrayList();
        bookings = BookingInMemory.load(this.person.getLogin());
        int[][] places = viewOfHall.getPlaces();
        if(places[this.place.getRow()-1][this.place.getPlace()-1] == 0 ){
            places[this.place.getRow()-1][this.place.getPlace()-1] = 1;
            bookings.add(this);
            canBeAdd = true;
        }
        String nazwa = "ViewsOfHalls/Hall "+showing.getHallNumber()+" for "+this.date.withoutHoursDateFormat()+" "+showing.getHour()+".txt";
        viewOfHall.setPlaces(places);
        ViewOfHallInMemory.save(viewOfHall, nazwa);
        BookingInMemory.save(this.person.getLogin(), bookings, this.date);
        return canBeAdd;
    }
}

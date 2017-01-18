package Memory;

import ObjectsInCinema.BookedPlace;
import ObjectsInCinema.Booking;
import ObjectsInCinema.Movie;
import ObjectsInCinema.Showing;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookingInMemory {
    
    public static void save(String user, ArrayList<Booking> bookings, DateFormatting date) {
        
        File bookingFile = new File ("Bookings/"+user+".txt");
        try {
            PrintWriter write = new PrintWriter(bookingFile);
            for (int i=0; i<bookings.size(); i++) {
                Booking booking = bookings.get(i);
                write.println(booking.getShowing().getMovie().getTitle());
                write.println(booking.getDate().getTime());
                write.println(booking.getShowing().getHour());
                write.println(booking.getShowing().getHallNumber());
                write.println(booking.getPlace().getRow());
                write.println(booking.getPlace().getPlace());
            }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    public static ArrayList load(String user){
        File bookingFile = new File ("Bookings/"+user+".txt");
        ArrayList<Booking> bookings = new ArrayList();
        HashMap<String, Movie> movies = MoviesInMemory.load();
        HashMap<String, Person> users = PeopleInMemory.load();
        Person person = users.get(user);
        BookedPlace bookedPlace;
        try {
            Scanner reader = new Scanner(bookingFile);
            String title;
            Movie movie;
            DateFormatting date;
            String hour;
            int hallNumber;
            Showing showing;
            while(reader.hasNextLine()){
                title = reader.nextLine();
                movie = movies.get(title);
                date = new DateFormatting(Long.parseLong(reader.nextLine()));
                hour = reader.nextLine();
                hallNumber = Integer.parseInt(reader.nextLine());
                bookedPlace = new BookedPlace(Integer.parseInt(reader.nextLine()),Integer.parseInt(reader.nextLine()));
                showing = new Showing(movie, hallNumber, hour);
                Booking booking = new Booking(date, person, showing, bookedPlace);
                bookings.add(booking);
            }
            
            } catch (FileNotFoundException ex) {
                ex.getMessage();
                }
        return bookings;
    }
    
}

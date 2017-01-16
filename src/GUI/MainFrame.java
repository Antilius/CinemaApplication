package GUI;

import Memory.HallsForDayInMemory;
import Memory.MoviesInMemory;
import Memory.OneDayRepertoireInMemory;
import Memory.PeopleInMemory;
import ObjectsInCinema.Booking;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.OneDayRepertoire;
import ObjectsInCinema.BookedPlace;
import ObjectsInCinema.Showing;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    public static final String CINEMA_APP_VERSION="Cinema Application v 1.0 (Beta): group project";
    
    public MainFrame(int width, int height){
        super(CINEMA_APP_VERSION);
        this.setSize(new Dimension(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300,200); 
        this.setResizable(false);
        //adding components       
        JPanel GUIwhenAppOpened = new MainPanel(width, height);
        this.add(GUIwhenAppOpened); 
        this.setVisible(true);         
    }
   
    public static int setPossibleDimensionWidth(){
        File prop = new File("properties.txt");
        Scanner propertiesFileScanner = null;
        try {
            propertiesFileScanner = new Scanner(prop);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getClass().toString() + " while scanning file.");
        }
        int width = propertiesFileScanner.nextInt();
        propertiesFileScanner.close();
        return width;
    }
    
    public static void runGUI(int width, int height){
        new MainFrame(width, height);
    }
    
    public static void main(String[] args) {
        File prop = new File("properties.txt");
        if(!prop.exists()){
            Resolution.askForResolutionIfNotChosen(true);
        }
        else{
            try {
                Scanner propertiesFileScanner = new Scanner(prop);
                int width = propertiesFileScanner.nextInt();
                int height = propertiesFileScanner.nextInt();
                runGUI(width, height);
                propertiesFileScanner.close();
            } 
            catch (FileNotFoundException ex) {
                System.err.println(ex.getClass().toString()+" while opening properties file");
            }
        }
        
        DateFormatting date = new DateFormatting();
        HallsForDayInMemory.prepareHallsForNewDay(date);
        HashMap users = PeopleInMemory.load();
        HashMap halls = HallsForDayInMemory.load(date);
        HashMap<String, Movie> movies = new HashMap();
        OneDayRepertoire oneDayRep = new OneDayRepertoire(date);
        Movie movie = new Movie("Kubuś Puchatek i przyjaciele","Director",MovieType.ACTION,16,234);
        movies.put(movie.getTitle(), movie);
        Showing showing1 = new Showing(movie, 2, "01.30");
        oneDayRep.addShowingToRepertoire(showing1, halls);
        Movie movie1 = new Movie("Kaczor Donald i wesołe przygody","Director",MovieType.ACTION,16,123);
        movies.put(movie1.getTitle(), movie1);
        Showing showing2 = new Showing(movie1, 1, "22.30");
        oneDayRep.addShowingToRepertoire(showing2, halls);
        //Showing showing3 = new Showing(movie, 5, "19.30");
        //oneDayRep.addShowingToRepertoire(showing3, halls);
        MoviesInMemory.save(movies);
        BookedPlace place = new BookedPlace(15,20);
        Booking booking = new Booking(date, (Person)users.get("jan"), showing1, place);
        booking.acceptingBooking(booking);
        booking = new Booking(date, (Person)users.get("hubert"), showing2, place);
        booking.acceptingBooking(booking);
        
        HallsForDayInMemory.save(halls, date);
        OneDayRepertoireInMemory.save(oneDayRep, date);
    }  
}

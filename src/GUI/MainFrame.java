package GUI;

import Memory.HallsInMemory;
import Memory.OneDayRepertoireInMemory;
import Memory.PeopleInMemory;
import ObjectsInCinema.CinemaHall;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.OneDayRepertoire;
import ObjectsInCinema.Showing;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        this.setResizable(true);
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
        
        
        /*
        DateFormatting date = new DateFormatting();
        HallsInMemory his = new HallsInMemory();
        his.prepareHallsForNewDay(date);
        
        PeopleInMemory pim = new PeopleInMemory();
        OneDayRepertoireInMemory odrim = new OneDayRepertoireInMemory();
        Showing showing = new Showing();
        OneDayRepertoire rep = new OneDayRepertoire();
        Movie movie = new Movie("Title","Director",MovieType.ACTION,16,300);
        
        File people = new File("users.txt");
        File repFile = new File("repertoireFor "+date.withoutHoursDateFormat()+".txt");
        File halls = new File("Halls "+date.withoutHoursDateFormat()+".txt");
        
        ArrayList<Person> users = new ArrayList();
        ArrayList<CinemaHall> cinemaHalls = new ArrayList();
        ArrayList<Showing> repertoireForDay = new ArrayList();
        
        users = pim.readFromFile(people);
        cinemaHalls = his.readFromFile(halls);
        
        showing = new Showing(movie, 2, "16.30");
        rep.addShowingToRepertoire(showing, cinemaHalls);
        showing = new Showing(movie, 1, "16.30");
        rep.addShowingToRepertoire(showing, cinemaHalls);
        showing = new Showing(movie, 2, "16.30");
        rep.addShowingToRepertoire(showing, cinemaHalls);
        showing = new Showing(movie, 3, "16.30");
        rep.addShowingToRepertoire(showing, cinemaHalls);
        
        repertoireForDay = rep.getRepertoireForDay();
        
        his.saveInFile(cinemaHalls, halls);
        odrim.saveInFile(repertoireForDay, repFile);

        */
        DateFormatting date = new DateFormatting();
        HallsInMemory.prepareHallsForNewDay(date);
        HashMap halls = HallsInMemory.load(date);
        OneDayRepertoire oneDayRep = new OneDayRepertoire();
        Movie movie = new Movie("Title","Director",MovieType.ACTION,16,300);
        Showing showing = new Showing(movie, 2, "16.30");
        oneDayRep.addShowingToRepertoire(showing, halls);
        HallsInMemory.save(halls, date);
        OneDayRepertoireInMemory.save(oneDayRep, date);
    }
}

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
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        
        PeopleInMemory pim = new PeopleInMemory();
        OneDayRepertoireInMemory odrim = new OneDayRepertoireInMemory();
        HallsInMemory his = new HallsInMemory();
        Showing showing = new Showing();
        OneDayRepertoire rep = new OneDayRepertoire();
        Movie movie = new Movie("Title","Director",MovieType.ACTION,16,300);
        
        File halls = new File("cinemaHalls.txt");
        File people = new File("users.txt");
        
        ArrayList<Person> users = new ArrayList();
        ArrayList<CinemaHall> cinemaHalls = new ArrayList();
        ArrayList<Showing> repertoireForDay = new ArrayList();
        
        users = pim.readFromFile(people);
        cinemaHalls = his.readFromFile(halls);
        
        showing = rep.makingNewShowing(movie, 1, "16.30", cinemaHalls);
        rep.addShowingToRepertoire(showing);
        showing = rep.makingNewShowing(movie, 1, "10.30", cinemaHalls);
        rep.addShowingToRepertoire(showing);
        showing = rep.makingNewShowing(movie, 2, "10.10", cinemaHalls);
        rep.addShowingToRepertoire(showing);
        //showing = rep.makingNewShowing(movie, 3, "10.10", cinemaHalls);
        //rep.addShowingToRepertoire(showing);
        showing = rep.makingNewShowing(movie, 3, "10.10", cinemaHalls);
        rep.addShowingToRepertoire(showing);
        showing = rep.makingNewShowing(movie, 3, "23.10", cinemaHalls);
        rep.addShowingToRepertoire(showing);
        
        repertoireForDay = rep.getRepertoireForDay();
        
        his.saveInFile(cinemaHalls);
        odrim.saveInFile(repertoireForDay);
        repertoireForDay = new ArrayList();
        File repo = new File("repertoireFor(data).txt");
        repertoireForDay = odrim.readFromFile(repo);
        System.out.println(repertoireForDay.size());
                
    }
}

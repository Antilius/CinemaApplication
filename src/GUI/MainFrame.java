package GUI;

import ObjectsInCinema.CinemaHall;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import People.Administrator;
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
        
        ///////////// na potrzeby testowania dodawania seansów
        
        ///// sale kinowe (one chyba i tak muszą być zrobione na tym poziomie)
        ArrayList<CinemaHall> cinemaHalls = new ArrayList();
        cinemaHalls.add(new CinemaHall(1,20,30));
        cinemaHalls.add(new CinemaHall(2,18,26));
        cinemaHalls.add(new CinemaHall(3,22,40));
        
        
        Administrator admin = new Administrator("Hubert", "Lasota", 511713563, "email", "hubert", "hubert");
        Movie movie = new Movie("Title", "Director", MovieType.ACTION, 16, 300);
        admin.makingNewShowing(movie, 1, "21:30", cinemaHalls);
        admin.makingNewShowing(movie, 2, "21:00", cinemaHalls);
        admin.makingNewShowing(movie, 2, "21:00", cinemaHalls);
        admin.makingNewShowing(movie, 3, "13:00", cinemaHalls);
        admin.makingNewShowing(movie, 3, "21:00", cinemaHalls);
        admin.makingNewShowing(movie, 3, "19:00", cinemaHalls);
    }
}

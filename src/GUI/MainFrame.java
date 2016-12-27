package GUI;

import Memory.HallsInMemory;
import ObjectsInCinema.CinemaHall;
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
        /*
        int[] time = new int[144];
        for(int i=0; i<144; i++)
            time[i]=0;
        int number =8;
        int rows = 10;
        int seats = 15;
        int [][] places = new int[10][15];
        for(int i=0; i<10; i++){
            for(int j=0; j<15; j++){
                places[i][j]=0;
            }
        }
        ArrayList<CinemaHall> cinemaHalls = new ArrayList();
        CinemaHall ch = new CinemaHall(number, rows, seats, time, places);
        cinemaHalls.add(ch);
        cinemaHalls.add(ch);
        cinemaHalls.add(ch);
        HallsInMemory his = new HallsInMemory();
        his.saveInFile(cinemaHalls);
                */
    }
}

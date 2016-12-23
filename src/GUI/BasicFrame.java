package GUI;

import ObjectsInCinema.CinemaHall;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import People.Administrator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BasicFrame extends JPanel{
    
    private static final String CINEMA_APP_VERSION="Cinema Application v 1.0 (Beta): group project";
    
    private int width;
    private int height;
    
    public BasicFrame(){
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło
        this.setVisible(true);
    }
    
    public BasicFrame(int width, int height){
        //set properties
        this.setLayout(null);
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło
        
        this.setSize(new Dimension(width, height));
        //adding components
        JLabel text = new JLabel("Login to your cinema account:");
        text.setFont(new Font("Times Roman",Font.PLAIN,20));
        text.setForeground(Color.white);
        this.add(text);
        
        JTextField loginField = new JTextField(25);
        this.add(loginField);
        JPasswordField passwordField = new JPasswordField(25);
        this.add(passwordField);
        
        Dimension text_size = text.getPreferredSize();
        Dimension login_size = loginField.getPreferredSize();
        Dimension password_size = passwordField.getPreferredSize();
        
        text.setBounds((width-text_size.width)/2, 50, text_size.width, text_size.height);
        loginField.setBounds((width-login_size.width)/2, 200, login_size.width, login_size.height);
        passwordField.setBounds((width-password_size.width)/2, 250, password_size.width, password_size.height);
        this.setVisible(true);
    }
    
    public static void runGUI(int width, int height){
        JFrame cinema = new JFrame(CINEMA_APP_VERSION);
        //setting main preferences
        
        cinema.setSize(new Dimension(width, height));
        cinema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cinema.setLocation(300,200);
        //adding components
        JPanel GUIwhenAppOpened = new BasicFrame(width, height);
        cinema.add(GUIwhenAppOpened);
        cinema.setVisible(true);
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
                int length = propertiesFileScanner.nextInt();
                runGUI(width, length);
                propertiesFileScanner.close();
            } 
            catch (FileNotFoundException ex) {
                System.err.println(ex.getClass().toString()+" while opening properties file");
            }
        }
        
        /////////////////////////////
        //////// dodane dla testowania
        ArrayList<CinemaHall> cinemaHalls = new ArrayList();
        cinemaHalls.add(new CinemaHall(1,20,30));
        cinemaHalls.add(new CinemaHall(2,18,26));
        cinemaHalls.add(new CinemaHall(3,22,40));
        Administrator admin = new Administrator("1","Hubert", "Surname", 5631351, "email", "hubert", "hubert" );
        Movie movie = new Movie("Title", "Director", MovieType.ACTION, 16, 150);
        admin.makingNewShowing(movie, 1, "21:30", cinemaHalls);
        admin.makingNewShowing(movie, 2, "21:00", cinemaHalls);
        admin.makingNewShowing(movie, 2, "21:00", cinemaHalls);
        
    }
}

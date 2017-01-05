package Memory;

import ObjectsInCinema.CinemaHall;
import PersonalizedDates.DateFormatting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HallsInMemory{
    
    public static void save(HashMap cinemaHalls, DateFormatting date) {
        File hallsInMemory = new File ("Halls "+date.withoutHoursDateFormat()+".txt");
        try {
            PrintWriter write = new PrintWriter(hallsInMemory);
            for (int i=1; i<=cinemaHalls.size(); i++) {
               CinemaHall cinemaHall = (CinemaHall) cinemaHalls.get(i);
               write.println(cinemaHall.getNumber());
               write.println(cinemaHall.getNumberOfRows());
               write.println(cinemaHall.getSeatsInRow());
               for(int j=0; j<cinemaHall.getTimeEngaged().length; j++){
                   write.print(cinemaHall.getTimeEngaged()[j]);
               }
               write.println();
               for(int k=0; k<cinemaHall.getNumberOfRows(); k++){
                   for(int j=0; j<cinemaHall.getSeatsInRow(); j++){
                       write.print(cinemaHall.getPlaces()[k][j]);
                   }
                   write.println();
               }
            }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    public static HashMap load(DateFormatting date){
        File hallsInMemory = new File ("Halls "+date.withoutHoursDateFormat()+".txt");
        HashMap<Integer, CinemaHall> cinemaHalls = new HashMap();
        try {
            Scanner reader = new Scanner(hallsInMemory);
            while(reader.hasNextLine()){
            int number = Integer.valueOf(reader.nextLine());
            int numberOfRows = Integer.valueOf(reader.nextLine());
            int seatsInRow = Integer.valueOf(reader.nextLine());
            String time = reader.nextLine();
            int [] timeEngaged = new int [144];
            for(int i=0; i<timeEngaged.length; i++){
                timeEngaged[i] = Integer.valueOf(time.substring(0,1));
                time = time.substring(1);
            }
            int [][] places = new int [numberOfRows][seatsInRow];
            
            for(int k=0; k<numberOfRows; k++){
                String row = reader.nextLine();
                for(int l=0; l<seatsInRow; l++){
                    places[k][l] = Integer.valueOf(row.substring(0,1));
                    row = row.substring(1);
                }
            }
            
            CinemaHall cinemaHall = new CinemaHall(number, numberOfRows, seatsInRow, timeEngaged, places);
            cinemaHalls.put(number, cinemaHall);
            }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
                }
        return cinemaHalls;
    }
    
    public static void prepareHallsForNewDay(DateFormatting date){
        File halls = new File("Halls "+date.withoutHoursDateFormat()+".txt"); 
        try {
            PrintWriter write = new PrintWriter(halls);
            for(int i=1; i<=5; i++){
            write.println(i);
            write.println(15);
            write.println(20);
            for(int j=0; j<144; j++){
                write.print(0);
            }
            write.println();
            for(int k=0; k<15; k++){
                for(int l=0; l<20; l++){
                    write.print(0);
                }
                write.println();
            }
            }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }
    
    
    
}

package Memory;

import ObjectsInCinema.CinemaHall;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HallsInMemory implements ConnectWithMemory{
        
    
    int number;
    int numberOfRows;
    int seatsInRow;
    int [][] places;
    int [] timeEngaged;
    String row;
    String time;
    
    @Override
    public void saveInFile(ArrayList cinemaHalls) {
        File hallsInMemory = new File("cinemaHalls.txt");
        try {
            PrintWriter write = new PrintWriter(hallsInMemory);
            for (Object cinemaHall1 : cinemaHalls) {
               CinemaHall cinemaHall = (CinemaHall) cinemaHall1;
               write.println(cinemaHall.getNumber());
               write.println(cinemaHall.getNumberOfRows());
               write.println(cinemaHall.getSeatsInRow());
               for(int i=0; i<cinemaHall.getTimeEngaged().length; i++){
                   write.print(cinemaHall.getTimeEngaged()[i]);
               }
               write.println();
               for(int i=0; i<cinemaHall.getNumberOfRows(); i++){
                   for(int j=0; j<cinemaHall.getSeatsInRow(); j++){
                       write.print(cinemaHall.getPlaces()[i][j]);
                   }
                   write.println();
               }
            }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    @Override
    public ArrayList readFromFile(File hallsInMemory){
        ArrayList<CinemaHall> cinemaHalls = new ArrayList();
        try {
            Scanner reader = new Scanner(hallsInMemory);
            while(reader.hasNextLine()){
            number = Integer.valueOf(reader.nextLine());
            numberOfRows = Integer.valueOf(reader.nextLine());
            seatsInRow = Integer.valueOf(reader.nextLine());
            time = reader.nextLine();
            timeEngaged = new int [144];
            for(int i=0; i<timeEngaged.length; i++){
                timeEngaged[i] = Integer.valueOf(time.substring(0,1));
                time = time.substring(1);
            }
            places = new int [numberOfRows][seatsInRow];
            
            for(int k=0; k<numberOfRows; k++){
                row = reader.nextLine();
                for(int l=0; l<seatsInRow; l++){
                    places[k][l] = Integer.valueOf(row.substring(0,1));
                    row = row.substring(1);
                }
            }
            
            
            // wyswietlanie calej sali na ekran dla sprawdzenia
            /*
            System.out.println(number + "-" + numberOfRows + "-" +seatsInRow);
            for(int i=0; i<timeEngaged.length; i++){
                System.out.print(timeEngaged[i]);
            }
                System.out.println();
            for(int k=0; k<numberOfRows; k++){
                for(int l=0; l<seatsInRow; l++){
                    System.out.print(places[k][l]);
                }
                System.out.println();
            }
            */
            
            CinemaHall cinemaHall = new CinemaHall(number, numberOfRows, seatsInRow, timeEngaged, places);
            cinemaHalls.add(cinemaHall);
            }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
                }
        return cinemaHalls;
    }
    
    
    
    
}

package Memory;

import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.Showing;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OneDayRepertoireInMemory implements ConnectWithMemory{

    @Override
    public void saveInFile(ArrayList repertoireForDay) {
       File oneDayRep = new File("repertoireFor(data).txt");
        try {
            PrintWriter write = new PrintWriter(oneDayRep);
           for (Object showing1 : repertoireForDay) {
                Showing showing = (Showing) showing1;
                write.println(showing.getMovie().getTitle());
                write.println(showing.getMovie().getDirector());
                write.println(showing.getMovie().getType());
                write.println(showing.getMovie().getAge());
                write.println(showing.getMovie().getDuration());
                write.println(showing.getHallNumber());
                write.println(showing.getHour());
           }
           write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    @Override
    public ArrayList readFromFile(File oneDayRep) {
        ArrayList<Showing> repertoireForDay = new ArrayList();
        String title;
        String director;
        MovieType type;
        int age;
        int duration;
        int hallNumber;
        String hour;
        
        try {
            Scanner reader = new Scanner(oneDayRep);
            while(reader.hasNextLine()){
                title = reader.nextLine();
                director = reader.nextLine();
                type = MovieType.valueOf(reader.nextLine());
                age = Integer.valueOf(reader.nextLine());
                duration = Integer.valueOf(reader.nextLine());
                Movie movie = new Movie(title, director, type, age, duration);
                hallNumber = Integer.valueOf(reader.nextLine());
                hour = reader.nextLine();
                Showing showing = new Showing(movie, hallNumber, hour);
                repertoireForDay.add(showing);
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        
        return repertoireForDay;
    }
    
}

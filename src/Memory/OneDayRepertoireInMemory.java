package Memory;

import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import ObjectsInCinema.OneDayRepertoire;
import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OneDayRepertoireInMemory{
    
    public static void save(OneDayRepertoire oneDayRepertoire, DateFormatting date) {
        File oneDayRep = new File("Repertoires/repertoireFor "+date.withoutHoursDateFormat()+".txt");
        ArrayList<Showing> repertoireForDay = oneDayRepertoire.getRepertoireForDay();
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

    public static OneDayRepertoire load(DateFormatting date) {
        File oneDayRep = new File("Repertoires/repertoireFor "+date.withoutHoursDateFormat()+".txt");
        ArrayList<Showing> repertoireForDay = new ArrayList();
        try {
            Scanner reader = new Scanner(oneDayRep);
            while(reader.hasNextLine()){
                String title = reader.nextLine();
                String director = reader.nextLine();
                MovieType type = MovieType.valueOf(reader.nextLine());
                int age = Integer.valueOf(reader.nextLine());
                int duration = Integer.valueOf(reader.nextLine());
                Movie movie = new Movie(title, director, type, age, duration);
                int hallNumber = Integer.valueOf(reader.nextLine());
                String hour = reader.nextLine();
                Showing showing = new Showing(movie, hallNumber, hour);
                repertoireForDay.add(showing);
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        OneDayRepertoire oneDayRepertoire = new OneDayRepertoire(date);
        oneDayRepertoire.setRepertoireForDay(repertoireForDay);
        return oneDayRepertoire;
    }
    
    //do testow dopisalam
    
     public static boolean saveWithBool(OneDayRepertoire oneDayRepertoire, DateFormatting date) {
        File oneDayRep = new File("Repertoires/repertoireFor "+date.withoutHoursDateFormat()+".txt");
        ArrayList<Showing> repertoireForDay = oneDayRepertoire.getRepertoireForDay();
        boolean isSaved;
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
        } catch (Exception ex) {
            return isSaved=false;
        }
        return isSaved=true;
    }
}

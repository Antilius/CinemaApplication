package Memory;

import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MoviesInMemory {
    
    public static void save(HashMap movies) {
        File moviesFile = new File("movies.txt");
        Set keys = movies.keySet();
        try {
            PrintWriter write = new PrintWriter(moviesFile);
            for (Object key: keys) {
               Movie movie = (Movie) movies.get(key);
               write.println(movie.getTitle());
               write.println(movie.getDirector());
               write.println(movie.getType());
               write.println(movie.getAge());
               write.println(movie.getDuration());
            }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    public static HashMap load(){
        File moviesFile = new File ("movies.txt");
        HashMap<String, Movie> movies = new HashMap();
        try {
            Scanner reader = new Scanner(moviesFile);
            while(reader.hasNextLine()){
                String title = reader.nextLine();
                String director = reader.nextLine();
                MovieType movieType = MovieType.valueOf(reader.nextLine());
                int age = Integer.parseInt(reader.nextLine());
                int duration = Integer.parseInt(reader.nextLine());
                Movie movie = new Movie(title, director, movieType, age, duration);
                movies.put(title, movie);
            }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
                }
        return movies;
    }
    
    //dopisane tylko testow
    public static HashMap load(String file){
        File moviesFile = new File (file);
        HashMap<String, Movie> movies = new HashMap();
        try {
            Scanner reader = new Scanner(moviesFile);
            while(reader.hasNextLine()){
                String title = reader.nextLine();
                String director = reader.nextLine();
                MovieType movieType = MovieType.valueOf(reader.nextLine());
                int age = Integer.parseInt(reader.nextLine());
                int duration = Integer.parseInt(reader.nextLine());
                Movie movie = new Movie(title, director, movieType, age, duration);
                movies.put(title, movie);
            }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
                }
        return movies;
    }
    
}

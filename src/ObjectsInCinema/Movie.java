package ObjectsInCinema;

public class Movie {
    
    private String title;
    private String director;
    private MovieType type;
    private int age;
    private int duration; // zakladamy ze czas trwania jest podany w minutach
    
    public Movie(){}

    public Movie(String title, String director, MovieType type, int age, int duration) {
        this.title = title;
        this.director = director;
        this.type = type;
        this.age = age;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public MovieType getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getDuration() {
        return duration;
    }
    
    
    
}

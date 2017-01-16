package ObjectsInCinema;

public class Showing {
    // showing - seans (zawiera informacje o tytule filmu, numerze sali i godzinie)
    
    private Movie movie;
    private int hallNumber;
    private String hour;
    
    public Showing(Movie movie, int hallNumber, String hour) {
        this.movie = movie;
        this.hallNumber = hallNumber;
        this.hour = hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public String getHour() {
        return hour;
    }
    
    public static int hoursToPartsOFTime(String hour){
        int boxNumber = Integer.valueOf(hour.substring(0, 2))*6+Integer.valueOf(hour.substring(3, 5))/10;
        return boxNumber;
    }
    
    public static int hourStart(String hour){
        return Integer.parseInt(hour.substring(0, 2));
    }
    
    public static int minuteStart(String hour){
        return Integer.parseInt(hour.substring(3, 5));
    }
}
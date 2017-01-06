package ObjectsInCinema;

public class CinemaHall {
    
    private int number;
    private int numberOfRows;
    private int seatsInRow;
    public int[] timeEngaged;
    
    public CinemaHall(int number, int numberOfRows, int seatsInRow, int[] timeEngaged) {
        this.number = number;
        this.numberOfRows = numberOfRows;
        this.seatsInRow = seatsInRow;
        this.timeEngaged = timeEngaged;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public int[] getTimeEngaged() {
        return timeEngaged;
    }
}

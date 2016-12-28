/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectsInCinema;

/**
 *
 * @author Hubert
 */
public class CinemaHall {
    
    private final int number;
    private final int numberOfRows;
    private final int seatsInRow;
    public int[] timeEngaged;
    public int[][] places;
    
    public CinemaHall(int number, int numberOfRows, int seatsInRow, int[] timeEngaged, int[][] places) {
        this.number = number;
        this.numberOfRows = numberOfRows;
        this.seatsInRow = seatsInRow;
        this.timeEngaged = timeEngaged;
        this.places = places;
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

    public int[][] getPlaces() {
        return places;
    }
    
    
    
    
    
}

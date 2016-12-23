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
    public int[] engaged = new int[144];
    
    public CinemaHall(int number, int numberOfRows, int seatsInRow) {
        this.number = number;
        this.numberOfRows = numberOfRows;
        this.seatsInRow = seatsInRow;
        for(int i=0; i<engaged.length; i++){
            engaged[i]=0;
        }
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
    
    
    
}

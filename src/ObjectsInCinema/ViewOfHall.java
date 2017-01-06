package ObjectsInCinema;

public class ViewOfHall {
    
    int rows;
    int seatsInRow;
    int[][] places;

    public ViewOfHall(int rows, int seatsInRow) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.places = new int[this.rows][this.seatsInRow];
        for(int i=0; i<this.rows; i++){
            for(int j=0; j<this.seatsInRow; j++){
                this.places[i][j] = 0;
            }
        }
    }

    public ViewOfHall(int rows, int seatsInRow, int[][] places) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.places = places;
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public int[][] getPlaces() {
        return places;
    }

    public void setPlaces(int[][] places) {
        this.places = places;
    }
    
}

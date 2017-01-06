package Memory;

import ObjectsInCinema.Showing;
import ObjectsInCinema.ViewOfHall;
import PersonalizedDates.DateFormatting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ViewOfHallInMemory {
    
    public static void save(ViewOfHall viewOfHall, String nazwa){
        File view = new File(nazwa);
        try {
            PrintWriter write = new PrintWriter(view);
               for(int k=0; k<viewOfHall.getRows(); k++){
                   for(int j=0; j<viewOfHall.getSeatsInRow(); j++){
                       write.print(viewOfHall.getPlaces()[k][j]);
                   }
                   write.println();
               }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }
    
    public static ViewOfHall load(Showing showing, DateFormatting date){
        int [][] places = new int [15][20];
        File view = new File("ViewsOfHalls/Hall "+showing.getHallNumber()+" for "+date.withoutHoursDateFormat()+" "+showing.getHour()+".txt"); 
        try {
            Scanner reader = new Scanner(view);
            for(int k=0; k<15; k++){
                String row = reader.nextLine();
                for(int l=0; l<20; l++){
                    places[k][l] = Integer.valueOf(row.substring(0,1));
                    row = row.substring(1);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }   
        ViewOfHall viewOfHall = new ViewOfHall(15,20,places);
        return viewOfHall;
    }
}

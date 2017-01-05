package ObjectsInCinema;

import java.util.ArrayList;
import java.util.HashMap;

public class OneDayRepertoire {
    
    private ArrayList<Showing> repertoireForDay = new ArrayList();

    public OneDayRepertoire(ArrayList repertoireForDay) {
        this.repertoireForDay = repertoireForDay;
    }
    
    public OneDayRepertoire(){};
   
    public void addShowingToRepertoire(Showing showing, HashMap cinemaHalls){
        boolean possibleToAdd = true;
        CinemaHall neededHall = null;
        for (int i=1; i<=cinemaHalls.size(); i++) {
                CinemaHall cH = (CinemaHall) cinemaHalls.get(i);
                if(cH.getNumber() == showing.getHallNumber())
                   neededHall = cH;
        }
        int part = Showing.hoursToPartsOFTime(showing.getHour());
        int duration = showing.getMovie().getDuration()/10;
        if(part+duration <= neededHall.getTimeEngaged().length){
        for (int j=part-1; j<part+duration; j++){
            if(neededHall.getTimeEngaged()[j]==1)
                possibleToAdd = false;
        }
        if(possibleToAdd == true){
            repertoireForDay.add(showing);
            for (int j=part-1; j<part+duration; j++){
            neededHall.getTimeEngaged()[j]=1;
            }
        }
        }else{
            for (int j=part-1; j<neededHall.getTimeEngaged().length; j++){
            if(neededHall.timeEngaged[j]!=0)
                possibleToAdd = false;
        }
        if(possibleToAdd == true){
            repertoireForDay.add(showing);
            for (int j=part-1; j<neededHall.timeEngaged.length; j++){
            neededHall.timeEngaged[j]=1;
            }
        }
        }
    }

    public ArrayList<Showing> getRepertoireForDay() {
        return repertoireForDay;
    }
}
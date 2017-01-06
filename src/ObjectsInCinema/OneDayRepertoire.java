package ObjectsInCinema;

import Memory.ViewOfHallInMemory;
import PersonalizedDates.DateFormatting;
import java.util.ArrayList;
import java.util.HashMap;

public class OneDayRepertoire {
    
    private ArrayList<Showing> repertoireForDay = new ArrayList();
    private String date;
    
    public OneDayRepertoire(DateFormatting date){
    this.date = date.withoutHoursDateFormat();
    };
   
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
            String nazwa = "ViewsOfHalls/Hall "+showing.getHallNumber()+" for "+this.date+" "+showing.getHour()+".txt";
            ViewOfHallInMemory.save(new ViewOfHall(15,20), nazwa);
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
            String nazwa = "ViewsOfHalls/Hall "+showing.getHallNumber()+" for "+this.date+" "+showing.getHour()+".txt";
            ViewOfHallInMemory.save(new ViewOfHall(15,20), nazwa);
        }
        }
    }

    public ArrayList<Showing> getRepertoireForDay() {
        return repertoireForDay;
    }

    public void setRepertoireForDay(ArrayList<Showing> repertoireForDay) {
        this.repertoireForDay = repertoireForDay;
    }
}
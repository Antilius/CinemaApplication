package Memory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day {
    
    Date date = new Date();
    
    public Day (){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String dateToString(Date currentDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = dateFormat.format(currentDate);
        //System.out.println(currentDate);
        return dateString;
    }
    
    public Date stringToDate(String sDate) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sDate;
        Date date = dateFormat.parse(dateString);
        return date;
    }
    
    
}

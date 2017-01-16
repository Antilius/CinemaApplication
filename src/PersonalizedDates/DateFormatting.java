package PersonalizedDates;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatting extends Date{

    private static final long TWENTY_FOUR_HOURS_IN_MILISECONDS=86400000; 
    
    public DateFormatting() {
        super();
    }

    public DateFormatting(long l) {
        super(l);
    }
    
    public static DateFormatting nextDay(DateFormatting date){
        return new DateFormatting(date.getTime()+TWENTY_FOUR_HOURS_IN_MILISECONDS);
    }
    
    public static DateFormatting previousDay(DateFormatting date){
        return new DateFormatting(date.getTime()-TWENTY_FOUR_HOURS_IN_MILISECONDS);
    }
    
    public static int convertTimeToMinutes(DateFormatting date){
        String hours = DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
        return Integer.parseInt(hours.substring(0, 2))*60+Integer.parseInt(hours.substring(3, hours.length()));
    }
    
    //używać tylko do testów!!!
    public static int convertTimeToMinutes(String hours){
        return Integer.parseInt(hours.substring(0, 2))*60+Integer.parseInt(hours.substring(3, hours.length()));
    }
    
    public String fullDateFormat(){
        return DateFormat.getTimeInstance(DateFormat.SHORT).format(this) + ", " + DateFormat.getDateInstance(DateFormat.LONG).format(this);
    }
  
    public String withoutHoursDateFormat(){
        return DateFormat.getDateInstance(DateFormat.LONG).format(this);
    }
    
}

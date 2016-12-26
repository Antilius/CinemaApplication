package PersonalizedDates;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatting extends Date{

    public DateFormatting() {
        super();
    }

    public DateFormatting(long l) {
        super(l);
    }
    
    public static DateFormatting nextDay(DateFormatting date){
        return new DateFormatting(date.getTime()+86400000);
    }
    
    public static DateFormatting previousDay(DateFormatting date){
        return new DateFormatting(date.getTime()-86400000);
    }
    
    public String fullDateFormat(){
        return DateFormat.getTimeInstance(DateFormat.SHORT).format(this) + ", " + DateFormat.getDateInstance(DateFormat.LONG).format(this);
    }
  
    public String withoutHoursDateFormat(){
        return DateFormat.getDateInstance(DateFormat.LONG).format(this);
    }
}

package GUI;

import GUI.Buttons.ButtonInRepertoirePanel;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class RepertoireForDayPanel extends JPanel{
    
    private static final Color COLOR_OF_BACKGROUND=Color.WHITE;
    
    public RepertoireForDayPanel(DateFormatting date){
        printThis(date);
    }
    
    public void printThis(DateFormatting date){
        //setting fields
        //setting properties
        //this.setLayout(null);
        this.setBackground(COLOR_OF_BACKGROUND);//opcjonalnie można ustawić obraz na tło      
        this.setVisible(true);
        //adding components
        JPanel date_bar_buttons = new JPanel();
        date_bar_buttons.setBackground(COLOR_OF_BACKGROUND);
            ButtonInRepertoirePanel previous = new ButtonInRepertoirePanel(DateFormatting.previousDay(date).withoutHoursDateFormat(),this,12, Color.GRAY, Color.RED, COLOR_OF_BACKGROUND,DateFormatting.previousDay(date),true);
            date_bar_buttons.add(previous.getThisButtonAsJButton());
                JLabel actual = new JLabel(date.withoutHoursDateFormat());
                actual.setBackground(COLOR_OF_BACKGROUND);
                actual.setForeground(Color.BLACK);
                actual.setFont(new Font("Times Roman",Font.PLAIN,20));
            date_bar_buttons.add(actual);
            ButtonInRepertoirePanel next = new ButtonInRepertoirePanel(DateFormatting.nextDay(date).withoutHoursDateFormat(),this,12, Color.GRAY, Color.RED, COLOR_OF_BACKGROUND,DateFormatting.nextDay(date),true);
            date_bar_buttons.add(next.getThisButtonAsJButton());
        this.add(date_bar_buttons);
        //setting layout
    }
}

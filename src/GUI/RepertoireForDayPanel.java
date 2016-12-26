package GUI;

import GUI.Buttons.ButtonInRepertoirePanel;
import ObjectsInCinema.Movie;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class RepertoireForDayPanel extends JPanel{
    
    public static final int MAX_PANEL_WIDTH=MainFrame.setPossibleDimensionWidth();
    
    private static final Color COLOR_OF_BACKGROUND=Color.WHITE;
    
    public RepertoireForDayPanel(DateFormatting date){
        printThis(date);
    }
    
    public void printThis(DateFormatting date){
        //setting local variables
        int total_height=0;
        //setting properties
        this.setLayout(null);
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
            date_bar_buttons.setOpaque(true);
        this.add(date_bar_buttons);
        
        JPanel complete_rep = new RepertoirePreview(new LinkedList<Movie>());
        this.add(complete_rep);
        //setting layout
        Dimension date_bar_buttons_size = date_bar_buttons.getPreferredSize();
        Dimension complete_rep_size = complete_rep.getPreferredSize();
        date_bar_buttons.setBounds((MAX_PANEL_WIDTH-date_bar_buttons_size.width)/2, 0, date_bar_buttons_size.width, date_bar_buttons_size.height);
        complete_rep.setBounds(0, date_bar_buttons_size.height, complete_rep_size.width, complete_rep_size.height);
        
        total_height=date_bar_buttons_size.height+complete_rep_size.height;
        this.setPreferredSize(new Dimension(MAX_PANEL_WIDTH,total_height));
    }
}

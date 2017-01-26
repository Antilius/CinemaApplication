package GUI.Buttons;

import GUI.ConfirmingBookingFrame;
import GUI.ShowingFrame;
import GUI.ShowingPanel;
import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PlaceButton extends JButton implements MouseListener{

    private final Color main_color;
    private final Color mouse_on_button_color;
    private final Color background;
    private final int row;
    private final int seat;
    private Showing showing;
    private String user;
    private ShowingPanel whatToActualize;
    private DateFormatting date;
    
    public PlaceButton(ShowingPanel whatToActualize, DateFormatting date, String user, Showing showing, String textInsideButton, int text_size, Color main_color, Color mouse_on_button_color, Color background_color, int row, int seat) {
        super(textInsideButton);
        this.setFont(new Font("Times Roman",Font.PLAIN,text_size));
        this.main_color = main_color;
        this.mouse_on_button_color = mouse_on_button_color;
        this.background=background_color;
        this.setOpaque(true);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(background_color);
        this.setForeground(main_color);       
        this.row = row;
        this.seat = seat;
        this.showing = showing;
        this.user = user;
        this.date = date;
        this.whatToActualize = whatToActualize;
        this.addMouseListener(this);
    }

    public JButton getThisButtonAsJButton(){
        return this;
    }
    @Override
    public void mouseEntered(MouseEvent mouse_event) {
        this.setForeground(this.mouse_on_button_color);
    }

    @Override
    public void mouseExited(MouseEvent mouse_event) {
        this.setForeground(this.main_color);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource() == this){
            if(!this.background.equals(Color.RED)){
               long actual_time = new DateFormatting().getTime();
               long time_for_reservation = this.date.getTime();
               if(DateFormatting.TWENTY_FOUR_HOURS_IN_MILISECONDS+time_for_reservation-actual_time>0){
                   new ConfirmingBookingFrame(this.whatToActualize, this.date, this.user, this.showing,this.row, this.seat);
               }
               else{
                   JOptionPane.showMessageDialog(this,"You can't make reservation for past!", "Warning!", JOptionPane.ERROR_MESSAGE);
               } 
            }
            else{
                JOptionPane.showMessageDialog(this, "This place is actually booked.", "Incorect data !", JOptionPane.ERROR_MESSAGE);  
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        
    }
    
}

package GUI.Buttons;

import GUI.ConfirmingBookingFrame;
import GUI.ShowingPanel;
import Memory.PeopleInMemory;
import ObjectsInCinema.BookedPlace;
import ObjectsInCinema.Booking;
import ObjectsInCinema.Showing;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConfirmingBookingButton extends JButton implements ActionListener{

    private final String user;
    private final Showing showing;
    private final int row;
    private final int seat;
    private ConfirmingBookingFrame context;
    private ShowingPanel actualize;
    private DateFormatting date;
    
    public ConfirmingBookingButton(String user, Showing showing, int row, int seat, ConfirmingBookingFrame context, ShowingPanel actualize, DateFormatting date) {
        super("OK");
        this.setFont(new Font("Times Roman",Font.PLAIN,15));
        this.user = user;
        this.showing = showing;
        this.row = row;
        this.seat = seat;
        this.context = context;
        this.actualize = actualize;
        this.date = date;
        this.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent event) {
       if(event.getSource() == this){        
              if(!this.user.equals("") && !this.user.equals("Guest")){               
                BookedPlace place = new BookedPlace(this.row, this.seat);
                HashMap<String, Person>  people = PeopleInMemory.load();
                Person person = people.get(user);
                Booking booking = new Booking(new DateFormatting(), person, showing, place);
                boolean b = booking.acceptingBooking(booking);
                this.context.setVisible(false);
                this.actualize.removeAll();
                this.actualize.printThis(this.user, this.showing, this.date);
                this.actualize.revalidate();
                this.actualize.repaint();
                if(b == true){
                    JOptionPane.showMessageDialog(this, "Your booking was succesfully added.", "Thanks for your booking !", JOptionPane.PLAIN_MESSAGE);                            
                }
              }
              else{
                  JOptionPane.showMessageDialog(this, "You are visiting our application as a guest. Log in or sign up to make a booking", "Not registered user !", JOptionPane.ERROR_MESSAGE);  
              }
        }
    }
    
}

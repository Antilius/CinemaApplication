package GUI.Buttons;

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConfirmingBookingButton extends JButton implements ActionListener{

    private final String user;
    private final Showing showing;
    private final int row;
    private final int seat;
    
    public ConfirmingBookingButton(String user, Showing showing, int row, int seat) {
        super("OK");
        this.setFont(new Font("Times Roman",Font.PLAIN,15));
        this.addActionListener(this);
        this.user = user;
        this.showing = showing;
        this.row = row;
        this.seat = seat;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent event) {
       if(event.getSource() == this){
           if(this.user.equals(""))
               JOptionPane.showMessageDialog(this, "You are visiting our application as a guest. Log in or sign up to make a booking", "Not registered user !", JOptionPane.ERROR_MESSAGE);  
           BookedPlace place = new BookedPlace(this.row, this.seat);
           HashMap<String, Person>  people = PeopleInMemory.load();
           Person person = people.get(user);
           Booking booking = new Booking(new DateFormatting(), person, showing, place);
           boolean b = booking.acceptingBooking(booking);
           if(b == true){
              JOptionPane.showMessageDialog(this, "Your booking was succesfully added.", "Thanks for your booking !", JOptionPane.ERROR_MESSAGE);  
           } else
              JOptionPane.showMessageDialog(this, "This place is actually booked.", "Incorect data !", JOptionPane.ERROR_MESSAGE);  
          
       }
    }
    
}

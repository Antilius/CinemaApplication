package GUI;

import GUI.Buttons.ConfirmingBookingButton;
import GUI.Buttons.PlaceButton;
import GUI.TextPainters.MultiLineTextPainter;
import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class ConfirmingBookingPanel extends JPanel {
    
    private ShowingPanel connection_between_frames;
    private DateFormatting date;

    public ConfirmingBookingPanel(ShowingPanel connection_between_frames, DateFormatting date, String user, Showing showing, int row, int seat, ConfirmingBookingFrame whereAmI) {
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło      
        this.setVisible(true);
        this.connection_between_frames = connection_between_frames;
        this.date = date;
        this.printThis(user, showing, row, seat, whereAmI);     
    } 
    
    public void printThis(String user, Showing showing, int row, int seat, ConfirmingBookingFrame whereAmI) {
        //setting properties
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //adding components
        MultiLineTextPainter text1 = new MultiLineTextPainter("Check and Confirm Your reservation for: " + String.valueOf(showing.getMovie().getTitle())+ " Row " + String.valueOf(row) + " Seat " + String.valueOf(seat),
                new Font("Times Roman", Font.BOLD, 20), Color.RED, Color.BLACK, 500);

        text1.setFont(new Font("Times Roman", Font.BOLD, 20));
        text1.setForeground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(text1, c);
        ConfirmingBookingButton button = new ConfirmingBookingButton(user,showing, row, seat, whereAmI, this.connection_between_frames, this.date);
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(button);
    }

}

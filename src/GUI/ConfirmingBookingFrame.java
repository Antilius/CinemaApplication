package GUI;

import GUI.Buttons.PlaceButton;
import static GUI.ShowingFrame.MOVIE_FRAME_POSITION_Y;
import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import javax.swing.JFrame;

public class ConfirmingBookingFrame extends JFrame {
 
    private static final String BOOKING_FRAME_TITLE = "Booking: ";
    
    public static final int BOOKING_FRAME_POSITION_X = MainFrame.FRAME_X_POSITION;
    public static final int BOOKING_FRAME_POSITION_Y = MainFrame.FRAME_Y_POSITION;
    
    private ShowingPanel connection_between_frames;
    private DateFormatting date;
    
    public ConfirmingBookingFrame(ShowingPanel connection_between_frames, DateFormatting date, String user, Showing showing, int row, int seat){
        super(BOOKING_FRAME_TITLE);
        this.setLocation(BOOKING_FRAME_POSITION_X, MOVIE_FRAME_POSITION_Y);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.connection_between_frames=connection_between_frames;
        this.date=date;
        this.add(new ConfirmingBookingPanel(connection_between_frames, date, user, showing, row, seat, this));
        this.getContentPane();
        this.pack();
        this.setVisible(true);
    }
    
    
}

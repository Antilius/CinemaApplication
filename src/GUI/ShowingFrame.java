package GUI;

import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import javax.swing.JFrame;

public class ShowingFrame extends JFrame {

private static final String MOVIE_FRAME_TITLE = "Showing: ";
    
    public static final int MOVIE_FRAME_POSITION_X = MainFrame.FRAME_X_POSITION;
    public static final int MOVIE_FRAME_POSITION_Y = MainFrame.FRAME_Y_POSITION;
    
    public ShowingFrame(String user, Showing showing, DateFormatting date){
        super(MOVIE_FRAME_TITLE);
        this.setLocation(MOVIE_FRAME_POSITION_X, MOVIE_FRAME_POSITION_Y);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.add(new ShowingPanel(user, showing, date));
        this.getContentPane();
        this.pack();
        this.setVisible(false);
    }
    
    
    
}

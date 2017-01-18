package GUI.Admin;

import GUI.MainFrame;
import java.awt.Dimension;
import javax.swing.JFrame;

public class AdminFrame extends JFrame{
    
    private static final String ADMIN_FRAME_TITLE = "Administrator: ";
    
    public static final int ADMIN_FRAME_POSITION_X = MainFrame.FRAME_X_POSITION+(MainFrame.readPossibleDimensionWidth()/4);
    public static final int ADMIN_FRAME_POSITION_Y = MainFrame.FRAME_Y_POSITION+(MainFrame.readPossibleDimensionHeight()/4);
    
    public AdminFrame(String admin){
        super(ADMIN_FRAME_TITLE+admin);
        this.setLocation(ADMIN_FRAME_POSITION_X, ADMIN_FRAME_POSITION_Y);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.add(new AdminPanel());
        this.getContentPane();
        this.pack();
        this.setVisible(true);
    }
    
    
}

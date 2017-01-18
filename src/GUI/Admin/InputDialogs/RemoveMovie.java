package GUI.Admin.InputDialogs;

import GUI.Admin.InputDialogs.Factory.PanelFactory;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveMovie implements PanelFactory{

    private JTextField title;
    
    public RemoveMovie(JTextField title) {
        this.title = title;
    }

    
    @Override
    public JComponent preparePanelForDialog() {
        JPanel movie = new JPanel();
        movie.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        movie.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();   
                
        //title
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        JLabel title = new JLabel("Please, type below title for movie to remove:");
        movie.add(title,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 1;
        movie.add(this.title,c);
        
        return movie;
    }
    
}

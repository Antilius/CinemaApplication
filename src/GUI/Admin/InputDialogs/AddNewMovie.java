package GUI.Admin.InputDialogs;

import GUI.Admin.InputDialogs.Factory.PanelFactory;
import ObjectsInCinema.MovieType;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewMovie implements PanelFactory{

    private JTextField title;
    private JTextField director;
    private JComboBox type;
    private JTextField age;
    private JTextField duration;

    public AddNewMovie(JTextField title, JTextField director, JTextField age, JTextField duration) {
        this.title = title;
        this.director = director;
        String[] whatUserCanChooseFromComboBox = new String[MovieType.values().length];
        for(int i=0;i<whatUserCanChooseFromComboBox.length;i++){
            whatUserCanChooseFromComboBox[i]=MovieType.values()[i].toString();
        }
        this.type = new JComboBox(whatUserCanChooseFromComboBox);
        this.age = age;
        this.duration = duration;
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
        JLabel title = new JLabel("Please, type below title for new movie:");
        movie.add(title,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 1;
        movie.add(this.title,c);
        
        //director
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 2;
        JLabel director = new JLabel("Please, type below director for new movie:");
        movie.add(director,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 3;
        movie.add(this.director,c);
        
        //type
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 4;
        JLabel type = new JLabel("Please, choose movie type for new movie:");
        movie.add(type,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 5;     
        movie.add(this.type,c);
                
        //age
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 6;
        JLabel age = new JLabel("Please, type age for new movie:");
        movie.add(age,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 7;
        movie.add(this.age,c);
        
        //duration
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 8;
        JLabel duration = new JLabel("Please, type duration in minutes for new movie:");
        movie.add(duration,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 9;
        movie.add(this.duration,c);

        return movie;
    }
    
}

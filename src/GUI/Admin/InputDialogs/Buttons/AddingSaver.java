package GUI.Admin.InputDialogs.Buttons;

import GUI.Admin.InputDialogs.AddNewMovie;
import GUI.Admin.InputDialogs.DialogPattern;
import Memory.MoviesInMemory;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;

public class AddingSaver extends JButton implements ActionListener{

    private AddNewMovie adding;
    
    public AddingSaver(AddNewMovie adding){
        super("Save");
        this.adding = adding;
        this.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        HashMap loaded = MoviesInMemory.load();
        Movie new_movie = new Movie(this.adding.getTitle().getText(), this.adding.getDirector().getText(), MovieType.valueOf(this.adding.getType().getSelectedItem().toString()), Integer.parseInt(this.adding.getAge().getText()), Integer.parseInt(this.adding.getDuration().getText()));
        loaded.put(new_movie.getTitle(), new_movie);
        MoviesInMemory.save(loaded);
        this.adding.getDirector().setText("");
        this.adding.getAge().setText("");
        this.adding.getDuration().setText("");
        this.adding.getTitle().setText("");
        this.adding.getType().setSelectedItem("ACTION");
    }
    
}

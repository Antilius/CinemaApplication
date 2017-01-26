package GUI.Admin.InputDialogs.Buttons;

import GUI.Admin.InputDialogs.RemoveMovie;
import Memory.MoviesInMemory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;

public class RemoveSaver extends JButton implements ActionListener{

    private RemoveMovie rem;
    
    public RemoveSaver(RemoveMovie rem) {
        super("Remove");
        this.rem = rem;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this){
            HashMap loaded = MoviesInMemory.load();
            loaded.remove(this.rem.getTitle().getText());
            this.rem.getTitle().setText("");
            this.rem.getTitle().repaint();
            MoviesInMemory.save(loaded);
        }
    }
    
}

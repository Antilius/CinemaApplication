package GUI.Admin.InputDialogs;

import GUI.Admin.InputDialogs.Factory.PanelFactory;
import Memory.MoviesInMemory;
import PersonalizedDates.DateFormatting;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class AddShowingForDay implements PanelFactory{

    public AddShowingForDay(DateFormatting date) {
        HashMap movie_loaded = MoviesInMemory.load();
        String[] whatUserCanChooseFromComboBox = (String[]) movie_loaded.keySet().toArray();

    }

    
    @Override
    public JComponent preparePanelForDialog() {
        JPanel showing = new JPanel();
        
        return showing;
    }
    
}

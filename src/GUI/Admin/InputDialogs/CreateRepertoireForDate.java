package GUI.Admin.InputDialogs;

import GUI.Admin.InputDialogs.Factory.PanelFactory;
import PersonalizedDates.DateFormatting;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateRepertoireForDate implements PanelFactory{

    private JComboBox dates_cb;
    
    public CreateRepertoireForDate() {
        this.dates_cb = createComboBoxWithDates();
    }

    public JComboBox getDates_cb() {
        return dates_cb;
    }
    
    @Override
    public JComponent preparePanelForDialog() {
        JPanel repertoireForDay = new JPanel();
        repertoireForDay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        repertoireForDay.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        JLabel dates = new JLabel("Please, choose date for planning repertoire:");
        repertoireForDay.add(dates,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,0,0,0);
        c.gridx = 0;
        c.gridy = 1;
        
        repertoireForDay.add(this.dates_cb,c); 
        
        return repertoireForDay;
    }
    
    private JComboBox createComboBoxWithDates(){
        DateFormatting date = new DateFormatting();
        String[] whatUserCanChooseFromComboBox = new String[7];
        for(int i=0;i<whatUserCanChooseFromComboBox.length;i++){
            whatUserCanChooseFromComboBox[i]=date.withoutHoursDateFormat();
            date=date.nextDay();
        }
        return new JComboBox(whatUserCanChooseFromComboBox);
    }
    
}

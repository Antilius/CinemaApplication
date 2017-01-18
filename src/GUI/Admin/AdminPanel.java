package GUI.Admin;

import GUI.Admin.InputDialogs.AddNewMovie;
import GUI.Admin.InputDialogs.CreateRepertoireForDate;
import GUI.Admin.InputDialogs.DialogPattern;
import GUI.Admin.InputDialogs.RemoveMovie;
import GUI.Buttons.ButtonShowingDialog;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminPanel extends JPanel{
    
  
    public AdminPanel(){
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło      
        this.setVisible(true);
        this.printThis();
    }

    public void printThis() {
        //setting properties
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //adding components
        JLabel text1 = new JLabel("Administration");
        text1.setFont(new Font("Times Roman",Font.BOLD,20));
        text1.setForeground(Color.WHITE);
        c.gridx=0;
        c.gridy=0;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(text1,c);
        
        JPanel button_group_1 = new JPanel();
        button_group_1.setBackground(Color.BLACK);
        ButtonShowingDialog add_movie = new ButtonShowingDialog(12, new DialogPattern("Add new movie", new AddNewMovie(new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30)).preparePanelForDialog()));
        button_group_1.add(add_movie);       
        ButtonShowingDialog remove_movie = new ButtonShowingDialog(12, new DialogPattern("Remove movie", new RemoveMovie(new JTextField(30)).preparePanelForDialog()));
        button_group_1.add(remove_movie);
        c.gridx=0;
        c.gridy=1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,0,0,0);
        this.add(button_group_1,c);
        
        JPanel button_group_2 = new JPanel();
        button_group_2.setBackground(Color.BLACK);
        ButtonShowingDialog add_repertoire = new ButtonShowingDialog(12, new DialogPattern("Create repertoire", new CreateRepertoireForDate().preparePanelForDialog()));
        button_group_2.add(add_repertoire);
        c.gridx=0;
        c.gridy=2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(button_group_2,c);
    }
    
}

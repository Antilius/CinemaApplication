package GUI.Admin.InputDialogs;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import GUI.Admin.AdminFrame;
import javax.swing.JPanel;

public class DialogPattern extends JDialog implements ActionListener{
    
    private final JButton button;
    private final JButton close = new JButton("Cancel");
    
    public DialogPattern(String title, JComponent component, JButton button){
        super();
        this.button = button;
        this.button.addActionListener(this);
        this.close.addActionListener(this);
        //setting properties
        this.setTitle(title);
        this.setResizable(false);
        this.setLocation(AdminFrame.ADMIN_FRAME_POSITION_X, AdminFrame.ADMIN_FRAME_POSITION_Y);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(component, c);

        JPanel bar_buttons = new JPanel();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        bar_buttons.add(button, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        bar_buttons.add(this.close, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(bar_buttons, c);
        
        this.getContentPane();
        this.pack(); 
    }         

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.close){
            this.dispose();
        }
        if(event.getSource() == button){
            this.dispose();
        }
    }
}

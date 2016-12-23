package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChangingPanelButtonWithText extends JButton implements ActionListener{

    private JPanel panel_to_clear;
    
    public ChangingPanelButtonWithText(String textInsideButton, JPanel panel_to_clear){
        super(textInsideButton);
        this.panel_to_clear = panel_to_clear;
        this.addActionListener(this);
    }

    public JPanel getPanelToClear() {
        return panel_to_clear;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this){
            this.getPanelToClear().setVisible(false);
        }
    }
    
}

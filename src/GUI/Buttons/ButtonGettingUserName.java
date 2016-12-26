package GUI.Buttons;

import GUI.MainPanel;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ButtonGettingUserName extends ChangingPanelButtonWithText{

    private final JTextField textfield; 
    private final MainPanel panel_to_replace;
    
    public ButtonGettingUserName(String textInsideButton, JPanel panel_to_clear, JTextField textfield, int width, int height) {
        super(textInsideButton, panel_to_clear,12);
        this.textfield=textfield;
        this.panel_to_replace=(MainPanel)panel_to_clear;
    } 
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == this){
            this.panel_to_replace.removeAll();
            this.panel_to_replace.printThisAfterLogin(this.textfield.getText(), this.panel_to_replace.getWidth(), this.panel_to_replace.getHeight());
            this.panel_to_replace.revalidate();
            this.panel_to_replace.repaint();
        }
    }
}

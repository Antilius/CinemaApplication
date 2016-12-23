package GUI;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ButtonGettingUserName extends ChangingPanelButtonWithText{

    private JTextField textfield;   
    private JFrame context;
    
    public ButtonGettingUserName(String textInsideButton, JFrame context, JPanel panel_to_clear, JTextField textfield) {
        super(textInsideButton, panel_to_clear);
        this.textfield=textfield;
        this.context=context;
    } 
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == this){
            this.getPanelToClear().setVisible(false);        
            JPanel GUIwhenLogged = new ApplicationCorePanel(this.textfield.getText(),this.context.getSize().width,this.context.getSize().height);
            this.context.add(GUIwhenLogged);
        }
    }
}

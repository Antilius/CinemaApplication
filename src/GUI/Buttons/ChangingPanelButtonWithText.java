package GUI.Buttons;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChangingPanelButtonWithText extends JButton{

    private final JPanel panel_to_clear;
    
    public ChangingPanelButtonWithText(String textInsideButton, JPanel panel_to_clear, int text_size){
        super(textInsideButton);
        this.setFont(new Font("Times Roman",Font.PLAIN,text_size));
        this.panel_to_clear = panel_to_clear;
    }

    public JPanel getPanelToClear() {
        return panel_to_clear;
    }    
}

package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class ButtonChangingTextColor extends MouseAdapter{

    private ChangingPanelButtonWithText button;
    
    public ButtonChangingTextColor(ChangingPanelButtonWithText button){
        this.button=button;
        this.button.setOpaque(true);
        this.button.setBorder(BorderFactory.createEmptyBorder());
        this.button.setBackground(Color.BLACK);
        this.button.setForeground(Color.WHITE);
        this.button.addMouseListener(this);
    }

    public ChangingPanelButtonWithText getThisButtonAsJButton(){
        return this.button;
    }
    
    @Override
    public void mouseEntered(MouseEvent mouse_event) {
        this.button.setForeground(Color.yellow);
    }

    @Override
    public void mouseExited(MouseEvent mouse_event) {
        this.button.setForeground(Color.WHITE);
    }
}

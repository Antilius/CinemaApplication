package GUI.Buttons;

import GUI.RepertoireForDayPanel;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonInRepertoirePanel extends ButtonChangingTextColor implements ActionListener,MouseListener{

    private final DateFormatting date;
    private final RepertoireForDayPanel context;
    private final boolean clickable;
    
    public ButtonInRepertoirePanel(String textInsideButton, JPanel panel_to_clear, int text_size, Color main_color, Color mouse_on_button_color, Color background_color, DateFormatting date, boolean clickable) {
        super(textInsideButton, panel_to_clear, text_size,main_color, mouse_on_button_color, background_color);
        this.date=date;
        this.context=(RepertoireForDayPanel)this.getPanelToClear();
        this.clickable=clickable;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        ((JButton)event.getSource()).addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent event) {
        
    }

    @Override
    public void mousePressed(MouseEvent event) {
        
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if(this.clickable){
            if(event.getSource() == this){
                this.context.removeAll();                
                this.context.printThis(this.date);
                this.context.revalidate();
                this.context.repaint();        
            }
        }      
    }
}

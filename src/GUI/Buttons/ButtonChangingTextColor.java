package GUI.Buttons;

import GUI.MainPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonChangingTextColor extends ChangingPanelButtonWithText implements MouseListener,ActionListener{

    private final Color main_color;
    private final Color mouse_on_button_color;
    private final JPanel context;
   
    public ButtonChangingTextColor(String textInsideButton, JPanel panel_to_clear, int text_size, Color main_color, Color mouse_on_button_color, Color background_color){
        super(textInsideButton, panel_to_clear, text_size);
        //setting fields
        this.main_color=main_color;
        this.mouse_on_button_color=mouse_on_button_color;
        this.context=this.getPanelToClear();
        //setting properties
        this.setOpaque(true);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(background_color);
        this.setForeground(main_color);
        this.addMouseListener(this);
        this.addActionListener(this);
    }

    public JButton getThisButtonAsJButton(){
        return this;
    }
    
    @Override
    public void mouseEntered(MouseEvent mouse_event) {
        this.setForeground(this.mouse_on_button_color);
    }

    @Override
    public void mouseExited(MouseEvent mouse_event) {
        this.setForeground(this.main_color);
    }

    @Override
    public void actionPerformed(ActionEvent event) {      
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
        if(event.getSource() == this){
            ((MainPanel)this.context).removeAll();
            ((MainPanel)this.context).paintProfile(((MainPanel)this.context).getWidth(),((MainPanel)this.context).getHeight());
            ((MainPanel)this.context).revalidate();
            ((MainPanel)this.context).repaint();
        }
    }
}

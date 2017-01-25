/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Buttons;

import GUI.ShowingFrame;
import GUI.TextPainters.MultiLineTextPainter;
import GUI.TextPainters.OneLineTextPainter;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Hubert
 */
public class MovieButtonInRepertoirePanel extends JButton implements MouseListener,ActionListener {

    private final Color main_color;
    private final Color mouse_on_button_color;
    private final ShowingFrame showingFrame;
    
    public MovieButtonInRepertoirePanel(MultiLineTextPainter text, int text_size, Color main_color, Color mouse_on_button_color, Color background_color, ShowingFrame showingFrame) {
        super(text.getText());
        this.main_color = main_color;
        this.mouse_on_button_color = mouse_on_button_color;
        this.showingFrame = showingFrame;
        this.setFont(new Font("Times Roman",Font.PLAIN,text_size));
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
            this.showingFrame.setVisible(true);
        }
    }
    
}

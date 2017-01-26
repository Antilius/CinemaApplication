/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Buttons;

import GUI.RepertoirePreview;
import GUI.ShowingFrame;
import GUI.TextPainters.MultiLineTextPainter;
import ObjectsInCinema.Movie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MovieButtonInRepertoirePanel extends JButton implements MouseListener{

    private final Color main_color;
    private final Color mouse_on_button_color;
    private final ShowingFrame showingFrame;
    private final Movie movie;
    
    public MovieButtonInRepertoirePanel(Movie movie, int text_size, Color main_color, Color mouse_on_button_color, Color background_color, ShowingFrame showingFrame) {
        super();
        this.main_color = main_color;
        this.mouse_on_button_color = mouse_on_button_color;
        this.showingFrame = showingFrame; 
        this.movie = movie;
        MultiLineTextPainter text = RepertoirePreview.filmLengthVisualize(movie, true);
        this.setSize(new Dimension(text.getWidth(),text.getHeight()));
        this.setBorder(BorderFactory.createEmptyBorder());
        JPanel lol = new JPanel();
        lol.setPreferredSize(new Dimension(text.getWidth(),text.getHeight()));
        lol.setLayout(null);
        lol.add(text);    
        lol.setBounds(0, 0, text.getWidth(), text.getHeight());
        this.add(lol);
        this.addMouseListener(this);
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

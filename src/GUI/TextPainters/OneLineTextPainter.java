package GUI.TextPainters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

public class OneLineTextPainter extends JLabel{

    private final String text_inside_this_label;
    private final Font font;
    private final Color font_color;
    private final Color background;
    private int positionX;
    private int positionY;
    
    
    public OneLineTextPainter(String text_inside_this_label, Font font, Color font_color, Color background) {
        //setting properties
        //this.setBackground(color);
        //this.setForeground(Color.WHITE);
        //this.setFont(font);
        //super();
        this.text_inside_this_label = text_inside_this_label;
        this.font = font;
        this.font_color = font_color;
        this.background = background;
        this.positionX = 0;
        this.positionY = 0;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Color old = g.getColor();
        g.setColor(this.background);
        g.fillRect(this.positionX, this.positionY, this.getWidth(), this.getHeight());
        g.setColor(this.font_color);
        g.setFont(this.font);
        g.drawString(this.text_inside_this_label, this.positionX, this.positionY+this.font.getSize());
        g.setColor(old);
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String getText() {
        return this.text_inside_this_label;
    }
    
    @Override
    public int getWidth(){
        return TextPainter.lengthOfStringWithSpecifiedFontInPixels(this.text_inside_this_label, this.font);
    }
    
    @Override
    public int getHeight(){
        return TextPainter.heightOfStringWithSpecifiedFontInPixels(this.text_inside_this_label, this.font);
    }

}



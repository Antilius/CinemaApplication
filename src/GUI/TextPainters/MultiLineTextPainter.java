package GUI.TextPainters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JLabel;

public class MultiLineTextPainter extends JLabel{

    private final String text_inside_this_label;
    private final LinkedList<OneLineTextPainter> oltp_list;
    private final Font font;
    private final Color font_color;
    private final Color background;
    private final int width_delimeter;
    private int height;

    public MultiLineTextPainter(String text_inside_this_label, Font font, Color font_color, Color background, int width_delimeter) {
        this.text_inside_this_label = text_inside_this_label;
        this.font = font;
        this.font_color = font_color;
        this.background = background;
        this.width_delimeter = width_delimeter;
        this.oltp_list=this.separateOnFittingSlices();
        this.setPreferredSize(new Dimension(width_delimeter,this.height));
    }
     
    @Override
    public void paintComponent(Graphics g){
        g.setColor(background);
        g.fillRect(0, 0, this.width_delimeter, this.height);
        for(OneLineTextPainter oltp:this.oltp_list){
            oltp.paintComponent(g);
        }
    }
    
    @Override
    public String getText() {
        return this.text_inside_this_label;
    }
    
    @Override
    public int getWidth(){
        return this.getPreferredSize().width;
    }
    
    @Override
    public int getHeight(){
        return this.getPreferredSize().height;
    }
    
    public void setHeight(int value){
        this.height=value;
    }

     private LinkedList<OneLineTextPainter> separateOnFittingSlices(){
        LinkedList<OneLineTextPainter> list = new LinkedList();
        String line = "";
        String absolute_rest="";
        int length = 0;
        int t_height=0;
        int positionOfStringIndex = 0;
        int posY = 0;
        while(positionOfStringIndex <= this.text_inside_this_label.length()-1){
            
            while(length<=this.width_delimeter && positionOfStringIndex <= this.text_inside_this_label.length()-1){
            line+=MultiLineTextPainter.charToString(this.text_inside_this_label.charAt(positionOfStringIndex));
            positionOfStringIndex++;
            length = TextPainter.lengthOfStringWithSpecifiedFontInPixels(line, this.font);
            }
                int i = 1;
                String rest="";
                while(!MultiLineTextPainter.charToString(line.charAt(line.length()-i)).equals(" ") && line.length()>1){
                    rest+=MultiLineTextPainter.charToString(line.charAt(line.length()-i));
                    line = line.substring(0, line.length()-i);
                }   
            OneLineTextPainter oltp = new OneLineTextPainter(line, this.font, this.font_color, null);
            oltp.setPositionY(posY);
            list.add(oltp);
            line = absolute_rest = MultiLineTextPainter.inverseString(rest);          
            length = 0;
            posY += this.font.getSize()+7;
            t_height+=this.font.getSize()+7;
        }
        String last = list.getLast().getText()+absolute_rest;
        list.removeLast();
        OneLineTextPainter lastElem = new OneLineTextPainter(last, this.font, this.font_color, null);
        lastElem.setPositionY(posY-this.font.getSize()-7);
        list.addLast(lastElem);
        this.setHeight(t_height);
        return list;
    }
    
    private static String charToString(char c){
        return ""+c;
    }
    
    private static String inverseString(String s){
        String inversed="";
        for(int i=0;i<s.length();i++){
            inversed+=MultiLineTextPainter.charToString(s.charAt(s.length()-i-1));
        }
        return inversed;
    }
}

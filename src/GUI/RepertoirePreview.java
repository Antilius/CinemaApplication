package GUI;

import GUI.TextPainters.MultiLineTextPainter;
import GUI.TextPainters.TextPainter;
import ObjectsInCinema.Movie;
import ObjectsInCinema.MovieType;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;

public class RepertoirePreview extends JPanel{
    
    private static final int BOX_WIDTH_IN_PIXELS=(MainFrame.setPossibleDimensionWidth())/144;
    private static final int HOUR_BOX_WIDTH=BOX_WIDTH_IN_PIXELS*6;
    
    private int height;
    
    public RepertoirePreview(LinkedList<Movie> movie_list) {
        super();
        this.height=0;
        printThis(movie_list);
    }

    private void printThis(LinkedList<Movie> movie_list) {     
        //setting properties
        this.setLayout(null);
        //adding components
        MultiLineTextPainter film1 = RepertoirePreview.filmLengthVisualize(new Movie("Kubuś Puchatek i przyjaciele","",MovieType.ACTION,1990,134),true);
        this.add(film1);
        MultiLineTextPainter film2 = RepertoirePreview.filmLengthVisualize(new Movie("Killerów dwóch","",MovieType.ACTION,1990,231),false);
        this.add(film2);
        //setting layout
        Dimension film1_size = film1.getPreferredSize();
        Dimension film2_size = film2.getPreferredSize(); 
        //tymczasowo - do poprawy
        int time_width = 10+TextPainter.lengthOfStringWithSpecifiedFontInPixels("23:12", new Font("Times Roman",Font.BOLD,12));
        this.setHeight(film1_size.height+film2_size.height+time_width);
        //
        
        film1.setBounds(HOUR_BOX_WIDTH*13+9, time_width, film1_size.width, film1_size.height);
        film2.setBounds(HOUR_BOX_WIDTH*10+15, time_width+film1_size.height, film2_size.width, film2_size.height);
        
        this.setPreferredSize(new Dimension(RepertoireForDayPanel.MAX_PANEL_WIDTH,this.getHeight()));
    }
    
    public static MultiLineTextPainter filmLengthVisualize(Movie m,boolean possible){
        int label_time_boxes = getWidthOfMinuteBox(m.getDuration());
        if(possible){
            return new MultiLineTextPainter(m.getTitle(),new Font("Times Roman",Font.PLAIN,12),Color.BLUE,Color.GREEN,label_time_boxes);
        }
        else{
            return new MultiLineTextPainter(m.getTitle(),new Font("Times Roman",Font.PLAIN,12),Color.BLUE,Color.RED,label_time_boxes);
        }
    } 
    
    private static int getWidthOfMinuteBox(int minutes){
        return (minutes%10>=5) ? ((minutes/10 + 1)*BOX_WIDTH_IN_PIXELS) : ((minutes/10)*BOX_WIDTH_IN_PIXELS);
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getHeight(){
        return this.height;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, RepertoireForDayPanel.MAX_PANEL_WIDTH, this.getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, RepertoireForDayPanel.MAX_PANEL_WIDTH, 0);
        g.setFont(new Font("Times Roman",Font.BOLD,12));
        g2d.rotate(Math.PI/2);
        int start_point=-HOUR_BOX_WIDTH*3/2;
        String time="";
        for(Integer i=0;i<24;i++){
            time="";
            if(i<10){
                time+="0"+i.toString();
            }
            else{
                time+=i.toString();
            }
            time+=":00";
            g.drawString(time, 5, start_point);
            start_point-=HOUR_BOX_WIDTH;
        }
        int time_width = TextPainter.lengthOfStringWithSpecifiedFontInPixels(time, new Font("Times Roman",Font.BOLD,12));
        g2d.rotate(-Math.PI/2);
        g.drawLine(0, 10+time_width, RepertoireForDayPanel.MAX_PANEL_WIDTH, 10+time_width);
        start_point=HOUR_BOX_WIDTH;
        for(int i=0;i<=24;i++){
            g.drawLine(start_point, 0, start_point, this.getHeight());
            start_point+=HOUR_BOX_WIDTH;
        }       
        super.paintComponents(g);
        Color alfa_black = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 125);
        g.setColor(alfa_black);
        DateFormatting actual_time = new DateFormatting();
        g.fillRect(HOUR_BOX_WIDTH, 10+time_width, HOUR_BOX_WIDTH+getWidthOfMinuteBox(DateFormatting.convertTimeToMinutes(actual_time)-60), this.getHeight());
    }
}

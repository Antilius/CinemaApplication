package GUI;

import GUI.Buttons.MovieButtonInRepertoirePanel;
import GUI.TextPainters.MultiLineTextPainter;
import GUI.TextPainters.TextPainter;
import Memory.OneDayRepertoireInMemory;
import ObjectsInCinema.Movie;
import ObjectsInCinema.Showing;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RepertoirePreview extends JPanel{
    
    private static final int BOX_WIDTH_IN_PIXELS=evaluateMaxWidth();
    private static final int HOUR_BOX_WIDTH=BOX_WIDTH_IN_PIXELS*6;
    
    private int height;
    
    public RepertoirePreview(String user, DateFormatting date) {
        super();
        this.height=500;
        printThis(user, date);
    }

    public static int getTotalHeight(DateFormatting date){
        int time_width = 15+TextPainter.lengthOfStringWithSpecifiedFontInPixels("12:12", new Font("Times Roman",Font.BOLD,12));
        int generalHeight = time_width;
        ArrayList<Showing> showings = OneDayRepertoireInMemory.load(date).getRepertoireForDay();
        for(Showing s:showings){
            Movie m = s.getMovie();
            MultiLineTextPainter movie = RepertoirePreview.filmLengthVisualize(m, true);
            Dimension movie_size = movie.getPreferredSize();
            generalHeight+=movie_size.height;
        }
        return generalHeight;
    }
    
    private void printThis(String user, DateFormatting date) {     
        //setting properties
        int time_width = 15+TextPainter.lengthOfStringWithSpecifiedFontInPixels("12:12", new Font("Times Roman",Font.BOLD,12));
        int generalHeight = time_width;
        this.setLayout(null);
        //adding components
        ArrayList<Showing> showings = OneDayRepertoireInMemory.load(date).getRepertoireForDay();
        for(Showing s:showings){
            ShowingFrame showingFrame = new ShowingFrame(user, s, date); 
            Movie m = s.getMovie();
            MovieButtonInRepertoirePanel movieButton = new MovieButtonInRepertoirePanel(m, 10, Color.WHITE, Color.RED, Color.BLACK, showingFrame);
            this.add(movieButton);
            Dimension movie_size = movieButton.getPreferredSize();
            int startX = HOUR_BOX_WIDTH*(1+Showing.hourStart(s.getHour()))+getWidthOfMinuteBox(Showing.minuteStart(s.getHour()));
            movieButton.setBounds(startX, generalHeight, movie_size.width, movie_size.height);
            generalHeight+=movie_size.height;
            //this.setHeight(generalHeight);
        }
        this.setPreferredSize(new Dimension(RepertoireForDayPanel.MAX_PANEL_WIDTH,500));
    }
    
    public static MultiLineTextPainter filmLengthVisualize(Movie m,boolean possible){
        int label_time_boxes = getWidthOfMinuteBox(m.getDuration());
        if(possible){
            return new MultiLineTextPainter(m.getTitle(),new Font("Times Roman",Font.BOLD,12),Color.BLUE,Color.GREEN,label_time_boxes);
        }
        else{
            return new MultiLineTextPainter(m.getTitle(),new Font("Times Roman",Font.BOLD,12),Color.BLUE,Color.RED,label_time_boxes);
        }
    } 
    
    private static int getWidthOfMinuteBox(int minutes){
        return (minutes%10>=5) ? ((minutes/10 + 1)*BOX_WIDTH_IN_PIXELS) : ((minutes/10)*BOX_WIDTH_IN_PIXELS);
    }

    public static int evaluateMaxWidth(){
        return ((MainFrame.readPossibleDimensionWidth()/144)*150>=MainFrame.readPossibleDimensionWidth()) ? ((MainFrame.readPossibleDimensionWidth()/144)-1) : (MainFrame.readPossibleDimensionWidth()/144);
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
        Color alfa_black = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), 125);
        g.setColor(alfa_black);
        DateFormatting actual_time = new DateFormatting();
        g.fillRect(HOUR_BOX_WIDTH, 10+time_width, HOUR_BOX_WIDTH+getWidthOfMinuteBox(DateFormatting.convertTimeToMinutes(actual_time)-60), this.getHeight());
    }
}

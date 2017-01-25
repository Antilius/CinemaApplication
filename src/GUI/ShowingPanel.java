package GUI;

import GUI.Buttons.PlaceButton;
import Memory.ViewOfHallInMemory;
import ObjectsInCinema.Showing;
import ObjectsInCinema.ViewOfHall;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowingPanel extends JPanel{
    
    private final Showing showing;
    private final String user;

    public ShowingPanel(String user, Showing showing, DateFormatting date) {
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło      
        this.setVisible(true);
        this.printThis(user, showing, date);
        this.showing = showing;
        this.user = user;
    }
    
    public void printThis(String user,Showing showing, DateFormatting date) {
        
        String nazwa = ("ViewsOfHalls/Hall "+showing.getHallNumber()+" for "+date.withoutHoursDateFormat()+" "+showing.getHour()+".txt"); 
        ViewOfHall viewOfHall = ViewOfHallInMemory.load(showing, date);
        Color background;
        //setting properties
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //adding components
        JLabel text1 = new JLabel(showing.getMovie().getTitle()+" - "+showing.getHour());
        text1.setFont(new Font("Times Roman",Font.BOLD,20));
        text1.setForeground(Color.WHITE);
        c.gridx=0;
        c.gridy=0;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(text1,c);
        JLabel text2 = new JLabel("Choose your place, green are free");
        text2.setFont(new Font("Times Roman",Font.BOLD,20));
        text2.setForeground(Color.WHITE);
        c.gridx=0;
        c.gridy=1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(text2,c);
        
        PlaceButton placeButton;
        for(int i=1; i<=15; i++){
            JPanel button_group = new JPanel();
            button_group.setBackground(Color.BLACK);
            JLabel text3;
            if(i<10)
            text3 = new JLabel(String.valueOf(i)+"  ");
            else
            text3 = new JLabel(String.valueOf(i)+" ");
            text3.setFont(new Font("Times Roman",Font.BOLD,20));
            text3.setForeground(Color.WHITE);
            c.gridx=0;
            c.gridy=i+1;
            c.fill = GridBagConstraints.HORIZONTAL;
            button_group.add(text3,c);
            for(int j=1; j<=20; j++){
                if(viewOfHall.getPlaces()[i-1][j-1]==1)
                background = Color.gray;
                else
                background = Color.green;
                placeButton = new PlaceButton(user, showing, String.valueOf(j), this, 20, Color.BLACK, Color.RED, background, i, j);
                button_group.add(placeButton);
            }   
         this.add(button_group,c);
        }
        
    }
    
    
}

package GUI;

import GUI.Buttons.ButtonChangingTextColor;
import GUI.Buttons.ButtonGettingUser;
import Memory.BookingInMemory;
import Memory.PeopleInMemory;
import ObjectsInCinema.Booking;
import People.Person;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public final class MainPanel extends JPanel{
    
    private final int width;
    private final int height;
    
    public MainPanel(int width, int height){      
        this.width=width;
        this.height=height;
        printThis(width,height);
    }
    
    @Override
    public int getWidth(){
        return this.width;
    }
    
    @Override
    public int getHeight(){
        return this.height;
    }
    
    public void printThis(int width, int height){
        //setting properties
        this.setLayout(null);
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło      
        this.setSize(new Dimension(width, height));
        this.setVisible(true); 
        
        //adding components
        JLabel text = new JLabel("Login to your cinema account:");
        text.setFont(new Font("Times Roman",Font.PLAIN,20));
        text.setForeground(Color.white);
        this.add(text);
        
        JTextField loginField = new JTextField(25);
        this.add(loginField);
        JPasswordField passwordField = new JPasswordField(25);
        this.add(passwordField);
        JButton logIn = new ButtonGettingUser("Login",this,loginField,passwordField,width,height);
        this.add(logIn);
        
        //setting layout
        Dimension text_size = text.getPreferredSize();
        Dimension login_size = loginField.getPreferredSize();
        Dimension password_size = passwordField.getPreferredSize();
        Dimension button_login_size = logIn.getPreferredSize();
        
        text.setBounds((width-text_size.width)/2, 50, text_size.width, text_size.height);
        loginField.setBounds((width-login_size.width)/2, 200, login_size.width, login_size.height);
        passwordField.setBounds((width-password_size.width)/2, 250, password_size.width, password_size.height);   
        logIn.setBounds((width-button_login_size.width)/2, 300, button_login_size.width, button_login_size.height);  
    }

    public void printThisAfterLogin(String user, int width, int height) {
        //seting properties       
        this.setLayout(null);
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło   
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);   
        //adding components
        JLabel logo = new JLabel("LOGO", SwingConstants.CENTER);
            logo.setPreferredSize(new Dimension(200,100));
            logo.setFont(new Font("Times Roman",Font.PLAIN,40));
            logo.setForeground(Color.BLACK);
            logo.setOpaque(true);
            logo.setBackground(Color.WHITE);
        this.add(logo);
        
        JPanel user_panel = this.prepareUserPanel(user);
        this.add(user_panel);
        
        JPanel rep = new RepertoireForDayPanel(new DateFormatting());
        this.add(rep);
        //setting layout
        Dimension logo_size = logo.getPreferredSize();
        Dimension user_panel_size = user_panel.getPreferredSize();
        Dimension rep_size = rep.getPreferredSize();
        
        logo.setBounds(10, 10, logo_size.width, logo_size.height);
        user_panel.setBounds(width-user_panel_size.width-20, 10, user_panel_size.width, user_panel_size.height);
        rep.setBounds((width-rep_size.width)/2, 200, rep_size.width, rep_size.height);
    }
    
    public void printProfile(String user, int width,int height){
        HashMap<String, Person> users = PeopleInMemory.load();
        ArrayList<Booking> bookings = BookingInMemory.load(user);
        Person person = users.get(user);
        //setting properties
        this.setLayout(null);
        this.setBackground(Color.BLACK);  
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
        //adding components
        if(!user.equals("Guest")){
        JLabel text1 = new JLabel("Twój profil:");
        text1.setFont(new Font("Times Roman",Font.BOLD,20));
        text1.setForeground(Color.ORANGE);
        this.add(text1);
        JLabel text2 = new JLabel("Rezerwacje: ");
        text2.setFont(new Font("Times Roman",Font.BOLD,20));
        text2.setForeground(Color.ORANGE);
        this.add(text2);
        JLabel text3 = new JLabel("Imie i nazwisko: "+person.getName()+" "+person.getSurname());
        text3.setFont(new Font("Times Roman",Font.BOLD,20));
        text3.setForeground(Color.RED);
        this.add(text3);
        JLabel text4 = new JLabel("Email: "+person.getEmail());
        text4.setFont(new Font("Times Roman",Font.BOLD,20));
        text4.setForeground(Color.RED);
        this.add(text4);
        JLabel text5;
        if(person.isCanChange())
            text5 = new JLabel("Rodzaj konta: Administrator");
        else
            text5 = new JLabel("Rodzaj konta: Użytkownik");
        text5.setFont(new Font("Times Roman",Font.BOLD,20));
        text5.setForeground(Color.RED);
        this.add(text5);
        JLabel text8;
        for(int i=0; i<bookings.size(); i++){
            text8 = new JLabel("- Tytuł: "+bookings.get(i).getShowing().getMovie().getTitle()+" Data: "+bookings.get(i).getDate().withoutHoursDateFormat()+" Godzina: "+bookings.get(i).getShowing().getHour()+" Sala: "+bookings.get(i).getShowing().getHallNumber());
            text8.setFont(new Font("Times Roman",Font.BOLD,20));
            text8.setForeground(Color.RED);
            this.add(text8);
            Dimension text8_size = text8.getPreferredSize();
            text8.setBounds(20, 205 + i*25,text8_size.width, text8_size.height);
        }
        //setting layout
        Dimension text1_size = text1.getPreferredSize();
        Dimension text2_size = text2.getPreferredSize();
        Dimension text3_size = text3.getPreferredSize();
        Dimension text4_size = text4.getPreferredSize();
        Dimension text5_size = text5.getPreferredSize();
        
        text1.setBounds(10, 10,text1_size.width, text1_size.height);
        text2.setBounds(10, 180,text2_size.width, text2_size.height);
        text3.setBounds(20, 60,text3_size.width, text3_size.height);
        text4.setBounds(20, 90,text4_size.width, text4_size.height);
        text5.setBounds(20, 120,text5_size.width, text5_size.height);
        }else{
            JLabel text6 = new JLabel("Korzystasz z aplikacji jako gość. ");
            text6.setFont(new Font("Times Roman",Font.BOLD,20));
            text6.setForeground(Color.RED);
            this.add(text6);
            JLabel text7 = new JLabel("Zaloguj się, aby przeglądać szczegóły dotyczące Twojego konta.");
            text7.setFont(new Font("Times Roman",Font.BOLD,20));
            text7.setForeground(Color.RED);
            this.add(text7);
            Dimension text6_size = text6.getPreferredSize();
            Dimension text7_size = text7.getPreferredSize();
            text6.setBounds(10, 10, text6_size.width, text6_size.height);
            text7.setBounds(10, 40, text7_size.width, text7_size.height);
        }
    }
    
    private JPanel prepareUserPanel(String user){
        Color background = Color.BLACK;
        JPanel user_panel = new JPanel();
        user_panel.setBackground(background);
                JLabel welcome = new JLabel("Welcome,");
                welcome.setOpaque(true);
                welcome.setFont(new Font("Times Roman",Font.PLAIN,20));
                welcome.setBackground(Color.BLACK);
                welcome.setForeground(Color.WHITE);
        user_panel.add(welcome);
                ButtonChangingTextColor username_button_object;
                if(user.equals("")){
                    username_button_object = new ButtonChangingTextColor("Guest",this,20,Color.WHITE,Color.RED,background);
                }
                else{
                    username_button_object = new ButtonChangingTextColor(user,this,20,Color.WHITE,Color.RED,background);
                }
                JButton username_button = username_button_object.getThisButtonAsJButton();
        user_panel.add(username_button);
                JLabel screamer = new JLabel("!");
                screamer.setOpaque(true);
                screamer.setFont(new Font("Times Roman",Font.PLAIN,20));
                screamer.setBackground(Color.BLACK);
                screamer.setForeground(Color.WHITE);
        user_panel.add(screamer);
        return user_panel;
    }
}


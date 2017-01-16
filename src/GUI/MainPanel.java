package GUI;

import GUI.Buttons.ButtonChangingTextColor;
import GUI.Buttons.ButtonGettingUser;
import PersonalizedDates.DateFormatting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    
    public void printProfile(int width,int height){
        //setting properties
        this.setLayout(null);
        this.setBackground(Color.BLACK);  
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
        //adding components
        JLabel text1 = new JLabel("Twój profil:");
        text1.setFont(new Font("Times Roman",Font.BOLD,20));
        text1.setForeground(Color.ORANGE);
        this.add(text1);
        JLabel photo = new JLabel("PHOTO", SwingConstants.CENTER);
            photo.setPreferredSize(new Dimension(200,200));
            photo.setFont(new Font("Times Roman",Font.PLAIN,40));
            photo.setForeground(Color.BLACK);
            photo.setOpaque(true);
            photo.setBackground(Color.WHITE);
        this.add(photo);
        JLabel text2 = new JLabel("Rezerwacje: ");
        text2.setFont(new Font("Times Roman",Font.BOLD,20));
        text2.setForeground(Color.ORANGE);
        this.add(text2);
        JLabel text3 = new JLabel("Imie i nazwisko");
        text3.setFont(new Font("Times Roman",Font.BOLD,20));
        text3.setForeground(Color.ORANGE);
        this.add(text3);
        JLabel text4 = new JLabel("Email");
        text4.setFont(new Font("Times Roman",Font.BOLD,20));
        text4.setForeground(Color.ORANGE);
        this.add(text4);
        JLabel text5 = new JLabel("Rodzaj konta");
        text5.setFont(new Font("Times Roman",Font.BOLD,20));
        text5.setForeground(Color.ORANGE);
        this.add(text5);
        //setting layout
        Dimension text1_size = text1.getPreferredSize();
        Dimension photo_size = photo.getPreferredSize();
        Dimension text2_size = text2.getPreferredSize();
        Dimension text3_size = text3.getPreferredSize();
        Dimension text4_size = text4.getPreferredSize();
        Dimension text5_size = text5.getPreferredSize();
        
        text1.setBounds(10, 10,text1_size.width, text1_size.height);
        text2.setBounds(10, 300,text2_size.width, text2_size.height);
        text3.setBounds(220, 60,text3_size.width, text3_size.height);
        text4.setBounds(220, 90,text4_size.width, text4_size.height);
        text5.setBounds(220, 120,text5_size.width, text5_size.height);
        photo.setBounds(10, 60, photo_size.width, photo_size.height);
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


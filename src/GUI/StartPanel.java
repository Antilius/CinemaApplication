package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StartPanel extends JPanel{
    
    public StartPanel(JFrame context, int width, int height){      
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
        JButton logIn = new ButtonGettingUserName("Login",context,this,loginField);
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
}


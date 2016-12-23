package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ApplicationCorePanel extends JPanel{

    public ApplicationCorePanel(String user,int width, int height){
        //seting properties
        this.setLayout(null);
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło       
        this.setSize(new Dimension(width,height));
        this.setVisible(true);   
        //adding components
        JLabel logo = new JLabel("LOGO", SwingConstants.CENTER);
            logo.setPreferredSize(new Dimension(200,100));
            logo.setFont(new Font("Times Roman",Font.PLAIN,40));
            logo.setForeground(Color.BLACK);
            logo.setOpaque(true);
            logo.setBackground(Color.WHITE);
        this.add(logo);
        JPanel user_panel = new JPanel();
        user_panel.setBackground(Color.BLACK);
                JLabel welcome = new JLabel("Welcome,");
                welcome.setOpaque(true);
                welcome.setFont(new Font("Times Roman",Font.PLAIN,25));
                welcome.setBackground(Color.BLACK);
                welcome.setForeground(Color.WHITE);
        user_panel.add(welcome);
                ButtonChangingTextColor username_button_object;
                if(user.equals("")){
                    username_button_object = new ButtonChangingTextColor(new ChangingPanelButtonWithText("Gość",this));
                }
                else{
                    username_button_object = new ButtonChangingTextColor(new ChangingPanelButtonWithText(user,this));
                }
                JButton username_button = username_button_object.getThisButtonAsJButton();
                username_button.setFont(new Font("Times Roman",Font.PLAIN,25));
        user_panel.add(username_button);
                JLabel screamer = new JLabel("!");
                screamer.setOpaque(true);
                screamer.setFont(new Font("Times Roman",Font.PLAIN,25));
                screamer.setBackground(Color.BLACK);
                screamer.setForeground(Color.WHITE);
        user_panel.add(screamer);
        this.add(user_panel);
        //setting layout
        Dimension logo_size = logo.getPreferredSize();
        Dimension user_panel_size = user_panel.getPreferredSize();
        
        logo.setBounds(10, 10, logo_size.width, logo_size.height);
        user_panel.setBounds(width-user_panel_size.width-60, 10, user_panel_size.width, user_panel_size.height);
    }
        
}

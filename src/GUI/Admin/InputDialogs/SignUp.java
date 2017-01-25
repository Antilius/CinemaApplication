package GUI.Admin.InputDialogs;

import GUI.Admin.InputDialogs.Factory.PanelFactory;
import Memory.PeopleInMemory;
import People.Person;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp implements PanelFactory{
    
    private JTextField name;
    private JTextField surname;
    private JTextField phoneNumber;
    private JTextField email;
    private JTextField login;
    private JPasswordField password;

    public SignUp(JTextField name, JTextField surname, JTextField phoneNumber, JTextField email, JTextField login, JPasswordField password) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    @Override
    public JComponent preparePanelForDialog() {
        JPanel user = new JPanel();
        user.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        user.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();   
                
        //name
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        JLabel name = new JLabel("Please, insert your name:");
        user.add(name,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 1;
        user.add(this.name,c);
        
        //surname
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 2;
        JLabel surname = new JLabel("Please, insert your surname:");
        user.add(surname,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 3;
        user.add(this.surname,c);
        
        //phoneNumber
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 4;
        JLabel phoneNumber = new JLabel("Please, insert your phone number:");
        user.add(phoneNumber,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 5;     
        user.add(this.phoneNumber,c);
                
        //email
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 6;
        JLabel email = new JLabel("Please, insert your email:");
        user.add(email,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 7;
        user.add(this.email,c);
        
        //login
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 8;
        JLabel login = new JLabel("Please, insert your login:");
        user.add(login,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 9;
        user.add(this.login,c);
        
        //password
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 10;
        JLabel password = new JLabel("Please, insert your password:");
        user.add(password,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,0,0,0);
        c.gridy = 11;
        user.add(this.password,c);

        return user;
    }   

    public String getName(JTextField name) {
        return name.getText();
    }

    public String getSurname(JTextField surname) {
        return surname.getText();
    }

    public int getPhoneNumber(JTextField phoneNumber) {
        return Integer.parseInt(phoneNumber.getText());
    }

    public String getEmail(JTextField email) {
        return email.getText();
    }

    public String getLogin(JTextField login) {
        return login.getText();
    }

    public static String readPassword(JPasswordField pass){
        String password="";
        char[] tab = pass.getPassword();
        for(int i=0;i<tab.length;i++){
            password+=tab[i];
        }
        return password;
    }
    
}

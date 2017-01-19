package GUI.Buttons;

import GUI.Admin.AdminFrame;
import GUI.MainPanel;
import People.Person;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ButtonGettingUser extends ChangingPanelButtonWithText implements ActionListener, KeyListener{

    private JTextField textfield; 
    private JPasswordField passwordfield;
    private final MainPanel panel_to_replace;
    
    public ButtonGettingUser(String textInsideButton, JPanel panel_to_clear, JTextField textfield, JPasswordField passwordfield, int width, int height) {
        super(textInsideButton, panel_to_clear,12);
        this.textfield=textfield;
        this.passwordfield=passwordfield;
        this.panel_to_replace=(MainPanel)panel_to_clear;
        this.textfield.addKeyListener(this);
        this.passwordfield.addKeyListener(this);
        this.addActionListener(this);
    } 
    
    public static String readPassword(JPasswordField pass){
        String password="";
        char[] tab = pass.getPassword();
        for(int i=0;i<tab.length;i++){
            password+=tab[i];
        }
        return password;
    }

    public void whatToDoAfterInterraction(){
        if(Person.checkPerson(this.textfield.getText(), readPassword(this.passwordfield)) || (this.textfield.getText().equals("") && readPassword(this.passwordfield).equals(""))){              
                this.panel_to_replace.removeAll();
                this.panel_to_replace.printThisAfterLogin(this.textfield.getText(), this.panel_to_replace.getWidth(), this.panel_to_replace.getHeight());
                this.panel_to_replace.revalidate();
                this.panel_to_replace.repaint();
                //if(Person.isThisUserAdmin(this.textfield.getText())){
                  //  new AdminFrame(this.textfield.getText());
                //}
        }
        else{               
                JOptionPane.showMessageDialog(this, "Incorrect login or password, please try again or login as a guest", "Incorrect input data!", JOptionPane.ERROR_MESSAGE);  
                this.panel_to_replace.removeAll();
                this.panel_to_replace.printThis(this.panel_to_replace.getWidth(), this.panel_to_replace.getHeight());              
                this.panel_to_replace.revalidate();
                this.panel_to_replace.repaint();     
        }          
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        ((JButton)event.getSource()).addKeyListener(this);
        if(event.getSource() == this){         
            this.whatToDoAfterInterraction();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //Brak możliwości użycia KeyAdapter ze względu na dziedziczenie po innej klasie
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Brak możliwości użycia KeyAdapter ze względu na dziedziczenie po innej klasie
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            this.whatToDoAfterInterraction();
        }    
    }
}

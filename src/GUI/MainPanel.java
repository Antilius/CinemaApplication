package GUI;

import GUI.Admin.AdminFrame;
import GUI.Admin.InputDialogs.AddNewMovie;
import GUI.Admin.InputDialogs.DialogPattern;
import GUI.Buttons.AdminPanelButtonChangingTextColor;
import GUI.Buttons.ButtonChangingTextColor;
import GUI.Buttons.ButtonGettingUser;
import GUI.Buttons.ButtonShowingDialog;
import GUI.Buttons.ReturnButtonChangingTextColor;
import GUI.Admin.InputDialogs.SignUp;
import GUI.TextPainters.MultiLineTextPainter;
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

public final class MainPanel extends JPanel implements PanelInsideFrame{

    private final int width;
    private final int height;

    public MainPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setBackground(Color.BLACK);//opcjonalnie można ustawić obraz na tło      
        this.setSize(new Dimension(width, height));
        this.setVisible(true);
        printThis(width, height);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void printThis(int width, int height) {
        //setting properties
        this.setLayout(null);
        
        //adding components
        JLabel text = new JLabel("Login to your cinema account or sign up:");
        text.setFont(new Font("Times Roman", Font.PLAIN, 20));
        text.setForeground(Color.white);
        this.add(text);

        JTextField loginField = new JTextField(25);
        this.add(loginField);
        JPasswordField passwordField = new JPasswordField(25);
        this.add(passwordField);
        JButton logIn = new ButtonGettingUser("Login", this, loginField, passwordField, width, height);
        this.add(logIn);
        
        ButtonShowingDialog signUpButton = new ButtonShowingDialog(12, new DialogPattern("Sign up", new SignUp(new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30)).preparePanelForDialog()));
        this.add(signUpButton);
        

        //setting layout
        Dimension text_size = text.getPreferredSize();
        Dimension login_size = loginField.getPreferredSize();
        Dimension password_size = passwordField.getPreferredSize();
        Dimension button_login_size = logIn.getPreferredSize();
        Dimension signUpButton_size = signUpButton.getPreferredSize();

        text.setBounds((width - text_size.width) / 2, 50, text_size.width, text_size.height);
        loginField.setBounds((width - login_size.width) / 2, 200, login_size.width, login_size.height);
        passwordField.setBounds((width - password_size.width) / 2, 250, password_size.width, password_size.height);
        logIn.setBounds((width - button_login_size.width) / 2, 300, button_login_size.width, button_login_size.height);
        signUpButton.setBounds((width - signUpButton_size.width) / 2, 350, signUpButton_size.width, signUpButton_size.height);
    }

    public void printThisAfterLogin(String user, int width, int height) {
        
        //seting properties       
        this.setLayout(null);
        
        //adding components
        JLabel logo = new JLabel("LOGO", SwingConstants.CENTER);
        logo.setPreferredSize(new Dimension(200, 100));
        logo.setFont(new Font("Times Roman", Font.PLAIN, 40));
        logo.setForeground(Color.BLACK);
        logo.setOpaque(true);
        logo.setBackground(Color.WHITE);
        this.add(logo);

        JPanel user_panel = this.prepareUserPanel(user);
        this.add(user_panel);
        
        if(Person.isThisUserAdmin(user)){
            AdminFrame adminFrame = new AdminFrame(user);
            Color background = Color.BLACK;
            AdminPanelButtonChangingTextColor admin_panel_button_object;
            admin_panel_button_object = new AdminPanelButtonChangingTextColor(user, "Administrator panel", this, 20, Color.WHITE, Color.RED, background, adminFrame);
            JButton admin_panel_button = admin_panel_button_object.getThisButtonAsJButton();
            Dimension admin_panel_button_size = admin_panel_button.getPreferredSize();
            admin_panel_button.setBounds(width - admin_panel_button_size.width - 20, 40, admin_panel_button_size.width, admin_panel_button_size.height);
            this.add(admin_panel_button);
        }
            
        JPanel rep = new RepertoireForDayPanel(new DateFormatting());
        this.add(rep);
        //setting layout
        Dimension logo_size = logo.getPreferredSize();
        Dimension user_panel_size = user_panel.getPreferredSize();
        Dimension rep_size = rep.getPreferredSize();

        logo.setBounds(10, 10, logo_size.width, logo_size.height);
        user_panel.setBounds(width - user_panel_size.width - 20, 10, user_panel_size.width, user_panel_size.height);
        rep.setBounds((width - rep_size.width) / 2, 200, rep_size.width, rep_size.height);
    }

    public void printProfile(String user, int width, int height) {
        HashMap<String, Person> users = PeopleInMemory.load();
        ArrayList<Booking> bookings = BookingInMemory.load(user);
        Person person = users.get(user);
        //setting properties
        this.setLayout(null);
        Color background = Color.BLACK;
        ReturnButtonChangingTextColor returnButton_object;
        returnButton_object = new ReturnButtonChangingTextColor(user, "<< Return",this, 20, Color.WHITE, Color.YELLOW, background);
        JButton returnButton = returnButton_object.getThisButtonAsJButton();
        Dimension returnButton_size = returnButton.getPreferredSize();
        returnButton.setBounds(width - returnButton_size.width - 20, 10, returnButton_size.width, returnButton_size.height);
        this.add(returnButton);
        
        //adding components
        if (!user.equals("Guest")) {
            JLabel text1 = new JLabel("Twój profil:");
            text1.setFont(new Font("Times Roman", Font.BOLD, 20));
            text1.setForeground(Color.ORANGE);
            this.add(text1);
            JLabel text2 = new JLabel("Imie i nazwisko: " + person.getName() + " " + person.getSurname());
            text2.setFont(new Font("Times Roman", Font.BOLD, 20));
            text2.setForeground(Color.RED);
            this.add(text2);
            JLabel text3 = new JLabel("Email: " + person.getEmail());
            text3.setFont(new Font("Times Roman", Font.BOLD, 20));
            text3.setForeground(Color.RED);
            this.add(text3);
            JLabel text4;
            if (person.isAdmin()) {
                text4 = new JLabel("Rodzaj konta: Administrator");
            } else {
                text4 = new JLabel("Rodzaj konta: Użytkownik");
            }
            text4.setFont(new Font("Times Roman", Font.BOLD, 20));
            text4.setForeground(Color.RED);
            this.add(text4);
            JLabel text5 = new JLabel("Rezerwacje: ");
            text5.setFont(new Font("Times Roman", Font.BOLD, 20));
            text5.setForeground(Color.ORANGE);
            this.add(text5);
            
            Dimension text1_size = text1.getPreferredSize();
            Dimension text2_size = text5.getPreferredSize();
            Dimension text3_size = text2.getPreferredSize();
            Dimension text4_size = text3.getPreferredSize();
            Dimension text5_size = text4.getPreferredSize();

            text1.setBounds(10, 10, text1_size.width, text1_size.height);
            text2.setBounds(20, 60, text3_size.width, text3_size.height);
            text3.setBounds(20, 90, text4_size.width, text4_size.height);
            text4.setBounds(20, 120, text5_size.width, text5_size.height);
            text5.setBounds(10, 180, text2_size.width, text2_size.height);

            JLabel headline1 = new JLabel("Tytuł");
            headline1.setFont(new Font("Times Roman", Font.BOLD, 20));
            headline1.setForeground(Color.RED);
            this.add(headline1);
            JLabel headline2 = new JLabel("Data");
            headline2.setFont(new Font("Times Roman", Font.BOLD, 20));
            headline2.setForeground(Color.RED);
            this.add(headline2);
            JLabel headline3 = new JLabel("Godzina");
            headline3.setFont(new Font("Times Roman", Font.BOLD, 20));
            headline3.setForeground(Color.RED);
            this.add(headline3);
            JLabel headline4 = new JLabel("Sala");
            headline4.setFont(new Font("Times Roman", Font.BOLD, 20));
            headline4.setForeground(Color.RED);
            this.add(headline4);
            JLabel headline5 = new JLabel("Rząd");
            headline5.setFont(new Font("Times Roman", Font.BOLD, 20));
            headline5.setForeground(Color.RED);
            this.add(headline5);
            JLabel headline6 = new JLabel("Miejsce");
            headline6.setFont(new Font("Times Roman", Font.BOLD, 20));
            headline6.setForeground(Color.RED);
            this.add(headline6);            
            
            Dimension headline1_size = headline1.getPreferredSize();
            Dimension headline2_size = headline2.getPreferredSize();
            Dimension headline3_size = headline3.getPreferredSize();
            Dimension headline4_size = headline4.getPreferredSize();
            Dimension headline5_size = headline5.getPreferredSize();
            Dimension headline6_size = headline6.getPreferredSize();           
            
            int w=0;
            headline1.setBounds(20, 205, headline1_size.width, headline1_size.height);
            headline2.setBounds(w=w+this.width/3, 205, headline2_size.width, headline2_size.height);
            headline3.setBounds(w=w+this.width/7, 205, headline3_size.width, headline3_size.height);
            headline4.setBounds(w=w+this.width/7, 205, headline4_size.width, headline4_size.height);
            headline5.setBounds(w=w+this.width/7, 205, headline5_size.width, headline5_size.height);
            headline6.setBounds(w=w+this.width/7, 205, headline6_size.width, headline6_size.height);

            for (int i = 0; i < bookings.size(); i++) {
            JLabel component1 = new JLabel(bookings.get(i).getShowing().getMovie().getTitle());
            component1.setFont(new Font("Times Roman", Font.BOLD, 20));
            component1.setForeground(Color.RED);
            this.add(component1);
            JLabel component2 = new JLabel(bookings.get(i).getDate().withoutHoursDateFormat());
            component2.setFont(new Font("Times Roman", Font.BOLD, 20));
            component2.setForeground(Color.RED);
            this.add(component2);
            JLabel component3 = new JLabel(bookings.get(i).getShowing().getHour());
            component3.setFont(new Font("Times Roman", Font.BOLD, 20));
            component3.setForeground(Color.RED);
            this.add(component3);
            JLabel component4 = new JLabel(String.valueOf(bookings.get(i).getShowing().getHallNumber()));
            component4.setFont(new Font("Times Roman", Font.BOLD, 20));
            component4.setForeground(Color.RED);
            this.add(component4);
            JLabel component5 = new JLabel(String.valueOf(bookings.get(i).getPlace().getRow()));
            component5.setFont(new Font("Times Roman", Font.BOLD, 20));
            component5.setForeground(Color.RED);
            this.add(component5);
            JLabel component6 = new JLabel(String.valueOf(bookings.get(i).getPlace().getPlace()));
            component6.setFont(new Font("Times Roman", Font.BOLD, 20));
            component6.setForeground(Color.RED);
            this.add(component6);
            
            Dimension component1_size = component1.getPreferredSize();
            Dimension component2_size = component2.getPreferredSize();
            Dimension component3_size = component3.getPreferredSize();
            Dimension component4_size = component4.getPreferredSize();
            Dimension component5_size = component5.getPreferredSize();
            Dimension component6_size = component6.getPreferredSize();
            w=0;
            component1.setBounds(20, 230 + i * 25, this.width/3-25, component1_size.height);
            component2.setBounds(w=this.width/3, 230 + i * 25, this.width/7-5, component2_size.height);
            component3.setBounds(w=w+this.width/7, 230 + i * 25, this.width/7-5, component3_size.height);
            component4.setBounds(w=w+this.width/7, 230 + i * 25, this.width/7-5, component4_size.height);
            component5.setBounds(w=w+this.width/7, 230 + i * 25, this.width/7-5, component5_size.height);
            component6.setBounds(w=w+this.width/7, 230 + i * 25, this.width/7-5, component6_size.height);
            }
        } else {
            
            MultiLineTextPainter multiLine = new MultiLineTextPainter("Korzystasz z aplikacji jako gość. Zaloguj się,lub zarejestruj, aby przeglądać szczegóły dotyczące Twojego konta.",
                                                                      new Font("Times Roman", Font.BOLD, 20), Color.RED, background, 500);
            Dimension multiLine_size = multiLine.getPreferredSize();
            multiLine.setBounds((this.width-multiLine_size.width)/2, 40, multiLine_size.width, multiLine_size.height);
            multiLine.setVisible(true);
            this.add(multiLine);
            ButtonShowingDialog signUpButton = new ButtonShowingDialog(12, new DialogPattern("Sign up", new SignUp(new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30), new JTextField(30)).preparePanelForDialog()));
            this.add(signUpButton);
            Dimension signUpButton_size = signUpButton.getPreferredSize();
            signUpButton.setBounds(width - signUpButton_size.width-20, 50, signUpButton_size.width, signUpButton_size.height);
        }
    }

    private JPanel prepareUserPanel(String user) {
        Color background = Color.BLACK;
        JPanel user_panel = new JPanel();
        user_panel.setBackground(background);
        JLabel welcome = new JLabel("Welcome,");
        welcome.setOpaque(true);
        welcome.setFont(new Font("Times Roman", Font.PLAIN, 20));
        welcome.setBackground(Color.BLACK);
        welcome.setForeground(Color.WHITE);
        user_panel.add(welcome);
        ButtonChangingTextColor username_button_object;
        if (user.equals("")) {
            username_button_object = new ButtonChangingTextColor("Guest", this, 20, Color.WHITE, Color.RED, background);
        } else {
            username_button_object = new ButtonChangingTextColor(user, this, 20, Color.WHITE, Color.RED, background);
        }
        JButton username_button = username_button_object.getThisButtonAsJButton();
        user_panel.add(username_button);
        JLabel screamer = new JLabel("!");
        screamer.setOpaque(true);
        screamer.setFont(new Font("Times Roman", Font.PLAIN, 20));
        screamer.setBackground(Color.BLACK);
        screamer.setForeground(Color.WHITE);
        user_panel.add(screamer);
        return user_panel;
    }
}

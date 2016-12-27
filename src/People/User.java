/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

/**
 *
 * @author Hubert
 */
public class User {
    private String id; //bedzie nadawane automatycznie 
    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private String login;
    private String password;
    private boolean canChange;   
    int i=1;
    
    public User(String name, String surname, int phoneNumber, String email, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.id = name.substring(0, 1)+surname.substring(0,1);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.canChange = false;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
}

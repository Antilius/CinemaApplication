package People;

import Memory.PeopleInMemory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private String login;
    private String password;
    private boolean canChange;   // pozwala odroznic usera od admina
    
    public Person(String name, String surname, int phoneNumber, String email, String login, String password, Boolean canChange) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.canChange = canChange;
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

    public boolean isCanChange() {
        return canChange;
    }
    
    public static boolean checkPerson (String login, String password){
        boolean correct = false;
        HashMap<String, Person> people = new HashMap();
        people = PeopleInMemory.load();
        for (int i=0; i<people.size(); i++) {
           if(people.get(i).getLogin().equals(login)){
               if(people.get(i).getPassword().equals(password)){
                   correct = true;
               }
           }
        }
        return correct;
    }
}

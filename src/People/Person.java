package People;

import Memory.PeopleInMemory;
import java.util.HashMap;
import java.util.Set;

public class Person {
    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private String login;
    private String password;
    private boolean admin;   // pozwala odroznic usera od admina
    
    public Person(String name, String surname, int phoneNumber, String email, String login, String password, Boolean admin) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.admin = admin;
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

    public boolean isAdmin() {
        return admin;
    }
    
    public static boolean checkPerson (String login, String password){
        boolean correct = false;
        HashMap<String, Person> people = new HashMap();
        people = PeopleInMemory.load();
        Set keys = people.keySet();
        for(Object key: keys){
           if(people.get(key).getLogin().equals(login)){
               if(people.get(key).getPassword().equals(password)){
                   correct = true;
               }
           }
        }
        return correct;
    }
    
    public static boolean isThisUserAdmin(String user){
        HashMap<String, Person> people = new HashMap();
        people = PeopleInMemory.load();
        Set keys = people.keySet();
        for(Object key: keys){
           if(people.get(key).getLogin().equals(user)){
               return people.get(key).isAdmin();
           }
        }
        return false;
    }
}

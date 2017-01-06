package Memory;

import People.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PeopleInMemory {

    public static void save(HashMap users) {
        File usersInMemory = new File("users.txt");
        Set keys = users.keySet();
        try {
            PrintWriter write = new PrintWriter(usersInMemory);
            for(Object key: keys){
               Person user = (Person) users.get(key);
               write.println(user.getName());
               write.println(user.getSurname());
               write.println(user.getPhoneNumber());
               write.println(user.getEmail());
               write.println(user.getLogin());
               write.println(user.getPassword());
               write.println(user.isCanChange());
            }
            write.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }

    public static HashMap load() {
        File users = new File("users.txt");
        HashMap<String, Person>  people = new HashMap();
        try {
            Scanner reader = new Scanner(users);
            while(reader.hasNextLine()){
                String name = reader.nextLine();
                String surname = reader.nextLine();
                int phoneNumber = Integer.parseInt(reader.nextLine());
                String email = reader.nextLine();
                String login = reader.nextLine();
                String password = reader.nextLine();
                boolean canChange = Boolean.parseBoolean(reader.nextLine());
                Person person = new Person(name, surname, phoneNumber, email, login, password, canChange);
                people.put(login, person);
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        return people;
    }
    
    
    
}

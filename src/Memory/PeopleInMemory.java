package Memory;

import People.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeopleInMemory implements ConnectWithMemory{

    @Override
    public void saveInFile(ArrayList users) {
        File usersInMemory = new File("users.txt");
        try {
            PrintWriter write = new PrintWriter(usersInMemory);
            for (Object user1 : users) {
               Person user = (Person) user1;
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

    @Override
    public ArrayList readFromFile(File users) {
        ArrayList<Person> people = new ArrayList();
        String name;
        String surname;
        int phoneNumber;
        String email;
        String login;
        String password;
        boolean canChange;
        try {
            Scanner reader = new Scanner(users);
            while(reader.hasNextLine()){
                name = reader.nextLine();
                surname = reader.nextLine();
                phoneNumber = Integer.valueOf(reader.nextLine());
                email = reader.nextLine();
                login = reader.nextLine();
                password = reader.nextLine();
                canChange = Boolean.getBoolean(reader.nextLine());
                Person person = new Person(name, surname, phoneNumber, email, login, password, canChange);
                people.add(person);
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        return people;
        
    }
    
}

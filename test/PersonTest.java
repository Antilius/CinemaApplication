/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Memory.PeopleInMemory;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Aga
 */
import People.Person;
import java.io.FileNotFoundException;
import java.util.HashMap;
public class PersonTest {
    
    public PersonTest() {
    }

    @Test
    public void loginUsingWrongLogin()
    {
        Boolean login = Person.checkPerson("huberta","hubert");
        assertEquals(false, login);
        
    }
    
    @Test
    public void loginUsingWrongPassword()
    {
        Boolean login = Person.checkPerson("hubert","sdasda");
        assertEquals(false, login);
    }
    
    @Test
    public void loginUsingCorrectData(){
        Boolean login = Person.checkPerson("hubert","hubert");
        assertEquals(true, login);
    }
    
    @Test
    public void thisUserIsAdmin(){
        Boolean userIsAdmin = Person.isThisUserAdmin("hubert");
        assertEquals(true, userIsAdmin);
    }
    @Test
    public void thisUserIsNotAdmiin(){
        Boolean userNotAdmin = Person.isThisUserAdmin("jan");
        assertEquals(false, userNotAdmin);
    }
    
    @Test
    public void ConstructorTest(){
        Person person = new Person("name", "surname", 123, "email", "login", "password", true);
        Person personExpected = new Person("name", "surname", 123, "email", "login", "password", true);
        assertEquals(person.getName(), personExpected.getName());
        assertEquals(person.getEmail(), personExpected.getEmail());
        assertEquals(person.getLogin(), personExpected.getLogin());
        assertEquals(person.getPassword(), personExpected.getPassword());
        assertEquals(person.getEmail(), personExpected.getEmail());
        assertEquals(person.getPhoneNumber(), personExpected.getPhoneNumber());
        assertEquals(person.getSurname(), personExpected.getSurname());
        
    }
    
    @Test
    public void LoadAndSavePeopleDontThrowException(){
       Exception ex = null;
       HashMap users = PeopleInMemory.load();
       try{PeopleInMemory.save(users);}
       catch(Exception e){
           ex =e;
       }
       assertEquals(null, ex);
    }
    
    @Test(expected=FileNotFoundException.class)
    public void LoadPeopleNotExistingFile(){
        HashMap users = PeopleInMemory.load("userTest.txt");
    }
   
    @Test
    public void LoadPeopleFromExistingFile(){
        HashMap users = PeopleInMemory.load("userTest.txt");
        Person person = (Person) users.get("ala");
        
        Person personExpected = new Person("Ala", "Makota", 123, "ma@kota.mail.pl", "ala", "ala", false);
        
        assertEquals(person.getName(), personExpected.getName());
        assertEquals(person.getEmail(), personExpected.getEmail());
        assertEquals(person.getLogin(), personExpected.getLogin());
        assertEquals(person.getPassword(), personExpected.getPassword());
        assertEquals(person.getEmail(), personExpected.getEmail());
        assertEquals(person.getPhoneNumber(), personExpected.getPhoneNumber());
        assertEquals(person.getSurname(), personExpected.getSurname());
        
    }
}
 

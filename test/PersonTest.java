/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Aga
 */
import People.Person;
public class PersonTest {
    
    public PersonTest() {
    }

    @Test
    public void loginUsingWrongLogin()
    {
        Boolean login = Person.checkPerson("huberta","lasota");
        assertEquals(false, login);
        
    }
    
    @Test
    public void loginUsingWrongPassword()
    {
        Boolean login = Person.checkPerson("hubert","laaaasota");
        assertEquals(false, login);
    }
    
    @Test
    public void loginUsingCorrectData(){
        Boolean login = Person.checkPerson("hubert","lasota");
        assertEquals(true, login);
    }
    
    
}

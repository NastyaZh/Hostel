package by.epam.project.hostel.service.validation.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.epam.project.hostel.service.exception.ValidationException;

public class UserValidatorImplTestEmail {
private UserValidatorImpl userValidator;
public String validEmail[];
public String invalidEmail[];

	
	@Before
    public void init() { userValidator = new UserValidatorImpl(); 
    
    validEmail = new String[]
    	{
    	                "nastya@yandex.ru",
    	                "nastya-27@yandex.com",
    	                "nastya.27@yandex.com",
    	                "nastya111@devcolibri.com",
    	                "nastya.100@devcolibri.com.ua",
    	                "nastya@1.com",
    	                "nastya@gmail.com.com",
    	                "nastya-27@yandex-test.com"};


    invalidEmail = new String[]
    	{
    			"",
    	        "devcolibri",
    	        "nastya@.com.ua",
    	        "nastya123@gmail.a",
    	        "nastya123@.com",
    	        "nastya123@.com.com",
    	        ".nastya@devcolibri.com",
    	        "nastya()*@gmail.com",
    	        "nastya@%*.com",
    	        "nastya..2013@gmail.com",
    	        "nastya.@gmail.com",
    	        "nastya@devcolibri@gmail.com",
    	        "nastya@gmail.com.1ua"};
    	}
	
    @After
    public void tearDown() { userValidator = null; }
    
    
    @Test
    public void validateEmail_NullEmail_FasleReturned() {
    	try {
			assertEquals(false, userValidator.validateEmail(null));
		} catch (ValidationException e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void ValidEmailTest() {

        for (String temp : validEmail) {
            boolean valid;
			try {
				valid = userValidator.validateEmail(temp);
				assertEquals(valid, true);
			} catch (ValidationException e) {
				e.printStackTrace();
			}            
        }

    }

    @Test
    public void InValidEmailTest() {

        for (String temp : invalidEmail) {
            boolean valid;
			try {
				valid = userValidator.validateEmail(temp);
				assertEquals(valid, false);
			} catch (ValidationException e) {
				e.printStackTrace();
			}
        }
    }
}

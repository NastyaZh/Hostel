package by.epam.project.hostel.service.validation.testng;

import org.testng.annotations.Test;

import by.epam.project.hostel.service.exception.ValidationException;
import by.epam.project.hostel.service.validation.impl.UserValidatorImpl;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class UserValidatorImplTestEmail {
	
	private UserValidatorImpl userValidator;
	public String validEmail[];
	public String invalidEmail[];

	
	 
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
  @BeforeMethod
  public void beforeMethod() {
	  userValidator = new UserValidatorImpl(); 
	    
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

  @AfterMethod
  public void afterMethod() {
	  userValidator = null;
  }

}

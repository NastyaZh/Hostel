package by.epam.project.hostel.service.validation.testng;

import org.testng.annotations.Test;

import by.epam.project.hostel.service.exception.ValidationException;
import by.epam.project.hostel.service.validation.impl.UserValidatorImpl;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class UserValidatorImplTestPassword {
	private UserValidatorImpl userValidator;
	 @Test
	    public void validatePasswordLength_NullPassword_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validatePasswordLength(null));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validatePasswordLength_EmptyPassword_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validatePasswordLength(""));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validatePasswordLength_PasswordLength7_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validatePasswordLength("1234567"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validatePasswordLength_PasswordLength15_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validatePasswordLength("123456789123456"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validatePasswordLength_PasswordLength8_TrueReturned() {
	    	try {
				assertEquals(true, userValidator.validatePasswordLength("12345678"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validatePasswordLength_PasswordLength14_TrueReturned() {
	    	try {
				assertEquals(true, userValidator.validatePasswordLength("12345678912345"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
  @BeforeMethod
  public void beforeMethod() {
	  userValidator = new UserValidatorImpl();
  }

  @AfterMethod
  public void afterMethod() {
	  userValidator = null;
  }

}

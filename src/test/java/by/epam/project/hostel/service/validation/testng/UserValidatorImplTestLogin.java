package by.epam.project.hostel.service.validation.testng;

import org.testng.annotations.Test;

import by.epam.project.hostel.service.exception.ValidationException;
import by.epam.project.hostel.service.validation.impl.UserValidatorImpl;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class UserValidatorImplTestLogin {
	private UserValidatorImpl userValidator;
	 @Test
	    public void validateLogin_NullLogin_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validateLogin(null));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_EmptyLogin_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validateLogin(""));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_LoginLength2_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validateLogin("12"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_LoginLength11_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validateLogin("12345678912"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_LoginRus_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validateLogin("абв"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_LoginSpecialSymb_FasleReturned() {
	    	try {
				assertEquals(false, userValidator.validateLogin("!@#"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_LoginLength3_TrueReturned() {
	    	try {
				assertEquals(true, userValidator.validateLogin("dad"));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
	    }
	    
	    @Test
	    public void validateLogin_LoginLength10_TrueReturned() {
	    	try {
				assertEquals(true, userValidator.validateLogin("Nastya_998"));
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

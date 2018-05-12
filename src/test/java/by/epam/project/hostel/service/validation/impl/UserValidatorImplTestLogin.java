package by.epam.project.hostel.service.validation.impl;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import by.epam.project.hostel.service.exception.ValidationException;

public class UserValidatorImplTestLogin {
	private UserValidatorImpl userValidator;
	
	@Before
    public void init() { userValidator = new UserValidatorImpl(); }
    @After
    public void tearDown() { userValidator = null; }
    
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
}

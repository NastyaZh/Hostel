package by.epam.project.hostel.service.validation.impl;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import by.epam.project.hostel.service.exception.ValidationException;

public class UserValidatorImplTestPassword {
	private UserValidatorImpl userValidator;
	
	@Before
    public void init() { userValidator = new UserValidatorImpl(); }
    @After
    public void tearDown() { userValidator = null; }
	
	
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
}

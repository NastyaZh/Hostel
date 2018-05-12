package by.epam.project.hostel.service.validation.impl;

import by.epam.project.hostel.entity.User;
import by.epam.project.hostel.service.exception.EmptyParamServiceException;
import by.epam.project.hostel.service.exception.ValidationException;
import by.epam.project.hostel.service.validation.Validator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserValidatorImpl implements Validator<User> {

    private static final String ADMIN = "admin";
    private static final String USER = "user";


    public void validateBanned(int banned) throws ValidationException {
        if (banned > 1 || banned < 0) {
            throw new ValidationException("error during validation user ban situation: " + banned);
        }
    }

    public void validateRole(String role) throws ValidationException {
        if (!role.equals(ADMIN) && !role.equals(USER)) {
            throw new ValidationException("error during validation user role");
        }
    }

    public User validate(User user) throws ValidationException {
        if (user == null) {
            throw new EmptyParamServiceException("error during validation parameter user is empty");
        }
        validateID(user.getId());
        validate(user.getEmail(), user.getLogin(), user.getName(), user.getNumber(), user.getPassword(), user.getSurname());
        user.setPassword(validatePassword(user));
        return user;
    }

    public String validatePassword(User user) throws ValidationException {
        return validatePassword(user.getPassword());
    }

    public String validatePassword(String password) throws ValidationException {
        MessageDigest messageDigest;
        byte[] digest;
        
        if(! validatePasswordLength(password)) {
        	throw new ValidationException("error length password");
        }
        else {
        	try {
                messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(password.getBytes());
                digest = messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                throw new ValidationException("algorithm doesn't represent, error during reorganize password", e);
            }
            BigInteger bigInteger = new BigInteger(1, digest);
            StringBuilder md5Hex = new StringBuilder(bigInteger.toString(16));
            while (md5Hex.length() < 32) {
                md5Hex.insert(0, "0");
            }
            return md5Hex.toString();
        }
        
    }
    
    public boolean validatePasswordLength(String password) throws ValidationException {
    	
    	if(password == null || password.isEmpty()) {
        	return false;
        }
    	else if(password.length() < 8 || password.length() > 14) {
    		return false;
    	}
    	return true;
    }
    
    
    public boolean validateLogin(String login) throws ValidationException {
    	
    	if(login == null || login.isEmpty()) {
        	return false;
        }
    	Pattern p = Pattern.compile("^[a-zA-Z0-9_]{3,10}$");  
        Matcher m = p.matcher(login);  
        return m.matches();
    }
        
    public boolean validateEmail(String email) throws ValidationException {
    	
    	if(email == null || email.isEmpty()) {
        	return false;
        }
    	Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");  
        Matcher m = p.matcher(email);  
        return m.matches();
    }
    
}

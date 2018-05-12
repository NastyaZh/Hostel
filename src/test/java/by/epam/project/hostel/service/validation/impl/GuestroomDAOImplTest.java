package by.epam.project.hostel.service.validation.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.*;

import by.epam.project.hostel.dao.DAOFactory;
import by.epam.project.hostel.dao.db.connection.ConnectionProvider;
import by.epam.project.hostel.dao.exception.ConnectionProviderException;
import by.epam.project.hostel.dao.exception.DAOException;

public class GuestroomDAOImplTest {
	 @Before
	    public void init() {
	        try {
	            ConnectionProvider.getInstance().initPoolData();
	        } catch (ConnectionProviderException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void getGuestRoomById_GetGuestroomByIdIValidLanguageValidEN_NotNull() throws DAOException {
	        assertNotNull(DAOFactory.getInstance().getGuestroomDAO().getGuestroomById(1, "en"));
	    }
	    @Test
	    public void getGuestRoomById_GetGuestroomByIdValidLanguageValidRU_NotNull() throws DAOException {
	    	assertNotNull(DAOFactory.getInstance().getGuestroomDAO().getGuestroomById(1, "ru"));
	    }
	    @Test
	    public void getGuestRoomById_GetGuestroomByIdValidLanguageInvalideBY_Null() throws DAOException {
	    	assertNull(DAOFactory.getInstance().getGuestroomDAO().getGuestroomById(1, "by"));
	    }
	    
	    @Test
	    public void getGuestRoomById_GetGuestroomByInvalidLanguageValidEN_Null() throws DAOException {
	        assertNull(DAOFactory.getInstance().getGuestroomDAO().getGuestroomById(27, "en"));
	    }
	    
	    @Test
	    public void getGuestRoomById_GetGuestroomByInvalidLanguageValidRU_Null() throws DAOException {
	        assertNull(DAOFactory.getInstance().getGuestroomDAO().getGuestroomById(27, "ru"));
	    }
	    
	    @Test
	    public void getGuestRoomById_GetGuestroomByInvalidLanguageInvalideBY_Null() throws DAOException {
	        assertNull(DAOFactory.getInstance().getGuestroomDAO().getGuestroomById(27, "by"));
	    }

	    @After
	    public void dispose() {
	        ConnectionProvider.getInstance().dispose();
	    }
}

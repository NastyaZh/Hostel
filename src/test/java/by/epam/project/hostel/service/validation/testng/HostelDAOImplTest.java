package by.epam.project.hostel.service.validation.testng;

import org.testng.annotations.Test;

import by.epam.project.hostel.dao.DAOFactory;
import by.epam.project.hostel.dao.db.connection.ConnectionProvider;
import by.epam.project.hostel.dao.exception.ConnectionProviderException;
import by.epam.project.hostel.dao.exception.DAOException;
import by.epam.project.hostel.entity.Hostel;

import org.testng.annotations.BeforeMethod;

import static by.epam.project.hostel.controller.constant.Constant.Language.EN;
import static by.epam.project.hostel.controller.constant.Constant.Language.RU;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;

public class HostelDAOImplTest {
	 @Test
	    public void addHostelRU_NotNull() {
	        HashMap<String, Hostel> hostel = new HashMap<>();
	        hostel.put(RU, new Hostel(5, "Монтана", "Канада", "Оттава", "прекрасное место", "img/1.jpg", "Ла"));
	        try {
	        	assertNotNull(DAOFactory.getInstance().getHostelDAO().addHostel(hostel));
	        } catch (DAOException e) {
	            e.printStackTrace();
	        }
	    }
	            
	    @Test
	    public void addHostelRUEN_NotNull() {
	        HashMap<String, Hostel> hostel = new HashMap<>();
	        hostel.put(RU, new Hostel(5, "Montana", "Канада", "Оттава", "прекрасное место", "img/1.jpg", "Ла"));
	        hostel.put(EN, new Hostel(5, "Montana", "Canada", "Ottava", "beautiful place", "img/1.jpg", "La"));
	        try {
	        	assertNotNull(DAOFactory.getInstance().getHostelDAO().addHostel(hostel));
	        } catch (DAOException e) {
	            e.printStackTrace();
	        }
	    }
  @BeforeMethod
  public void beforeMethod() {
	  try {
          ConnectionProvider.getInstance().initPoolData();
      } catch (ConnectionProviderException e) {
          e.printStackTrace();
      }
  }

  @AfterMethod
  public void afterMethod() {
	  ConnectionProvider.getInstance().dispose();
  }

}

package by.epam.project.hostel.controller.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.project.hostel.dao.db.connection.ConnectionProvider;
import by.epam.project.hostel.dao.exception.ConnectionProviderException;

public class ConnectionProviderListener implements ServletContextListener{
	
	private static final Logger LOGGER = LogManager.getRootLogger();
    private static ConnectionProvider dbConnectionProvider;


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		dbConnectionProvider.dispose();
        LOGGER.info("Connection pool destroyed successfully");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
            dbConnectionProvider = ConnectionProvider.getInstance();
            dbConnectionProvider.initPoolData();
            LOGGER.info("Connection pool initialized successfully");
        } catch (ConnectionProviderException e) {
            throw new ConnectionProviderNotInitializedException("Connection cannot be initialized", e);
        }
	}

}

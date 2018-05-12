package by.epam.project.hostel.controller.listener;

public class ConnectionProviderNotInitializedException extends RuntimeException{

	private static final long serialVersionUID = -209287304718970387L;

	public ConnectionProviderNotInitializedException() {
        super();
    }

    public ConnectionProviderNotInitializedException(String message) {
        super(message);
    }

    public ConnectionProviderNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionProviderNotInitializedException(Throwable cause) {
        super(cause);
    }

}

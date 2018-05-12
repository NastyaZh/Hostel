package by.epam.project.hostel.dao.exception;

public class ConnectionProviderException extends DAOException {

	private static final long serialVersionUID = 2800186549017256380L;

	public ConnectionProviderException() {
    }

    public ConnectionProviderException(String message) {
        super(message);
    }

    public ConnectionProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionProviderException(Throwable cause) {
        super(cause);
    }
}

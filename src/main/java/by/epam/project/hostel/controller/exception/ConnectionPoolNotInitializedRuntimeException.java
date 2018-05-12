package by.epam.project.hostel.controller.exception;

public class ConnectionPoolNotInitializedRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -6217730009446744L;

	public ConnectionPoolNotInitializedRuntimeException() {
    }

    public ConnectionPoolNotInitializedRuntimeException(String message) {
        super(message);
    }

    public ConnectionPoolNotInitializedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolNotInitializedRuntimeException(Throwable cause) {
        super(cause);
    }
}

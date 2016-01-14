package it.synclab.hrpm.exception;

public class ConnectionPoolAlreadyInstantiatedException extends Exception {

	private static final long serialVersionUID = 7648480662502674918L;

	public ConnectionPoolAlreadyInstantiatedException() {
		super();
	}

	public ConnectionPoolAlreadyInstantiatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConnectionPoolAlreadyInstantiatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionPoolAlreadyInstantiatedException(String message) {
		super(message);
	}

	public ConnectionPoolAlreadyInstantiatedException(Throwable cause) {
		super(cause);
	}

}

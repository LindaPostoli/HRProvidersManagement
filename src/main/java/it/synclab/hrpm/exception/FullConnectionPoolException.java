package it.synclab.hrpm.exception;

public class FullConnectionPoolException extends Exception {

	private static final long serialVersionUID = -6881069264988853214L;

	public FullConnectionPoolException() {
		super();
	}

	public FullConnectionPoolException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FullConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
	}

	public FullConnectionPoolException(String message) {
		super(message);
	}

	public FullConnectionPoolException(Throwable cause) {
		super(cause);
	}

}

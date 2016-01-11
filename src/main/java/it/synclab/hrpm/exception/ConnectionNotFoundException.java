package it.synclab.hrpm.exception;

public class ConnectionNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2936558835558769229L;
	
	public ConnectionNotFoundException() {
		super();
	}
	
	public ConnectionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public ConnectionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ConnectionNotFoundException(String message) {
		super(message);
	}
	
	public ConnectionNotFoundException(Throwable cause) {
		super(cause);
	}
	
}

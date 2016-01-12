package it.synclab.hrpm.exception;

public class ChannelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3670564933718444909L;

	public ChannelNotFoundException() {
		super();
	}

	public ChannelNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ChannelNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChannelNotFoundException(String message) {
		super(message);
	}

	public ChannelNotFoundException(Throwable cause) {
		super(cause);
	}

}

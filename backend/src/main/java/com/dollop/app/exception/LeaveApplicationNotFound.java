package com.dollop.app.exception;

public class LeaveApplicationNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LeaveApplicationNotFound() {
		super();
	}

	public LeaveApplicationNotFound(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LeaveApplicationNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public LeaveApplicationNotFound(String message) {
		super(message);
	}

	public LeaveApplicationNotFound(Throwable cause) {
		super(cause);
	}
	

}

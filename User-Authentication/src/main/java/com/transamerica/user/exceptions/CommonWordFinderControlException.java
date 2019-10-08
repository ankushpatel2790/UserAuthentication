package com.transamerica.user.exceptions;

public class CommonWordFinderControlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2934900099844150119L;

	CommonWordFinderControlException(String error,Throwable thr) {
		super(error,thr);
		
	}
}

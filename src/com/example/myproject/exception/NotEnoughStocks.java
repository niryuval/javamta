package com.example.myproject.exception;

import org.algo.exception.PortfolioException;

public class NotEnoughStocks extends PortfolioException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2982989618178204839L;

	public NotEnoughStocks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotEnoughStocks(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughStocks(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughStocks(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughStocks(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}

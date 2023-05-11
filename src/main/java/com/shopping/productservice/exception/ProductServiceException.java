package com.shopping.productservice.exception;

public class ProductServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public ProductServiceException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}

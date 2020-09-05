package com.kosytedy.blog.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
        super("Resource ID not found : " + id);
    }
}

package com.example.happy_fitness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private String resourceName;
 private String fieldName;
 private Object fieldValue;
public ResourceNotFoundExeption(String resourceName, String fieldName, Object fieldValue) {
	super();
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}
public ResourceNotFoundExeption() {
	super();
}
public String getResourceName() {
	return resourceName;
}
public String getFieldName() {
	return fieldName;
}
public Object getFieldValue() {
	return fieldValue;
}
 

}

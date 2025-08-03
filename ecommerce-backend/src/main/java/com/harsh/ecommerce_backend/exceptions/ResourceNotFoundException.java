package com.harsh.ecommerce_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resourcesName;
    String fieldName;
    Long fieldValue;
    public ResourceNotFoundException(String resourcesName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %l", resourcesName, fieldName, fieldValue));
        this.resourcesName = resourcesName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

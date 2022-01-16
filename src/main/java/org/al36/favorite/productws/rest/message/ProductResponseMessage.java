package org.al36.favorite.productws.rest.message;

public enum ProductResponseMessage {

    SAME_REFERENCE_CONFLICT("A cloth with the same reference already exists!"),
    CLOTHES_NOT_FOUND("There are no clothes in the database!"),
    AVAILABLE_CLOTHES_NOT_FOUND("There are no available clothes in the database!"),
    CLOTH_UPDATE_NOT_FOUND("The cloth you are trying updating does not exist!"),
    CLOTH_UPDATE_OK("The cloth has been successfully updated!"),
    CLOTH_DELETE_NOT_FOUND("The cloth you are trying updating does not exist!"),
    CLOTH_DELETED("The cloth has been successfully deleted!"),
    CLOTH_CREATED("The cloth has been successfully created"),
    CLOTHES_PRODUCT_TYPE_NOT_FOUND("There are no clothes having the requested type in the database!"),
    PRODUCT_TYPES_NOT_FOUND("There are no product types in the database!"),
    CLOTH_NOT_FOUND("The cloth you are requesting does not exist!");

    private final String message;

    ProductResponseMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

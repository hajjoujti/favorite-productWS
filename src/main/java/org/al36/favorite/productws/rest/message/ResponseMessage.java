package org.al36.favorite.productws.rest.message;

public enum ResponseMessage {

    NOT_FOUND("What you are requesting does not exist in the database!"),
    SAME_REFERENCE_CONFLICT("A cloth with the same reference already exists!"),
    PRODUCT_TYPE_NOT_FOUND("The product type you are requesting does not exist!"),
    CLOTHES_NOT_FOUND("There are no clothes in the database!"),
    AVAILABLE_CLOTHES_NOT_FOUND("There are no available clothes in the database!"),
    CLOTH_UPDATE_NOT_FOUND("The cloth you are trying updating does not exist!"),
    CLOTH_UPDATE_OK("The cloth has been successfully updated!"),
    CLOTH_DELETE_NOT_FOUND("The cloth you are trying updating does not exist!"),
    CLOTH_DELETED("The cloth has been successfully deleted!"),
    CLOTH_CREATED("The cloth has been successfully created"),
    CLOTHES_PRODUCT_TYPE_NOT_FOUND("There are no clothes having the requested type in the database!"),
    PRODUCT_TYPES_NOT_FOUND("There are no product types in the database!"),
    DESIGNS_NOT_FOUND("There are no designs in the database!"),
    CLOTH_NOT_FOUND("The cloth you are requesting does not exist!"),
    DESIGN_NOT_FOUND("The design you are requesting does not exist!");

    private final String message;

    ResponseMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

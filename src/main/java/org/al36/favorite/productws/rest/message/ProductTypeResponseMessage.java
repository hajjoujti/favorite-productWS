package org.al36.favorite.productws.rest.message;

public enum ProductTypeResponseMessage {

    PRODUCT_TYPE_NOT_FOUND("The product type you are requesting does not exist!"),
    PRODUCT_TYPES_NOT_FOUND("There are no product types in the database!");

    private final String message;

    ProductTypeResponseMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

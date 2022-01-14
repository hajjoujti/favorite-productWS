package org.al36.favorite.productws.rest.message;

public enum ResponseMessage {

    NOT_FOUND("What you are requesting does not exist in the database!!"),
    SAME_REFERENCE_CONFLICT("A cloth with the same reference already exists");

    private final String message;

    // Parameters to the enum constructors are the ones in the enum "definition"
    ResponseMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getMessage() {
        return this.message;
    }
}

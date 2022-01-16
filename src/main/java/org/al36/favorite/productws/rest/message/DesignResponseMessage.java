package org.al36.favorite.productws.rest.message;

public enum DesignResponseMessage {

    DESIGNS_NOT_FOUND("There are no designs in the database!"),
    DESIGN_NOT_FOUND("The design you are requesting does not exist!");

    private final String message;

    DesignResponseMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

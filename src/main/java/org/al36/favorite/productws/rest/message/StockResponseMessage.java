package org.al36.favorite.productws.rest.message;

public enum StockResponseMessage {

    STOCK_NOT_FOUND("There are no stock that matches the cloth and its specified size!"),
    STOCKS_NOT_FOUND("There are no stocks that matches the clothes and their specified sizes!");

    private final String message;

    StockResponseMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

package com.ksfront.pom.utils;

public enum AssertionMessages {
    ERROR_VALIDATE_PAY_ENABLED("Error, pay now button not enabled"),
    ERROR_VALUE_NOT_FOUND("Error, value not found "),
    ERROR_RESERVATION_NOT_AVALAIBLE("Error, reservation not available ");

    private final String value;

    AssertionMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

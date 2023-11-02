package com.ksfront.pom.utils;

public enum SessionVariables {
    LOGIN_USER("login user"),
    LOGIN_PASSWORD("login password"),

    DEPARTING_DAY("departing Day"),

    DEPARTING_MONTH("departing Month"),

    DEPARTING_AGE("departing Age"),

    RETURNING_DAY("returning Day"),

    RETURNING_MONTH("returning Month"),

    RETURNING_AGE("returning Age"),

    ADULTS("adults"),

    CHILD("child"),

    LAUNCH("launch"),

    PLANET_COLOR("planet color"),

    CUSTOMER_NAME("customer name"),

    CUSTOMER_EMAIL("customer email"),

    CUSTOMER_SECURITY("customer security"),

    CUSTOMER_PHONE("customer phone"),

    FILTER_BOOK("filter book");

    private final String value;

    SessionVariables(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

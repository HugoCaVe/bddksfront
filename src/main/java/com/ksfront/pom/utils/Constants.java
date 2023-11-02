package com.ksfront.pom.utils;

public enum Constants {
    USER("user"),
    PASSWORD("password"),
    EMPTY_FIELD("empty"),
    USER_FILTER("usr"),
    CUSTOMER_FILTER("customer"),
    BOOK_FILTER("reservation"),
    DEPARTING_DAY_FILTER("departingDay"),
    DEPARTING_MONTH_FILTER("departingMonth"),
    DEPARTING_AGE_FILTER("departingAge"),
    RETURNING_DAY_FILTER("returningDay"),
    RETURNING_MONTH_FILTER("returningMonth"),
    RETURNING_AGE_FILTER("returningAge"),
    ADULTS_FILTER("adults"),
    CHILD_FILTER("children"),
    LAUNCH_FILTER("launch"),
    PLANET_COLOR_FILTER("planetColor"),
    CUSTOMER_NAME_FILTER("name"),
    CUSTOMER_EMAIL_FILTER("email"),
    CUSTOMER_SOCIAL_FILTER("securityNumber"),
    CUSTOMER_PHONE_FILTER("phoneNumber"),
    BLANK_SPACE(" ");
    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

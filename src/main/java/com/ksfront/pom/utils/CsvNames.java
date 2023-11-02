package com.ksfront.pom.utils;

public enum CsvNames {
    BOOK_INFORMATION("book_information"),
    CUSTOMER_INFORMATION("customer_information"),
    LOGIN_INFORMATION("login");

    private final String valor;

    CsvNames(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

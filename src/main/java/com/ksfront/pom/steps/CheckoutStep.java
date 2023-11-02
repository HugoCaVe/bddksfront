package com.ksfront.pom.steps;

import com.ksfront.pom.pages.CheckoutPage;
import com.ksfront.pom.utils.Utilities;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.ksfront.pom.utils.AssertionMessages.ERROR_VALIDATE_PAY_ENABLED;
import static com.ksfront.pom.utils.AssertionMessages.ERROR_VALUE_NOT_FOUND;
import static com.ksfront.pom.utils.Constants.*;
import static com.ksfront.pom.utils.CsvNames.CUSTOMER_INFORMATION;
import static com.ksfront.pom.utils.CsvUtils.getDataCsv;
import static com.ksfront.pom.utils.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutStep {

    @Page
    CheckoutPage checkoutPage;

    @Step
    public void enterCustomerInformation() {
        assertThat(ERROR_VALUE_NOT_FOUND.getValue(), checkoutPage.validateName());
        assertThat(ERROR_VALUE_NOT_FOUND.getValue(), checkoutPage.validateEmail());
        assertThat(ERROR_VALUE_NOT_FOUND.getValue(), checkoutPage.validateSocialSecurity());
        assertThat(ERROR_VALUE_NOT_FOUND.getValue(), checkoutPage.validatePhoneNumber());
    }

    @Step
    public void validateCustomerInformation() throws IOException {
        readFileCustomerInformation();
        if (!sessionVariableCalled(CUSTOMER_NAME.getValue()).equals(EMPTY_FIELD.getValue())) {
            checkoutPage.enterCostumerName(sessionVariableCalled(CUSTOMER_NAME.getValue()));
        }
        if (!sessionVariableCalled(CUSTOMER_EMAIL.getValue()).equals(EMPTY_FIELD.getValue())) {
            checkoutPage.enterEmail(sessionVariableCalled(CUSTOMER_EMAIL.getValue()));
        }
        if (!sessionVariableCalled(CUSTOMER_SECURITY.getValue()).equals(EMPTY_FIELD.getValue())) {
            checkoutPage.enterSocialSecurity(sessionVariableCalled(CUSTOMER_SECURITY.getValue()));
        }
        if (!sessionVariableCalled(CUSTOMER_PHONE.getValue()).equals(EMPTY_FIELD.getValue())) {
            checkoutPage.enterPhoneNumber(sessionVariableCalled(CUSTOMER_PHONE.getValue()));
        }
    }

    @Step
    public void selectAgreeTerms() {
        checkoutPage.checkAgreeTerms();
    }

    @Step
    public void validateTheEndOfThePaymentTransaction() {
        assertThat(ERROR_VALIDATE_PAY_ENABLED.getValue(), !checkoutPage.validatePayNow());
    }

    private void readFileCustomerInformation() throws IOException {
        List<Map<String, String>> dataTable = getDataCsv(CUSTOMER_INFORMATION.getValor());
        int size = dataTable.size();
        String filterCustomer = Utilities.concatenateInformation(size, CUSTOMER_FILTER.getValue());
        filterCostumerInformation(filterCustomer);
    }

    private void filterCostumerInformation(String filterCustomer) throws IOException {
        Map<String, String> dataCustomer = Utilities.userDataFilter(filterCustomer, CUSTOMER_INFORMATION.getValor());
        Serenity.setSessionVariable(CUSTOMER_NAME.getValue()).to(dataCustomer.get(CUSTOMER_NAME_FILTER.getValue()));
        Serenity.setSessionVariable(CUSTOMER_EMAIL.getValue()).to(dataCustomer.get(CUSTOMER_EMAIL_FILTER.getValue()));
        Serenity.setSessionVariable(CUSTOMER_SECURITY.getValue()).to(dataCustomer.get(CUSTOMER_SOCIAL_FILTER.getValue()));
        Serenity.setSessionVariable(CUSTOMER_PHONE.getValue()).to(dataCustomer.get(CUSTOMER_PHONE_FILTER.getValue()));
    }
}
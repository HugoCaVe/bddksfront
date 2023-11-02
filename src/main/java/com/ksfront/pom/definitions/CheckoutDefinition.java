package com.ksfront.pom.definitions;

import com.ksfront.pom.steps.CheckoutStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class CheckoutDefinition {
    @Steps
    CheckoutStep checkoutStep;

    @Cuando("^se diligencia los datos de Nombre, Número telefonico, Número de la Seguridad Social y teléfono")
    public void enterCustomerData() throws IOException {
        checkoutStep.enterCustomerInformation();
        checkoutStep.validateCustomerInformation();
    }

    @Cuando("^se acepta los terminos y condiciones para proceder con el pago")
    public void acceptTermsAndConditions() {
        checkoutStep.selectAgreeTerms();
    }

    @Entonces("^se completa la operación de Reserva")
    public void validateToBook() {
        checkoutStep.validateTheEndOfThePaymentTransaction();
    }
}

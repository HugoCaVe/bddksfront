package com.ksfront.pom.definitions;

import com.ksfront.pom.steps.BookStep;
import io.cucumber.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class BookDefinition {

    @Steps
    BookStep bookStep;

    @Cuando("^se ingresa la información de la salida y del regreso")
    public void validateToBook() throws IOException {
        bookStep.validateDepartingInformation();
        bookStep.validateReturningInformation();
    }

    @Cuando("^se selecciona el número de adultos y número de niños")
    public void enterAdultsAndChildrenNumber() {
        bookStep.validateAdultsNumber();
        bookStep.validateChildrenNumber();
    }

    @Cuando("^se filtra el destino por nombre del planeta y su color")
    public void enterDestination() {
        bookStep.validateDestination();
        bookStep.validateNameLaunch();
        bookStep.validatePlanetColor();
    }

    @Cuando("^se realiza la reserva")
    public void enterReservation() {
        bookStep.makeReservation();
    }
}

package com.ksfront.pom.definitions;

import com.ksfront.pom.steps.LoginStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class LoginDefinition {
    @Steps
    LoginStep loginStep;

    @Dado("^que se ingresó a la página de SPACE & BEYOND")
    public void enterThePage() {
        loginStep.openTheTestWebPage();
    }

    @Dado("^que se valida el cargue de los campos para realizar el login")
    public void validatePageinformation() {
        loginStep.validateScreenInformation();
    }

    @Cuando("^se ingresa la información del nombre de usuario")
    public void validateUserField() throws IOException {
        loginStep.validateUserInformation();
    }

    @Cuando("^se ingresa la información de la contraseña")
    public void validatePasswordField() {
        loginStep.validatePasswordInformation();
    }

    @Cuando("envío la solicitud")
    public void sendRequest() {
        loginStep.submitLoginInformation();
    }
}

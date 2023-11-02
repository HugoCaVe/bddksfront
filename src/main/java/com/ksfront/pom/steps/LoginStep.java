package com.ksfront.pom.steps;

import com.ksfront.pom.pages.LoginPage;
import com.ksfront.pom.utils.Utilities;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.ksfront.pom.utils.AssertionMessages.ERROR_VALUE_NOT_FOUND;
import static com.ksfront.pom.utils.Constants.*;
import static com.ksfront.pom.utils.CsvNames.LOGIN_INFORMATION;
import static com.ksfront.pom.utils.CsvUtils.getDataCsv;
import static com.ksfront.pom.utils.SessionVariables.LOGIN_PASSWORD;
import static com.ksfront.pom.utils.SessionVariables.LOGIN_USER;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginStep {
    @Page
    LoginPage loginpage;
    @Step
    public void openTheTestWebPage() {
        loginpage.open();
    }

    @Step
    public void validateScreenInformation() {
        assertThat(ERROR_VALUE_NOT_FOUND.getValue(), loginpage.validateUser());
        assertThat(ERROR_VALUE_NOT_FOUND.getValue(), loginpage.validatePassword());
    }

    @Step
    public void validateUserInformation() throws IOException {
        selectCredentialsAtRandom();
        loginpage.selectUserField();
        if(!sessionVariableCalled(LOGIN_USER.getValue()).equals(EMPTY_FIELD.getValue())) {
            loginpage.setUserName(sessionVariableCalled(LOGIN_USER.getValue()));
        }
    }

    @Step
    public void validatePasswordInformation() {
        loginpage.selectPasswordField();
        if (!sessionVariableCalled(LOGIN_PASSWORD.getValue()).equals(EMPTY_FIELD.getValue())) {
            loginpage.setPassword(sessionVariableCalled(LOGIN_PASSWORD.getValue()));
        }
    }

    @Step
    public void submitLoginInformation() {
        loginpage.sendInformation();
    }

    private void selectCredentialsAtRandom() throws IOException {
        List<Map<String, String>> dataTable = getDataCsv(LOGIN_INFORMATION.getValor());
        int size = dataTable.size();
        String filter = Utilities.concatenateInformation(size, USER_FILTER.getValue());
        filterUserInformation(filter);
    }

    private void filterUserInformation(String filter) throws IOException {
        Map<String, String> data = Utilities.userDataFilter(filter, LOGIN_INFORMATION.getValor());
        Serenity.setSessionVariable(LOGIN_USER.getValue()).to(data.get(USER.getValue()));
        Serenity.setSessionVariable(LOGIN_PASSWORD.getValue()).to(data.get(PASSWORD.getValue()));
    }
}
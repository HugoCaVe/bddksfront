package com.ksfront.pom.steps;

import com.ksfront.pom.pages.BookPage;
import com.ksfront.pom.utils.Utilities;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.ksfront.pom.utils.AssertionMessages.ERROR_RESERVATION_NOT_AVALAIBLE;
import static com.ksfront.pom.utils.Constants.*;
import static com.ksfront.pom.utils.Constants.RETURNING_AGE_FILTER;
import static com.ksfront.pom.utils.CsvNames.BOOK_INFORMATION;
import static com.ksfront.pom.utils.CsvUtils.getDataCsv;
import static com.ksfront.pom.utils.SessionVariables.*;
import static com.ksfront.pom.utils.SessionVariables.RETURNING_AGE;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookStep {

    @Page
    BookPage bookPage;

    @Step
    public void validateDepartingInformation() throws IOException {
        bookPage.selectDeparting();
        selectBookAtRandom();
        filterBookInformation();
        bookPage.addDate((sessionVariableCalled(DEPARTING_MONTH.getValue()) + BLANK_SPACE.getValue() + sessionVariableCalled(DEPARTING_AGE.getValue())), Integer.parseInt(sessionVariableCalled(DEPARTING_DAY.getValue())));
    }

    @Step
    public void validateReturningInformation() {
        bookPage.selectReturning();
        bookPage.addDate((sessionVariableCalled(RETURNING_MONTH.getValue()) + BLANK_SPACE.getValue() + sessionVariableCalled(RETURNING_AGE.getValue())), Integer.parseInt(sessionVariableCalled(RETURNING_DAY.getValue())));
    }

    @Step
    public void validateAdultsNumber() {
        bookPage.selectNumberAdults();
    }

    @Step
    public void validateChildrenNumber() {
        bookPage.selectNumberChildren();
    }
    @Step
    public void validateDestination() {
        bookPage.selectDestination();
    }

    @Step
    public void validateNameLaunch() {
        bookPage.selectLaunch();
    }

    @Step
    public void validatePlanetColor() {
        bookPage.selectPlanetColor();
    }

    @Step
    public void makeReservation() {
        String nameLaunch = sessionVariableCalled(LAUNCH.getValue());
        assertThat(
                ERROR_RESERVATION_NOT_AVALAIBLE.getValue(), bookPage.checkCardInformation(nameLaunch));
        bookPage.selectReservation();
    }

    private void selectBookAtRandom() throws IOException {
        List<Map<String, String>> dataTable = getDataCsv(BOOK_INFORMATION.getValor());
        int size = dataTable.size();
        String filterBook = Utilities.concatenateInformation(size, BOOK_FILTER.getValue());
        Serenity.setSessionVariable(FILTER_BOOK.getValue()).to(filterBook);
    }

    private void filterBookInformation() throws IOException {
        Map<String, String> data = Utilities.userDataFilter(sessionVariableCalled(FILTER_BOOK.getValue()), BOOK_INFORMATION.getValor());
        Serenity.setSessionVariable(DEPARTING_DAY.getValue()).to(data.get(DEPARTING_DAY_FILTER.getValue()));
        Serenity.setSessionVariable(DEPARTING_MONTH.getValue()).to(data.get(DEPARTING_MONTH_FILTER.getValue()));
        Serenity.setSessionVariable(DEPARTING_AGE.getValue()).to(data.get(DEPARTING_AGE_FILTER.getValue()));
        Serenity.setSessionVariable(RETURNING_DAY.getValue()).to(data.get(RETURNING_DAY_FILTER.getValue()));
        Serenity.setSessionVariable(RETURNING_MONTH.getValue()).to(data.get(RETURNING_MONTH_FILTER.getValue()));
        Serenity.setSessionVariable(RETURNING_AGE.getValue()).to(data.get(RETURNING_AGE_FILTER.getValue()));
        Serenity.setSessionVariable(ADULTS.getValue()).to(data.get(ADULTS_FILTER.getValue()));
        Serenity.setSessionVariable(CHILD.getValue()).to(data.get(CHILD_FILTER.getValue()));
        Serenity.setSessionVariable(LAUNCH.getValue()).to(data.get(LAUNCH_FILTER.getValue()));
        Serenity.setSessionVariable(PLANET_COLOR.getValue()).to(data.get(PLANET_COLOR_FILTER.getValue()));
    }
}

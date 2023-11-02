package com.ksfront.pom.pages;

import com.ksfront.pom.utils.Utilities;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import static com.ksfront.pom.utils.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class BookPage extends PageObject {
    @FindBy(id = "right")
    private WebElementFacade btnNextMonth;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElementFacade btnOk;

    @FindBy(xpath = "//button[contains(text(),'Book')]")
    private WebElementFacade btnBook;

    @FindBy(xpath = "//button[contains(text(),'Select Destination')]")
    private WebElementFacade btnDestination;

    @FindBy(xpath = "//label[contains(text(),'Departing')]/../input")
    private WebElementFacade txtDeparting;

    @FindBy(xpath = "//label[contains(text(),'Returning')]/../input")
    private WebElementFacade txtReturning;

    @FindBy(xpath = "//input[@value = 'Adults (18+)']")
    private WebElementFacade txtAdults;

    @FindBy(xpath = "//input[@value = 'Children (0-7)']")
    private WebElementFacade txtChild;

    @FindBy(xpath = "//input[@value = 'Launch']")
    private WebElementFacade txtLaunch;

    @FindBy(xpath = "//input[@value = 'Planet color']")
    private WebElementFacade txtPlanetColor;

    public void selectReservation() {
        btnBook.click();
    }

    public void selectDeparting() {
        txtDeparting.click();
    }

    public void selectReturning() {
        txtReturning.click();
    }

    public void selectNumberAdults() {
        int numAdults = Integer.parseInt(sessionVariableCalled(ADULTS.getValue()));
        txtAdults.waitUntilClickable().click();
        getDriver().findElement(By.xpath("//div[contains(@class,'theme__dropdown___co-4M WhiteDropDown__dropdown___2JJF3 theme__active___31xyK WhiteDropDown__active___3HcKK Hero__dropdown-size-2___2eNNl')]//child::li[normalize-space(.)='" + numAdults + "']")).click();
    }

    public void selectNumberChildren() {
        int numChild = Integer.parseInt(sessionVariableCalled(CHILD.getValue()));
        txtChild.click();
        getDriver().findElement(By.xpath("//div[contains(@class,'theme__dropdown___co-4M WhiteDropDown__dropdown___2JJF3 theme__active___31xyK WhiteDropDown__active___3HcKK Hero__dropdown-size-2___2eNNl')]//child::li[normalize-space(.)='" + numChild + "']")).click();
    }

    public void selectDestination() {
        btnDestination.click();
    }

    public void selectLaunch() {
        String nameLaunch = (sessionVariableCalled(LAUNCH.getValue()));
        txtLaunch.waitUntilVisible();
        txtLaunch.click();
        getDriver().findElement(By.xpath("//div[@class= 'theme__dropdown___co-4M theme__active___31xyK Gallery__dropdown-size-1___3IWmB']/descendant::li[text() = '" + nameLaunch + "']")).click();
    }

    public void selectPlanetColor() {
        String namePlanet = (sessionVariableCalled(PLANET_COLOR.getValue()));
        txtPlanetColor.waitUntilVisible();
        txtPlanetColor.click();
        getDriver().findElement(By.xpath("//div[@class= 'theme__dropdown___co-4M theme__active___31xyK Gallery__dropdown-size-1___3IWmB']/descendant::li[text() = '" + namePlanet + "']")).click();
    }

    public String getCurrentMonth() {
        return getDriver()
                .findElement(
                        By.xpath(
                                "//*[@class ='theme__title___2Ue3-']"))
                .getText();
    }

    public Boolean validateCalendarDays() {
        return getDriver()
                .findElement(
                        By.xpath(
                                "//*[@class='theme__days___3kAIy']"))
                .isDisplayed();
    }

    public void addDate(String month, int day) {
        boolean option = true;
        while (option) {
            Utilities.waitTime(2);
            String currentMonth = getCurrentMonth();
            Utilities.waitTime(1);
             if (!currentMonth.equals(month)) {
                 btnNextMonth.click();
             } else {
                option = false;
            }
        }
            if (validateCalendarDays()) {
                getDriver().findElement(By.xpath("//*[@class='theme__days___3kAIy']//span[text()='" + day + "']")).click();
                btnOk.waitUntilClickable().click();
            }
    }

    public Boolean checkCardInformation(String nameLaunch) {
        return getDriver()
                .findElement(
                        By.xpath(
                                "//div[@class='theme__cardTitle___3Tyrr GalleryItem__cardTitle___3q1X_ theme__large___3eNqf']//*[text()='" + nameLaunch + "']"))
                .isDisplayed();
    }
}


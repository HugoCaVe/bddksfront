package com.ksfront.pom.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.testim.io/login")
public class LoginPage extends PageObject {
    @FindBy(xpath = "//input[@class='theme__inputElement___27dyY' and @tabindex='1']")
    private WebElementFacade txtUser;

    @FindBy(xpath = "//input[@class='theme__inputElement___27dyY' and @tabindex='2']")
    private WebElementFacade txtPassword;

    @FindBy(xpath = "//button[contains(@form,'login') and contains(text(),'Log in')]")
    private WebElementFacade btnLogin;

    public boolean validateUser() {
        return txtUser.isDisplayed();
    }

    public boolean validatePassword() {
        return txtPassword.isDisplayed();
    }

    public void selectUserField() {
        txtUser.waitUntilClickable().click();
    }

    public void selectPasswordField() {
        txtPassword.waitUntilClickable().click();
    }

    public void setUserName(String user) {
        txtUser.click();
        txtUser.sendKeys(user);
    }

    public void setPassword(String pass) {
        txtPassword.click();
        txtPassword.sendKeys(pass);
    }

    public void sendInformation() {
        btnLogin.click();
    }
}

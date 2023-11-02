package com.ksfront.pom.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage extends PageObject {

    @FindBy(xpath = "//button[not(@disabled) and text()='Pay now']")
    private WebElementFacade btnPayNow;

    @FindBy(xpath = "//*[@class= 'theme__input___qUQeP CustomerInfo__input___eFffe']/span[text()='Name']/../input")
    private WebElementFacade txtPersonName;

    @FindBy(xpath = "//*[@class= 'theme__input___qUQeP CustomerInfo__input___eFffe']/span[text()='Email Address']/../input")
    private WebElementFacade txtEmail;

    @FindBy(xpath = "//*[@class= 'theme__input___qUQeP CustomerInfo__input___eFffe']/span[text()='Social Security Number']/../input")
    private WebElementFacade txtSocialSecurityNumber;

    @FindBy(xpath = "//*[@class= 'theme__input___qUQeP CustomerInfo__input___eFffe']/span[text()='Phone Number']/../input")
    private WebElementFacade txtPhoneNumber;

    @FindBy(xpath = "//*[@class= 'theme__text___1nV6f']")
    private WebElementFacade chbAgreeTerms;

    public boolean validateName() {
        return txtPersonName.isDisplayed();
    }

    public boolean validateEmail() {
        return txtEmail.isDisplayed();
    }

    public boolean validateSocialSecurity() {
        return txtSocialSecurityNumber.isDisplayed();
    }

    public boolean validatePhoneNumber() {
        return txtPhoneNumber.isDisplayed();
    }

    public void enterCostumerName(String name) {
        txtPersonName.waitUntilClickable().click();
        txtPersonName.sendKeys(name);
    }

    public void enterEmail(String email) {
        txtEmail.click();
        txtEmail.sendKeys(email);
    }

    public void enterSocialSecurity(String securityNumber) {
        txtSocialSecurityNumber.click();
        txtSocialSecurityNumber.sendKeys(securityNumber);
    }

    public void enterPhoneNumber(String phoneNumber) {
        txtPhoneNumber.click();
        txtPhoneNumber.sendKeys(phoneNumber);
    }

    public void checkAgreeTerms() {
        chbAgreeTerms.waitUntilClickable().click();
    }

    public boolean validatePayNow() {
        return btnPayNow.isSelected();
    }
}
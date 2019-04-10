package com.project.selenium.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.project.selenium.util.CommonUtils.*;
import static com.project.selenium.util.SigninPageUtils.*;

public class BookingSignInPage extends PageObject {

    @FindBy(xpath = CHANGE_LANGUAGE_BUTTON_XPATH)
    private WebElement changeLanguage;

    @FindBy(xpath = SET_ENGLISH_LANGUAGE_BUTTON_XPATH)
    private WebElement setEnglishLanguage;

    @FindBy(xpath = CLOSE_POPUP_BUTTON_XPATH)
    private WebElement closePopupButton;

    @FindBy(xpath = SIGNIN_BUTTON_XPATH)
    private WebElement registerButton;

    @FindBy(xpath = SIGNIN_TAB_BUTTON_XPATH)
    private WebElement registrationTabButton;

    @FindBy(name = LOGIN_FIELD_FOR_SIGNIN)
    private WebElement email;

    @FindBy(name = PASSWORD_FIELD_FOR_SIGNIN)
    private WebElement password;

    @FindBy(xpath = SUBMIT_SIGNIN_BUTTON_XPATH)
    private WebElement submitRegistrationButton;

    @FindBy(xpath = SET_PROFILE_FIRST_NAME_XPATH)
    private WebElement profileFirstName;

    @FindBy(xpath = SET_PROFILE_LAST_NAME_XPATH)
    private WebElement profileLastName;

    @FindBy(xpath = SET_PROFILE_NAME_CONTINUE_BUTTON_XPATH)
    private WebElement continueButton;

    @FindBy(xpath = SET_PROFILE_NAME_SKIP_BUTTON_XPATH)
    private WebElement skipButton;

    @FindBy(xpath = SET_PROFILE_NAME_OK_BUTTON_XPATH)
    private WebElement okButton;

    @FindBy(xpath = GO_TO_PROFILE_DROPBOX_XPATH)
    private WebElement goToProfile;

    @FindBy(xpath = GO_TO_PROFILE_DASHBOARD_XPATH)
    private WebElement goToDashboard;

    @FindBy(xpath = GET_PROFILE_FULL_NAME_FROM_DASHBOARD_XPATH)
    private WebElement profileFullName;

    public BookingSignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangeLanguageInitialized(){
        return changeLanguage.isDisplayed();
    }

    public boolean isSignInInitialized(){
        return email.isDisplayed();
    }

    public boolean isSetNameInitialized(){
        return profileFirstName.isDisplayed();
    }

    public void changeLanguageToEnglish(){
        changeLanguage.click();
        setEnglishLanguage.click();
    }

    public void closePopupButton(){
        try{
            driver.findElement(By.xpath(CLOSE_POPUP_BUTTON_XPATH)).click();
        } catch (NoSuchElementException exception){
            System.out.println("No Such Element Exception in closePopupButton method");
        }
    }

    public void setNameIfProfileIsJustCreated(String firstName, String lastName){
        try{
            if (isSetNameInitialized()){
                setProfileFirstName(firstName);
                setProfileLastName(lastName);
                clickContinueButton();
                clickSkipButton();
                clickOkButton();
            }
        } catch (NoSuchElementException exception){
            System.out.println("No Such Element Exception in setNameIfProfileJustCreated method");
        }
    }

    public void clickOnSignInButton(){
        registerButton.click();
    }

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void submitSignIn(){
        submitRegistrationButton.click();
    }

    public void setProfileFirstName(String firstName){
        this.profileFirstName.sendKeys(firstName);
    }

    public void setProfileLastName(String lastName){
        this.profileLastName.sendKeys(lastName);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickSkipButton(){
        skipButton.click();
    }

    public void clickOkButton(){
        okButton.click();
    }

    public void clickOnProfile(){
        goToProfile.click();
    }

    public void clickOnProfileDashboard(){
        goToDashboard.click();
    }

    public boolean getProfileFullName(String fullName){
        return profileFullName.getText().contains(fullName);
    }
}

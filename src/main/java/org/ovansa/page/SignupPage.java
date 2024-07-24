package org.ovansa.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private final By emailField = AppiumBy.accessibilityId("input-email");
    private final By passwordField = AppiumBy.accessibilityId("input-password");
    private final By passwordConfirmField = AppiumBy.accessibilityId("input-repeat-password");
    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By successMessage = By.id("android:id/message");
    private final By okButton = By.id("android:id/button1");

    private final WebDriverWait wait;

    public SignupPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String signUp(String email, String password, String repeatPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(passwordConfirmField)).sendKeys(repeatPassword);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();

        final String messageText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
        wait.until(ExpectedConditions.elementToBeClickable(okButton));

        return messageText;
    }
}

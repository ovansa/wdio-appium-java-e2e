package org.ovansa.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final By loginMenuButton = AppiumBy.accessibilityId("Login");

    private final By loginTabButton = AppiumBy.accessibilityId("button-login-container");
    private final By signUpTabButton = AppiumBy.accessibilityId("button-sign-up-container");

    private final WebDriverWait wait;

    public HomePage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLoginSignUpPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginMenuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpTabButton)).click();
    }
}

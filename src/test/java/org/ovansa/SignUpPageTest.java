package org.ovansa;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.ovansa.page.HomePage;
import org.ovansa.page.SignupPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

public class SignUpPageTest {
    AndroidDriver driver;

    @BeforeClass
    public void setupClass() throws MalformedURLException {
        final UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(Path.of(System.getProperty("user.dir"), "src/test/resources/wdio.apk").toString());
//        options.setDeviceName("Pixel7");
        options.setPlatformName("Android").setPlatformVersion("7.1.1");
//        options.setAppWaitActivity("com.wdioemoapp.MainActivity");
        options.setCapability("appium:settings[ignoreUnimportantViews]", true);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS, true);
    }

    @AfterClass
    public void tearDownClass() throws MalformedURLException {
        driver.quit();
    }

    @Test
    public void testSignUpWithValidEmailAndPasswords() {
        final HomePage homePage = new HomePage(driver);
        final SignupPage signupPage = new SignupPage(driver);

        homePage.navigateToLoginSignUpPage();
        String signUpMessage = signupPage.signUp("ovansa@gmail.com", "password", "password");

        Assert.assertEquals("You successfully signed up!", signUpMessage);
    }

    public void testSignUpEmptyEmailAndPasswords() {
        final HomePage homePage = new HomePage(driver);
        final SignupPage signupPage = new SignupPage(driver);

        homePage.navigateToLoginSignUpPage();
        String signUpMessage = signupPage.signUp("", "", "");

        Assert.assertEquals("You successfully signed up!", signUpMessage);
    }
}

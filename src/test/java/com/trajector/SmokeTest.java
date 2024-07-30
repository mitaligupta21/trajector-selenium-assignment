package com.trajector;

import com.pages.HomePage;
import com.pages.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Random;


public class SmokeTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/mitaligupta/Downloads/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=375,667"); // Mobile viewport size
        driver = new ChromeDriver(options);
        driver.get("https://trajectormedical.com");
    }

    @Test
    public void testFreeMedicalEvaluation() {
        try {
            // Verify we are on the correct page
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://trajectormedical.com");

            // Create page object
            HomePage homePage = new HomePage(driver);

            // Wait for the Free Medical Evaluation button to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Free Medical Evaluation']")));

            // Click the button
            homePage.clickFreeMedicalEvaluation();

            // Generate random names
            String firstName = RandomDataGenerator.getRandomFirstName();
            String lastName = RandomDataGenerator.getRandomLastName();

            // Populate the form
            homePage.populateForm(firstName, lastName);

            // Assertions
            // Add assertions as needed to verify form submission or interaction
            Assert.assertTrue(driver.findElement(By.id("some-element-after-form-submit")).isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

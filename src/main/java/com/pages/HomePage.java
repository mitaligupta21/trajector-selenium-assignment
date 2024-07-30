package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By freeMedicalEvaluationButton = By.xpath("//button[text()='Free Medical Evaluation']");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");

    public void clickFreeMedicalEvaluation() {
        driver.findElement(freeMedicalEvaluationButton).click();
    }

    public void populateForm(String firstName, String lastName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
    }
}


package com.stctv.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private final Duration TIMEOUT = Duration.ofSeconds(30);
    private final Duration POLLING_TIMEOUT = Duration.ofMillis(200);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void clickButton(By locator) {
        WebElement element = findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}

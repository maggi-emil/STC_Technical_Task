package com.stctv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    private final By languageLink = By.id("translation-btn");
    private final By countryDropDownButton = By.id("country-btn");
    private String countryOption = "//span[contains(@id, 'contry') and contains(text(), '@Country')]";

    public Header(WebDriver driver) {
        super(driver);
    }

    public void switchLanguage() {
        clickButton(languageLink);
    }

    public void switchCountry(String country) {
        clickButton(countryDropDownButton);
        By countryXpath = By.xpath(countryOption.replace("@Country", country));
        clickButton(countryXpath);
    }
}

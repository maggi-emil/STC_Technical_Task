package com.stctv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class BundlesPage extends BasePage {

    private final Header header;
    private final By bundlesNames = By.xpath("//strong[@class=\"plan-title\"]");
    private final By bundlesPrice = By.xpath("//div[@class=\"price\"]/b");
    private final By bundlesCurrency = By.xpath("//div[@class=\"price\"]/i");

    public BundlesPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }

    public List<String> getBundleNames() {
        return findElements(bundlesNames).stream().map(ele -> ele.getText()).collect(Collectors.toList());
    }

    public List<String> getBundlesPrice() {
        return findElements(bundlesPrice).stream().map(ele -> ele.getText()).collect(Collectors.toList());
    }

    public String getBundlesCurrency() {
        return findElement(bundlesCurrency).getText();
    }
 }

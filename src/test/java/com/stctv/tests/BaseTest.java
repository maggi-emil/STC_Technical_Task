package com.stctv.tests;

import com.stctv.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private WebDriver driver;
    private final String dataPath = "src/test/resources/config.properties";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(PropertiesReader.readProperty("STC_TV_URL", dataPath));
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getDataPath() {
        return dataPath;
    }
}

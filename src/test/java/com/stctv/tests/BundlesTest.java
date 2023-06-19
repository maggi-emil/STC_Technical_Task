package com.stctv.tests;

import com.stctv.pages.BundlesPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BundlesTest extends BaseTest {

    private BundlesPage bundlesPage;

    @Test(dataProvider = "bundle-details-per-country")
    public void testBundlesTypeAndPricePerCountry(String country, List<String> expectedBundleNames, List<String> expectedBundlesPrice, String expectedCurrency) {
        bundlesPage = new BundlesPage(getDriver());
        bundlesPage.getHeader().switchCountry(country);
        List<String> actualBundleNames = bundlesPage.getBundleNames();
        List<String> actualBundlePrices = bundlesPage.getBundlesPrice();
        String actualBundleCurrency = bundlesPage.getBundlesCurrency();
        Assert.assertEquals(expectedBundleNames, actualBundleNames);
        Assert.assertEquals(expectedBundlesPrice, actualBundlePrices);
        Assert.assertEquals(expectedCurrency, actualBundleCurrency);
    }

    @DataProvider(name = "bundle-details-per-country")
    public Object[][] bundleDetailsPerCountry(){
        return new Object[][] {
                {"UAE", Arrays.asList("LITE", "CLASSIC", "PREMIUM"), Arrays.asList("5.4","10.9","16.3"), "USD/month"},
                {"Algeria", Arrays.asList("LITE", "CLASSIC", "PREMIUM"), Arrays.asList("2.7","5.3","8"), "USD/month"},
                {"Chad", Arrays.asList("LITE", "CLASSIC", "PREMIUM"), Arrays.asList("2.4","4.8","7.2"), "USD/month"}
        };
    }
}

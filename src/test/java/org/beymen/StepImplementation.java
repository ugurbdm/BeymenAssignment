package org.beymen;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class StepImplementation extends BaseTest {

    Logger logger = LogManager.getLogger(StepImplementation.class);


    @Step("<second> Wait")
    public void waitForSecond(int second) throws InterruptedException {

        Thread.sleep(1000 * second);

    }

    @Step("<ID> Skip Navigation")
    public void skipNavigation(String ID) {

        MobileElement element = appiumDriver.findElement(By.id(ID));
        element.click();

    }

    @Step("<ID> Click Search")
    public void clickSearch(String ID) {
        MobileElement element = appiumDriver.findElement(By.id(ID));
        element.click();

    }

    @Step("<ID> Click and Write <key>")
    public void searchToElement(String ID, String key) {
        MobileElement element = appiumDriver.findElement(By.id(ID));
        element.click();
        element.sendKeys(key);

        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    @Step("<ID> Filter")
    public void filterElement(String ID) {

        MobileElement element = appiumDriver.findElement(By.id(ID));
        element.click();

    }

    @Step("<xpath> Choose Product Group")
    public void selectProductGroup(String xpath) {

        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();

    }

    @Step("<xpath> Select Product Group")
    public void selectProductItem(String xpath) {

        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();

    }

    @Step("<ID> List Item")
    public void listProduct(String ID) {

        MobileElement element = appiumDriver.findElement(By.id(ID));
        element.click();

    }

    @Step("<xpath> Select Product")
    public void selectProduct(String xpath) {

        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();


    }

    @Step("<ID> Add To Favorite")
    public void addToFavorite(String ID) {
        String name = appiumDriver.findElement(By.id("com.mobisoft.beymen:id/addToCartButton")).getText();

        if (name.equals("SEPETE EKLE")) {
            Assert.assertTrue(true);
            logger.info("Bulundu.");
            MobileElement element = appiumDriver.findElement(By.id(ID));
            element.click();

        } else {
            Assert.fail();
        }

    }

    @Step("<xpath> Check Login Page")
    public void checkLoginPage(String xpath) {
        String name = appiumDriver.findElement(By.xpath("//*[@text='Kullanıcı Girişi']")).getText();

        if (name.equals("Kullanıcı Girişi")) {
            Assert.assertTrue(true);
            logger.info("Bulundu.");
            MobileElement element = appiumDriver.findElement(By.xpath(xpath));
            element.click();

        } else {
            Assert.fail();
        }


    }


}

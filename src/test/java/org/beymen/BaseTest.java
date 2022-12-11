package org.beymen;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {


    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid = true;

    Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeScenario
    public void setUp() throws MalformedURLException {

        if (localAndroid) {

            logger.info("Beymen Mobile Testi Başlıyor.");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4a");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mobisoft.beymen.activity.SplashActivity");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobisoft.beymen");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver<MobileElement>(url, desiredCapabilities);


        }
    }

    @AfterScenario
    public void afterScenario() {


        appiumDriver.quit();

    }
}

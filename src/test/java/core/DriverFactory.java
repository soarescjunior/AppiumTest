package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver(){
        if (driver == null){
            createDriver();
            //createDriverSouceLabs();
        }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Automacoes/Mobile/CursoAppium/src/test/resources/CTAppium_2_0.apk");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void createDriverSouceLabs() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
      //  caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:deviceName", "Samsung.*Galaxy.*");
      //  caps.setCapability("appium:orientation", "portrait");
        caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-soarescjunior-7fc32");
        sauceOptions.setCapability("accessKey", "d5ac9d70-2fc8-418d-ab32-44220d6243fc");
        caps.setCapability("sauce:options", sauceOptions);
        try {
            driver = new AndroidDriver<MobileElement>(new URL("https://oauth-soarescjunior-7fc32:d5ac9d70-2fc8-418d-ab32-44220d6243fc@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static void killDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

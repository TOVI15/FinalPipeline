package TimerTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.StartPage;
import pages.Timer;

import java.net.MalformedURLException;
import java.net.URL;

public class StartTest {
    AndroidDriver driver;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");
        options.setNoReset(false);
        options.setFullReset(false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @Test
    public void loadGoogleSearch() throws InterruptedException, MalformedURLException {

        StartPage firstPage = new StartPage(driver);
        Assertions.assertTrue(firstPage.isOnPage());
        firstPage.onclick();
//        Timer timerPage = new Timer(driver);
//        timerPage.onTimer();


    }

//    @AfterEach
//    public void afterEach(){
//        driver.quit();
//    }
//
}

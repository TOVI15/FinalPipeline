package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Timer extends BasePage{
    public Timer(AndroidDriver d) {
        super(d);
    }

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_6")
    private WebElement six;

    @AndroidFindBy(id = "com.google.android.deskclock:id/fab")
    private WebElement startTimer;
    @AndroidFindBy(id = "com.google.android.deskclock:id/fab")
    private WebElement time;
    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_text")
    private WebElement zeroTimer;
    @AndroidFindBy(id = "com.google.android.deskclock:id/play_pause")
    private WebElement stopTimer;
    @AndroidFindBy(id = "com.google.android.deskclock:id/toolbar")
    private WebElement title;
    public boolean isOnPage() {
        try{
            visibilityOf(title).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public void onTimer() throws InterruptedException {
        six.click();
        if (getText(six.getText())){
            startTimer.click();
            Thread.sleep(6000);
        }
        if (getText(zeroTimer.getText())){
            stopTimer.click();
        }
    }
    public  boolean getText(String text){
        return  time.getText().equals(text);
    }
}

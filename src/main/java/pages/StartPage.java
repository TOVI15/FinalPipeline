package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage{
    public StartPage(AndroidDriver d) {
        super(d);
    }
    @AndroidFindBy(id = "com.google.android.deskclock:id/toolbar")
    private WebElement title;
    @AndroidFindBy(id = "com.google.android.deskclock:id/tab_menu_timer")
    private WebElement timer;
    public boolean isOnPage() {
        try{
            visibilityOf(title).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void onclick(){
        timer.click();
    }

}

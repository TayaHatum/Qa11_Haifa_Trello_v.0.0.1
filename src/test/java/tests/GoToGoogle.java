package tests;

import manager.ListenerNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerNg.class)
public class GoToGoogle {

    WebDriver wd;
    @Test (enabled = false)
    public void startGoogle(){

        wd = new FirefoxDriver();
        wd.navigate().to("https://google.com");
    }
}

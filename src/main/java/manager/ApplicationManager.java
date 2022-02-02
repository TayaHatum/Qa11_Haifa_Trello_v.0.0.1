package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        user = new UserHelper(wd);

    }
    public void stop(){
        wd.quit();
    }

    public UserHelper user() {
        return user;
    }
}

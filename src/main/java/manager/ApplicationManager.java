package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;

    public void init(){
         wd = new EventFiringWebDriver(new ChromeDriver());

        //wd = new FirefoxDriver();

        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        wd.register(new MyListener());

    }
    public void stop(){
        wd.quit();
    }

    public UserHelper user() {
        return user;
    }

    public BoardHelper board() {
        return board;
    }
}

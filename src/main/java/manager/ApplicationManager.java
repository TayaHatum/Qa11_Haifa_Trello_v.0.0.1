package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver(options));
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }


        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        wd.register(new MyListener());

    }

    public void stop() {

        // wd.close();
       // wd.quit();
    }

    public UserHelper user() {
        return user;
    }

    public BoardHelper board() {
        return board;
    }
}

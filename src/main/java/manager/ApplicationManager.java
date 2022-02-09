package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;
    BoardHelper board;

    public void init(){
       wd = new ChromeDriver();

        //wd = new FirefoxDriver();

        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        user = new UserHelper(wd);
        board = new BoardHelper(wd);

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

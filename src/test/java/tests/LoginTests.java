package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        // open form
        wd.findElement(By.cssSelector("[href='/login']")).click();

        //fill form:
        // email
        WebElement email = wd.findElement(By.id("user"));
        email.click();
        email.clear();
        email.sendKeys("hatum.testing@gmail.com");

        // click enter with atlassian
        wd.findElement(By.id("login")).click();
       // pause 2sec = 2000msec
        Thread.sleep(2000);
        //password
        WebElement password = wd.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("Hatum21$");

        // submit form
        wd.findElement(By.cssSelector("#login-submit")).click();


        //Assert ? isLoginSUCCESS?

        Assert.assertTrue(wd.findElements(By.cssSelector("[aria-label='Open member menu']")).size()>0);
        Assert.assertTrue(wd.findElement(By.cssSelector("[aria-label='Open member menu']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
       wd.quit();
    }
}

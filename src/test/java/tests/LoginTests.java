package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

@BeforeMethod
public void preCondition(){
    if(isLogged()){
        logout();
    }
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

    @Test
    public void loginSuccessNew(){
        initLogin();
        fillLoginForm("hatum.testing@gmail.com","Hatum21$");
        submitLogin();

        Assert.assertTrue(isAvatarPresent());
    }

@Test
    public void loginUnsuccessfulWithWrongEmail(){
    initLogin();
    fillLoginFormWrongEmail("hatum.testinggmail.com","Hatum21$");
    submitLoginWithError();
    pause(1000);


    Assert.assertEquals(textErrorMessage(),"There isn't an account for this username");

}

}

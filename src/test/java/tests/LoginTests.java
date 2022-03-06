package tests;

import manager.MyDataProvider;
import models.Auth;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.user().isLogged()) {
            app.user().logout();
        }
    }

    // @Test
    //  public void loginSuccess() throws InterruptedException {
//
//
//        // open form
//        wd.findElement(By.cssSelector("[href='/login']")).click();
//
//        //fill form:
//        // email
//        WebElement email = wd.findElement(By.id("user"));
//        email.click();
//        email.clear();
//        email.sendKeys("hatum.testing@gmail.com");
//
//        // click enter with atlassian
//        wd.findElement(By.id("login")).click();
//       // pause 2sec = 2000msec
//        Thread.sleep(2000);
//        //password
//        WebElement password = wd.findElement(By.id("password"));
//        password.click();
//        password.clear();
//        password.sendKeys("Hatum21$");
//
//        // submit form
//        wd.findElement(By.cssSelector("#login-submit")).click();
//
//
//        //Assert ? isLoginSUCCESS?
//
//        Assert.assertTrue(wd.findElements(By.cssSelector("[aria-label='Open member menu']")).size()>0);
//        Assert.assertTrue(wd.findElement(By.cssSelector("[aria-label='Open member menu']")).isDisplayed());
    //  }


    @Test
    public void loginSuccessTestTesttestJS() {

        app.user().initLogin();
        app.user().fillLoginFormTestTestTestJS("hatum.testing@gmail.com", "Hatum21$");
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test
    public void loginSuccessTestTesttest() {

        app.user().initLogin();
        app.user().fillLoginFormTestTestsTests("hatum.testing@gmail.com", "Hatum21$");
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }


    @Test (dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNew(String email,String password) {
        logger.info("Test starts with email :" +email+ "and password :" +password);

        app.user().initLogin();
        //app.user().fillLoginForm("hatum.testing@gmail.com", "Hatum21$");
        app.user().fillLoginForm(email,password);
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test (dataProvider = "loginValidDataUser",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNewModel(User user) {

        logger.info("Test starts with data -->" +user );
        //User user = new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$");


        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test
    public void loginSuccessNewModel2() {


        app.user().initLogin();
        app.user().fillLoginForm(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());

    }

    @Test
    public void loginSuccessNewModelLombok() {

        Auth auth = Auth.builder().email("hatum.testing@gmail.com").password("Hatum21$").build();

        app.user().initLogin();
        app.user().fillLoginForm(auth);
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test
    public void loginUnsuccessfulWithWrongEmail() {
        app.user().initLogin();
        app.user().fillLoginFormWrongEmail("hatum.testinggmail.com", "Hatum21$");
        app.user().submitLoginWithError();
        app.user().pause(1000);


        Assert.assertEquals(app.user().textErrorMessage(), "There isn't an account for this username");

    }

    @Test
    public void loginUnsuccessfulWithWrongPassword() {

        app.user().initLogin();
        app.user().fillLoginForm("hatum.testing@gmail.com", "Hat");
        app.user().submitLogin();

        app.user().pause(1000);
        Assert.assertTrue(app.user().textErrorWrongPasswordDisplaed().contains("Incorrect email address and / or password"));
        // hatum.testing@gmail.com  // Hat

        //Incorrect email address and / or password. If you recently migrated your Trello account to an Atlassian account,
        // you will need to use your Atlassian account password. Alternatively, you can get help logging in.
    }




//
//    @Test (dataProvider = "loginValiData",dataProviderClass = MyDataProvider.class)
//    public void loginTest2Positive(String email,String password){
//
//        User user = new User().withPassword(password).withEmail(email);
//
//        app.getUser(). openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(user);
//        app.getUser().submitLogin();
//        app.getUser().pause(5000);
//        Assert.assertTrue(app.getUser().isLogged());
//    }

}

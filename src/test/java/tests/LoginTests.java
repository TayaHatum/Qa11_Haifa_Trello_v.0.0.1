package tests;

import manager.MyDataProvider;
import models.Auth;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.user().isLogged()) {
            app.user().logout();
        }
    }


    @Test(groups = {"web"})
    public void loginSuccessTestTesttestJS() {

        app.user().initLogin();
        app.user().fillLoginFormTestTestTestJS("hatum.testing@gmail.com", "Hatum21$");
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test (enabled = false)
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

    }

}

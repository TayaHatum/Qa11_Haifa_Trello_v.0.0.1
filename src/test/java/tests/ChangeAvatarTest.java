package tests;

import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
       if(app.user().isLogginButtonPresent()) {
           app.user().initLogin();
           app.user().fillLoginForm(Auth.builder().email("hatum.testing@gmail.com").password("Hatum21$").build());
           app.user().submitLogin();
       }
    }

    @Test
    public void changeAvatarTest(){
        app.user().clickAvatarImg();
        app.user().openProfileVisibility();
        app.user().navigateToAtlassianProfile();
        app.user().pause(3000);

        Assert.assertTrue(app.user().getURL().contains("https://id.atlassian.com/manage-profile"));

        app.user().initChangePhoto();
       app.user().uploadPhoto("/Users/tayahatum/Qa11Haifa/Qa11_Haifa_Trello_v.0.0.1/qa1.jpeg");
       Assert.assertTrue(app.user().isAvatarChanged());
       app.user().returnToTrelloFromAtlassian();

       Assert.assertTrue(app.user().getURL().contains("https://trello.com"));


    }
    @Test
    public void changeAvatarTest2(){
        app.user().clickAvatarImg();
        app.user().openProfileVisibility();
        app.user().navigateToAtlassianProfile();
        app.user().pause(3000);

        Assert.assertTrue(app.user().getURL().contains("https://id.atlassian.com/manage-profile"));

        app.user().initChangePhoto();
        app.user().uploadPhoto("/Users/tayahatum/Qa11Haifa/Qa11_Haifa_Trello_v.0.0.1/qa.png");
        Assert.assertTrue(app.user().isAvatarChanged());
        app.user().returnToTrelloFromAtlassian();

        Assert.assertTrue(app.user().getURL().contains("https://trello.com"));


    }
}

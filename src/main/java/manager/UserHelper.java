package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin(){
        if(wd.findElement(By.cssSelector("[href='/login']")).isDisplayed()) {
            click(By.cssSelector("[href='/login']"));
        }
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("user"),email);
        click((By.id("login")));
        pause(2000);
        type(By.id("password"),password);

    }
    public void fillLoginForm(User user) {
        type(By.id("user"), user.getEmail());
        click((By.id("login")));
        pause(2000);
        type(By.id("password"), user.getPassword());

    }


    public void fillLoginFormWrongEmail(String email, String password){
        type(By.id("user"),email);
        type(By.id("password"),password);
    }

    public void submitLogin(){
        click(By.cssSelector("#login-submit"));
    }

    public boolean isAvatarPresent(){

        return isElementPresent(By.cssSelector("[aria-label='Open member menu']"));
    }


    public boolean isLogged(){
        return isAvatarPresent();
    }

    public void logout(){
        click(By.cssSelector("[aria-label='Open member menu']"));
        click(By.xpath("//*[text()='Log out']"));
        click(By.id("logout-submit"));
    }
    public void submitLoginWithError(){
        click(By.id("login"));
    }

    public String textErrorMessage(){
        return elementGetText(By.cssSelector("#error p"));
    }

    public String textErrorWrongPasswordDisplaed() {
        return elementGetText(By.cssSelector("#login-error span"));
    }
}

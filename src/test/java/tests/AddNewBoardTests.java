package tests;

import models.Auth;
import models.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewBoardTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //login
        app.user().initLogin();
        app.user().fillLoginForm(Auth.builder().email("hatum.testing@gmail.com").password("Hatum21$").build());
        app.user().submitLogin();
    }


    @Test
    public void addNewBoardSuccess(){
        Board board = Board.builder().title("Blue1").color("Blue").build();

        app.board().initCteationBoard();
        app.board().fillBoardCreationForm(board);
        app.board().submitCrationBoard();
        app.board().pause(2000);
        app.board().returnToHome();
        app.board().pause(2000);
        Assert.assertTrue(app.board().isBoardCreatedByTitle(board));

    }
}

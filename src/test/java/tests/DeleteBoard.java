package tests;

import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoard extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.user().isLogginButtonPresent()) {
            app.user().initLogin();
            app.user().fillLoginForm(Auth.builder().email("hatum.testing@gmail.com").password("Hatum21$").build());
            app.user().submitLogin();
        }

        app.board().providerBoards();
    }

    @Test(groups = {"web"})
    public void deleteOneBoard(){
        int countBoardsBefore = app.board().getBoardCountDownList();
        logger.info("Count of boards before test was :" +countBoardsBefore);

        app.board().selectBoard();
        app.board().openSideBoardMenu();
        app.board().openMore();
        app.board().closeBoard();
        app.board().pause(2000);
        int countBoardsAfter = app.board().getBoardCountUpList();
        logger.info("Count of boards after test was :" +countBoardsAfter);

        Assert.assertEquals(countBoardsBefore,countBoardsAfter+1);

    }
}

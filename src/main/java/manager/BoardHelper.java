package manager;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initCteationBoard() {
        click(By.cssSelector("[data-test-id ='create-board-tile']"));
    }

    public void fillBoardCreationForm(Board board) {

        type(By.cssSelector("[data-test-id ='create-board-title-input']"), board.getTitle());
          //String  locator = "button[title='" + "Blue"+ "']";
        String  locator = "button[title='" + board.getColor()+ "']"; //button[title='Blue']
        String locator1 = String.format("//button[title='%s']",board.getColor());
        click(By.cssSelector(locator));
    }

    public void submitCrationBoard() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void returnToHome() {
        click(By.cssSelector("[aria-label='Back to home']"));
    }

    public boolean isBoardCreatedByTitle(Board board) {
//div.content-all-boards>div>div:nth-child(2)
        //div.content-all-boards>div>div:nth-child(2) ul a
        //div.content-all-boards>div>div:nth-child(2) ul div[title]
        List<WebElement> list = wd.findElements(By.cssSelector("div.content-all-boards>div>div:nth-child(2) ul div[title]"));

        for (WebElement el:list) {
            el.getAttribute("title").equals(board.getTitle());
            return true;
        }
        return false;
    }

    public int getBoardCountUpList(){
        return wd.findElements(By.cssSelector(".content-all-boards>div>div:nth-child(2) li")).size()-1;
    }
    public int getBoardCountDownList(){
        return  wd.findElements(By.cssSelector(".content-all-boards>div>div:nth-child(3) li")).size()-1;

    }

    public void providerBoards() {
        int count = getBoardCountUpList();
        System.out.println(count);

        if(count<9){
            // add new board
            int index =(int) (System.currentTimeMillis()/1000)%3600;
            Board board = Board.builder().title("My board -"+index).color("Green").build();
            initCteationBoard();
            fillBoardCreationForm(board);
            submitCrationBoard();
            pause(2000);
            returnToHome();
        }
    }

    public void selectBoard() {
        click(By.cssSelector(".board-tile-details"));
    }

    public void openSideBoardMenu() {
        click(By.cssSelector(".js-show-sidebar"));
    }

    public void openMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void closeBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        //pause(1000)
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf
                        (wd.findElement(By.cssSelector("[data-test-id='close-board-big-message']"))));
        click(By.cssSelector("[data-test-id='close-board-delete-board-button']"));

        click(By.cssSelector("[data-test-id='close-board-delete-board-confirm-button']"));
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h3[text()='YOUR WORKSPACES']"))));
    }
}

package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element with 'locator' --->" +by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("End of find element with 'locator' --->" +by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a throwable ---> " +throwable.getMessage());
        logger.info("**************");
//        logger.info("We have a throwable ---> " +throwable.getLocalizedMessage());
//        logger.info("**************");
//        logger.info("We have a throwable ---> " +throwable.toString());
//        logger.info("**************");
//        logger.info("We have a throwable ---> " +throwable.getStackTrace().toString()); // We have a throwable ---> [Ljava.lang.StackTraceElement;@142b3564
//        logger.info("**************");
        logger.info("We have a throwable ---> " +throwable.fillInStackTrace());
        logger.info("**************");
//        logger.info("We have a throwable ---> " +throwable.getCause()); //null
//        logger.info("**************");
//        logger.info("We have a throwable ---> " +throwable.getSuppressed().toString()); //We have a throwable ---> [Ljava.lang.Throwable;@a79480c
//        logger.info("**************");
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        String screen = "src/test/screenshots/screenshot-"+index+".png";
        logger.info("Screen with throwable  ---> " +screen);

        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(screen);

        try{
            Files.copy(tmp,screenshot);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

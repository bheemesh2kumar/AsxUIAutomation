package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class AppUtilites {


    public void waitforElement(WebDriver driver, WebElement element, int timeout) {

        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }


    public void waitWithFluenCondition(WebDriver driver, WebElement element, long maxTime, long pollingTime) {


        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(maxTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });


    }


}

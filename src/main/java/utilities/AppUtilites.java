package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class AppUtilites {

    public By toByVal(WebElement we) {
        // By format = "[foundFrom] -> locator: term"
        // see RemoteWebElement toString() implementation
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        return (By) we;
    }


    public static void waitforElement(WebDriver driver, WebElement element, int timeout) {

        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitforFrameElement(WebDriver driver, WebElement element, int timeout) {

        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
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


    public void swtichToFrame(WebDriver driver, WebElement ele) {

        driver.switchTo().frame(ele);

    }


}

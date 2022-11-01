package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FrameWorkInit extends Base {


    public void browserInit(BrowserTypes browserTypes) throws Exception {

        WebDriver driver = null;

        switch (browserTypes) {
            case chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case fireFox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case Ie:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            default:
                throw new Exception("user is not provided valid browser");

        }

        DriverContext.setDriver(driver);
        DriverContext.setBrowserBase(new BrowserBase(driver));

    }


}

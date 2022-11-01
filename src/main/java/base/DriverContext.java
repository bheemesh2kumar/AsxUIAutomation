package base;

import org.openqa.selenium.WebDriver;

public class DriverContext {

    public static WebDriver driver;
    public static BrowserBase browserBase;

    public static void setDriver(WebDriver driver) {
        DriverContext.driver = driver;
    }

    public static void setBrowserBase(BrowserBase browserBase) {
        DriverContext.browserBase = browserBase;
    }


}

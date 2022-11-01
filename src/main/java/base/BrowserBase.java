package base;

import org.openqa.selenium.WebDriver;

public class BrowserBase {

    WebDriver driver;

    public BrowserBase(WebDriver driver) {
        this.driver = driver;
    }


    public void lauchUrl(String url) {
        driver.get(url);
    }


    public void maximise() {
        driver.manage().window().maximize();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }


}

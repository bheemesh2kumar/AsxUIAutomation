package regression;

import base.BrowserTypes;
import base.DriverContext;
import base.FrameWorkInit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AsxLoginPage;
import utilities.AppUtilites;

public class AsxLoginPageTest extends FrameWorkInit {

    AppUtilites appUtilites;


    @BeforeMethod
    public void setup() throws Exception {
        browserInit(BrowserTypes.chrome);
        DriverContext.browserBase.lauchUrl("https://www2.asx.com.au/");
        DriverContext.browserBase.maximise();
        appUtilites = new AppUtilites();
    }


    @Test
    public void userlogsintoAsxsiteTest() throws Exception {
        AsxLoginPage asxLoginPage = getInstance(AsxLoginPage.class);
        appUtilites.waitforElement(DriverContext.driver, asxLoginPage.getBtnAcceptAllCookies(), 10);
        asxLoginPage.clickonAcceptCookiesButton();
        String imgText = asxLoginPage.getImageAsxonHomePage().getText();
        System.out.println("image name is : " + imgText);

        Boolean flag = asxLoginPage.isUserNavigatedAsxHomePage();
        Assert.assertTrue(flag, "user is not langed on ASX  login page");


    }


    @AfterMethod
    public void tearDown() {

        DriverContext.driver.quit();

    }


}

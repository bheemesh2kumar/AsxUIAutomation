package regression;

import base.BrowserTypes;
import base.DriverContext;
import base.FrameWorkInit;
import org.openqa.selenium.SearchContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AsxLoginPage;
import utilities.AppUtilites;

public class AsxLoginPageTest extends FrameWorkInit {

    AppUtilites appUtilites;
    AsxLoginPage asxLoginPage;


    @BeforeMethod
    public void setup() throws Exception {
        browserInit(BrowserTypes.chrome);
        DriverContext.browserBase.lauchUrl("https://www2.asx.com.au/");
        DriverContext.browserBase.maximise();
        appUtilites = new AppUtilites();
        asxLoginPage = getInstance(AsxLoginPage.class);
    }


    @Test
    public void userLandsonlogInPageTest() throws Exception {

        appUtilites.waitforElement(DriverContext.driver, asxLoginPage.getBtnAcceptAllCookies(), 10);
        asxLoginPage.clickonAcceptCookiesButton();
        String imgText = asxLoginPage.getImageAsxonHomePage().getText();
        System.out.println("image name is : " + imgText);
        Boolean flag = asxLoginPage.isUserNavigatedAsxHomePage();
        Assert.assertTrue(flag, "user is not langed on ASX  login page");
    }

    @Test
    public void userlogsIntoAsxApplicationTest() throws Exception {
        DriverContext.driver.manage().deleteAllCookies();
        appUtilites.waitforElement(DriverContext.driver, asxLoginPage.getBtnAcceptAllCookies(), 10);
        asxLoginPage.clickonAcceptCookiesButton();
        asxLoginPage.getBtnMainLogin().click();
        appUtilites.waitforFrameElement(DriverContext.driver, asxLoginPage.getiFrameElement(),
                25);
        appUtilites.waitforElement(DriverContext.driver, asxLoginPage.getTxtBoxEmailID(),
                70);
        asxLoginPage.userLogsintoAsx("manu.bheemesh@gmail.com",
                "@satyarao1");
        appUtilites.waitforElement(DriverContext.driver, asxLoginPage.getLableASXHomePageAfterLoggedIn(),
                30);
        Boolean flag = asxLoginPage.isUserLoggedIntoHomePage("bheemesh");
        Assert.assertTrue(flag, "user is not logged into Homepage");

    }


    @AfterMethod
    public void tearDown() {

        DriverContext.driver.quit();

    }


}

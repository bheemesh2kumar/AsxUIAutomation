package pages;

import base.BasePage;
import base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.AppUtilites;

public class AsxLoginPage extends BasePage {

    @FindBy(id = "loginOrSignupLbl")
    private WebElement btnMainLogin;

    @FindBy(how = How.CSS, using = "input#idToken1")
    private WebElement txtBoxEmailID;

    @FindBy(how = How.CSS, using = "input#idToken2")
    private WebElement txtBoxPwd;

    @FindBy(how = How.CSS, using = "input#loginButton_0")
    private WebElement btnLoginCLick;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement btnAcceptAllCookies;

    @FindBy(how = How.XPATH, using = "//iframe[@id='loginIframe']")
    private WebElement iFrameElement;

    @FindBy(how = How.CSS, using = "div[class='line-wrapper']>h1>span")
    private WebElement lableASXHomePageAfterLoggedIn;

    public WebElement getLableASXHomePageAfterLoggedIn() {
        return lableASXHomePageAfterLoggedIn;
    }

    public WebElement getiFrameElement() {
        return iFrameElement;
    }


    public WebElement getBtnAcceptAllCookies() {
        return btnAcceptAllCookies;
    }


    @FindBy(how = How.XPATH, using = "//div[@class='asx-img']/parent::a[@target='_self']/div[1]")
    private WebElement imageAsxonHomePage;

    public WebElement getImageAsxonHomePage() {
        return imageAsxonHomePage;
    }

    public WebElement getBtnMainLogin() {
        return btnMainLogin;
    }

    public WebElement getTxtBoxEmailID() {
        return txtBoxEmailID;
    }

    public WebElement getTxtBoxPwd() {
        return txtBoxPwd;
    }

    public WebElement getBtnLoginCLick() {
        return btnLoginCLick;
    }

    public Boolean isUserNavigatedAsxHomePage() {
        return getImageAsxonHomePage().isDisplayed();
    }


    public void userLogsintoAsx(String userName, String Pwd) {
        AppUtilites.waitforElement(DriverContext.driver, getBtnAcceptAllCookies(), 10);
        clickonAcceptCookiesButton();
        getBtnMainLogin().click();
        AppUtilites.waitforFrameElement(DriverContext.driver, getiFrameElement(),
                40);
        AppUtilites.waitforElement(DriverContext.driver, getTxtBoxEmailID(),
                100);
        getTxtBoxEmailID().sendKeys(userName);
        getTxtBoxPwd().sendKeys(Pwd);
        getBtnLoginCLick().click();
    }


    public void clickonAcceptCookiesButton() {
        getBtnAcceptAllCookies().click();
    }


    public Boolean isUserLoggedIntoHomePage(String Lablename) {
        Boolean flag = false;
        if (getLableASXHomePageAfterLoggedIn().getText().equalsIgnoreCase(Lablename)) {
            flag = true;
        }
        return flag;
    }


}

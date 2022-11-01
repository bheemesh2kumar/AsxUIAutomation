package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AsxLoginPage extends BasePage {

    @FindBy(id = "loginOrSignupLbl")
    private WebElement btnMainLogin;

    @FindBy(id = "idToken1")
    private WebElement txtBoxEmailID;

    @FindBy(id = "idToken2")
    private WebElement txtBoxPwd;

    @FindBy(id = "loginButton_0")
    private WebElement btnLoginCLick;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement btnAcceptAllCookies;

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
        getBtnMainLogin().click();
        getTxtBoxEmailID().sendKeys(userName);
        getTxtBoxPwd().sendKeys(Pwd);
        getBtnLoginCLick().click();

    }


    public void clickonAcceptCookiesButton() {
        getBtnAcceptAllCookies().click();
    }


}

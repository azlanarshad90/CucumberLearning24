package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.configReader;

import java.io.IOException;

import static utils.CommonMethods.driver;

public class LoginPage {
    @FindBy(id="txtUsername")
    public WebElement userNameLoc;

    @FindBy(id="txtPassword")
    public WebElement passwordLoc;

    @FindBy(id="btnLogin")
    public WebElement loginBtnLoc;

    @FindBy(id="welcome")
    public WebElement welcomePageLoc;

    public void loginUserName() throws IOException {
        userNameLoc.sendKeys(configReader.read("userName"));
    }

    public void loginPassword() throws IOException {
        passwordLoc.sendKeys(configReader.read("password"));
    }

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}

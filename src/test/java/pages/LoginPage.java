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

    public void loginUserName(boolean isAdmin) throws IOException {
        if(isAdmin) {
            userNameLoc.sendKeys(configReader.read("userName"));
        }
        else {
            userNameLoc.sendKeys(configReader.read("ESSUserName"));
        }
    }

    public void loginPassword() throws IOException {
        passwordLoc.sendKeys(configReader.read("password"));
    }

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}

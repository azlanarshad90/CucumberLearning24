package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonMethods.driver;

public class AddEmployeePage {
    //Object Repository (Locators)
    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id="btnSave")
    public WebElement btnSaveLoc;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeBtn;

    @FindBy(id="chkLogin")
    public WebElement createDetailBtn;

    @FindBy(id="user_name")
    public WebElement userNameField;

    @FindBy(id="user_password")
    public WebElement passwordField;

    @FindBy(id="re_password")
    public WebElement cnfrmPasswordField;

    @FindBy(id="photofile")
    public WebElement imageAddBtn;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}

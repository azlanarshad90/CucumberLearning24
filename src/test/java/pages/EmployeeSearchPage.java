package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.CommonMethods.driver;

public class EmployeeSearchPage {
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimBtnLoc;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListLoc;

    @FindBy(id="empsearch_id")
    public WebElement employeeIDLoc;

    @FindBy(id="searchBtn")
    public WebElement searchBtnLoc;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement employeeNameFieldLoc;

    public void searchInfo(String IDorName) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(IDorName);
        if (matcher.matches()) {
            employeeIDLoc.clear();
            employeeIDLoc.sendKeys(IDorName);
        }
        else {
            employeeNameFieldLoc.clear();
            employeeNameFieldLoc.sendKeys(IDorName);
        }
    }

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);
    }
}

package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;

import static utils.CommonMethods.driver;
import static utils.CommonMethods.jsHighlight;
import static utils.PageInitializer.employeeSearchPage;

public class EmployeeSearchSteps {
    private String inputEmployeeID;
    private String inputEmployeeName;
    @When("user clicks the on PIM option")
    public void user_clicks_the_on_pim_option() {
        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        employeeSearchPage.pimBtnLoc.click();
    }
    @When("user clicks on Employee List option")
    public void user_clicks_on_employee_list_option() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        employeeSearchPage.employeeListLoc.click();
//        Thread.sleep(10000);
    }
    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(By.xpath("//*[@id='empsearch_id']")).sendKeys("35248");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        inputEmployeeID = "39453818";
        employeeSearchPage.searchInfo(inputEmployeeID);
//        employeeSearchPage.employeeIDLoc.sendKeys(inputEmployeeID);
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(By.xpath("//*[@id='searchBtn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        employeeSearchPage.searchBtnLoc.click();
//        Thread.sleep(5000);
    }
    @Then("user see the employee information")
    public void user_see_the_employee_information() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        System.out.println("Test passed, user can see the employee details");
        if(inputEmployeeID != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement actualEmployeeID = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
            String actualID = actualEmployeeID.getText();
            jsHighlight(actualEmployeeID);
            Assert.assertEquals("Oops! employee not found. Please enter the correct ID", actualID, inputEmployeeID);
        }
        if (inputEmployeeName != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            Thread.sleep(5000);
            WebElement employeeNameElement = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
            String foundName = employeeNameElement.getText();
            boolean isMatch = foundName.contains(inputEmployeeName);
            jsHighlight(employeeNameElement);
            Assert.assertTrue("Oops! employee not found. Please enter the correct Name", isMatch);
//            Assert.assertEquals("Oops! employee not found. Please enter the correct Name", foundName, inputEmployeeName);
        }
    }
    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(By.xpath("//*[@id='empsearch_employee_name_empName']")).sendKeys("Sohail");
        WebDriver driver = CommonMethods.driver;
        WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        exWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ac_input inputFormatHint']")));
        inputEmployeeName = "Sepid";
//        employeeSearchPage.employeeNameFieldLoc.sendKeys(inputEmployeeName);
        employeeSearchPage.searchInfo(inputEmployeeName);
    }
}

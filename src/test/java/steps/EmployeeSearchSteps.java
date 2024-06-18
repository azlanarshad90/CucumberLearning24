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

import static utils.CommonMethods.*;
import static utils.PageInitializer.employeeSearchPage;

public class EmployeeSearchSteps {
    private String inputEmployeeID;
    private String inputEmployeeName;
    @When("user clicks the on PIM option")
    public void user_clicks_the_on_pim_option() {
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
            String foundName = employeeNameElement.getText().toLowerCase();
            boolean isMatch = false;
            if(foundName.contains(inputEmployeeName) || inputEmployeeName.contains(foundName)) {
                isMatch = true;
            }
            jsHighlight(employeeNameElement);
            Assert.assertTrue("Oops! employee not found. Please enter the correct Name", isMatch);
//            boolean isMatch = foundName.contains(inputEmployeeName);
//            jsHighlight(employeeNameElement);
//            Assert.assertTrue("Oops! employee not found. Please enter the correct Name", isMatch);
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
    @When("user enters valid employee's full name {string}")
    public void user_enters_valid_employee_s_full_name(String fullName) {
        WebDriver driver = CommonMethods.driver;
        inputEmployeeName = fullName;
//        WebElement element = driver.findElement(By.xpath("//*[@class='ac_input inputFormatHint']"));
        waitForElementToBeVisible("//*[@class='ac_input inputFormatHint']");
        employeeSearchPage.searchInfo(fullName);
    }

    @When("user enters a valid employee's partial name {string}")
    public void user_enters_a_valid_employee_s_partial_name(String partialName) {
        WebDriver driver = CommonMethods.driver;
        inputEmployeeName = partialName;
//        WebElement element = driver.findElement(By.xpath("//*[@class='ac_input inputFormatHint']"));
        waitForElementToBeVisible("//*[@class='ac_input inputFormatHint']");
        employeeSearchPage.searchInfo(partialName);
    }

    @When("user enters a valid employee's name with different capitalization {string}")
    public void user_enters_a_valid_employee_s_name_with_different_capitalization(String capName) {
        WebDriver driver = CommonMethods.driver;
        inputEmployeeName = capName.toLowerCase();
        System.out.println("==========Step 1=========");
//        WebElement element = driver.findElement(By.xpath("//*[@class='ac_input inputFormatHint']"));
        waitForElementToBeVisible("//*[@class='ac_input inputFormatHint']");
        employeeSearchPage.searchInfo(capName);
    }

    @When("user enters an invalid or non-existing employee name {string}")
    public void user_enters_an_invalid_or_non_existing_employee_name(String invalidName) {
        inputEmployeeName = invalidName.toLowerCase();
        waitForElementToBeVisible("//*[@class='ac_input inputFormatHint']");
        employeeSearchPage.searchInfo(invalidName);
    }

    @When("user enters an invalid or non-existing employee ID {string}")
    public void user_enters_an_invalid_or_non_existing_employee_id(String invalidID) {
        inputEmployeeID = invalidID;
        waitForElementToBeVisible("//*[@class='ac_input inputFormatHint']");
        employeeSearchPage.searchInfo(inputEmployeeID);
    }

    @Then("user see the message {string}")
    public void user_see_the_message(String errorMessageExpected) {
        WebDriver driver = CommonMethods.driver;
        WebElement element = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td"));
        String actualMessage = element.getText();
        jsHighlight(element);
        Assert.assertEquals("Invalid Error Message", actualMessage, errorMessageExpected);
    }
}

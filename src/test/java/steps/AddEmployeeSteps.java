package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ExcelReader;
import utils.constants;

import java.util.List;
import java.util.Map;

import static utils.CommonMethods.driver;
import static utils.PageInitializer.addEmployeePage;

public class AddEmployeeSteps {
//    AddEmployeePage page = new AddEmployeePage();
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        WebElement error = driver.findElement(By.id("validation-error"));
        String errorMsg = error.getText();
        if(errorMsg.equalsIgnoreCase("Required")) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @When("user enters firstName, middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Sohail");
//        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Abbassi");
//        AddEmployeePage page = new AddEmployeePage();
        addEmployeePage.firstNameLoc.sendKeys("Sohail");
        addEmployeePage.middleNameLoc.sendKeys("MS");
        addEmployeePage.lastNameLoc.sendKeys("Abbasi");
    }
    @When("user enters {string}, {string}, {string}")
    public void user_enters(String firstName, String middleName, String lastName) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
//        driver.findElement(By.xpath("//*[@id='middleName']")).sendKeys(middleName);
//        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
        addEmployeePage.firstNameLoc.sendKeys(firstName);
        addEmployeePage.middleNameLoc.sendKeys(middleName);
        addEmployeePage.lastNameLoc.sendKeys(lastName);
    }
    @When("user click on the save button")
    public void user_click_on_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        driver.findElement(By.xpath("//*[@id='btnSave']")).click();
        addEmployeePage.btnSaveLoc.click();
    }
    @Then("the employee will be added successfully")
    public void the_employee_will_be_added_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        System.out.println("Test Passed!! Employee added successfully.");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/pim/viewPersonalDetails/empNumber";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @When("user enters {string}, {string} and {string}")
    public void user_enters_and(String fName, String mName, String lName) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(fName);
//        driver.findElement(By.xpath("//*[@id='middleName']")).sendKeys(mName);
//        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lName);
        addEmployeePage.firstNameLoc.sendKeys(fName);
        addEmployeePage.middleNameLoc.sendKeys(mName);
        addEmployeePage.lastNameLoc.sendKeys(lName);
    }

    @When("user enters firstname and middlename and lastname from data table and verify it")
    public void user_enters_firstname_and_middlename_and_lastname_from_data_table_and_verify_it(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
        List<Map<String, String>> addEmployee = dataTable.asMaps();
        for(Map<String, String> user: addEmployee) {
            String firstName = user.get("firstName");
            String middleName = user.get("middleName");
            String lastName = user.get("lastName");

            addEmployeePage.firstNameLoc.sendKeys(firstName);
            addEmployeePage.middleNameLoc.sendKeys(middleName);
            addEmployeePage.lastNameLoc.sendKeys(lastName);
            addEmployeePage.btnSaveLoc.click();
            Thread.sleep(500);
            addEmployeePage.addEmployeeBtn.click();
            Thread.sleep(500);
        }
    }
    @When("user enters employees details using the excel file and validate")
    public void user_enters_employees_details_using_the_excel_file_and_validate() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        List<Map<String, String>> addEmployee = ExcelReader.read(constants.EXCEL_FILE_PATH, "Sheet1");
        for(Map<String, String> user: addEmployee) {
            String firstName = user.get("firstName");
            String middleName = user.get("middleName");
            String lastName = user.get("lastName");

            addEmployeePage.firstNameLoc.sendKeys(firstName);
            addEmployeePage.middleNameLoc.sendKeys(middleName);
            addEmployeePage.lastNameLoc.sendKeys(lastName);
            addEmployeePage.createDetailBtn.click();
            addEmployeePage.imageAddBtn.sendKeys(user.get("photograph"));
            addEmployeePage.userNameField.sendKeys(user.get("userNameField"));
            addEmployeePage.passwordField.sendKeys(user.get("passwordField"));
            addEmployeePage.cnfrmPasswordField.sendKeys(user.get("cnfrmPasswordField"));

            Select dd = new Select(driver.findElement(By.id("status")));
            if(firstName.equals("Alexander") || firstName.equals("Jill") || firstName.equals("Harvey") || firstName.equals("Diana")) {
                dd.selectByValue("Disabled");
            }
            addEmployeePage.btnSaveLoc.click();
            Thread.sleep(500);
            addEmployeePage.addEmployeeBtn.click();
            Thread.sleep(500);
        }
    }
}

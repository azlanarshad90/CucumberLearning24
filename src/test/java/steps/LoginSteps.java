package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Log;

import java.io.IOException;
import java.time.Duration;

import static utils.CommonMethods.driver;
import static utils.PageInitializer.loginPage;

public class LoginSteps  {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws IOException {
        CommonMethods.openBrowser();
    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws IOException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        WebElement usernameField=driver.findElement(By.xpath("//*[@id='txtUsername']"));
//        WebElement passwordField=driver.findElement(By.cssSelector("input#txtPassword"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        loginPage.userNameLoc.sendKeys(configReader.read("userName"));
        loginPage.loginUserName();
//        DOMConfigurator.configure("log4j2.xml");
        Log.startTestCase("Login: Valid Test Scenario\n");
        Log.info("Username entered");
        loginPage.loginPassword();
        Log.info("Password entered");

//        loginPage.passwordLoc.sendKeys(configReader.read("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        WebElement loginButton= driver.findElement(By.cssSelector("input#btnLogin"));
//        loginButton.click();
//        System.out.println(1/0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.loginBtnLoc.click();
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        System.out.println("Successfully Logged In");
        Assert.assertEquals("Welcome Admin", loginPage.welcomePageLoc.getText());
    }
}

package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static utils.PageInitializer.initializerPageObject;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowser() throws IOException {

        switch (configReader.read("browser")) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser");
        }
        driver.manage().window().maximize();
        driver.get(configReader.read("url"));
        initializerPageObject();
    }

    public static void closeBrowser() {
        if(driver!=null) {
            driver.quit();
        }
    }

    public static void dropDownWithSelect(WebElement webElement, String value) {
        Select dd = new Select(webElement);
        dd.selectByValue(value);
    }
    public static void dropDownWithSelect(String visibleText, WebElement webElement) {
        Select dd = new Select(webElement);
        dd.selectByVisibleText(visibleText);
    }
    public static void dropDownWithSelect(WebElement webElement, int index) {
        Select dd = new Select(webElement);
        dd.selectByIndex(index);
    }
    public static void dropDownWithoutSelect(String xpathExpressionForDropdown, String xpathExpressionForList, String value) {
        WebElement dropdown = driver.findElement(By.xpath(xpathExpressionForDropdown));
        dropdown.click();
        List<WebElement> lst = driver.findElements(By.xpath(xpathExpressionForList));
        for(WebElement list:lst) {
            String str = list.getText();
            if(str.equalsIgnoreCase(value)) {
                list.click();
                break;
            }
        }
    }

    public static String userName() throws IOException {
        return configReader.read("userName");
    }
    public static String password() throws IOException {
        return configReader.read("password");
    }
    public static byte[] takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile,new File(constants.SCREENSHOT_FILE_PATH+fileName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".jpg"));
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    public static JavascriptExecutor jsExe() {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement clickElement) {
        jsExe().executeScript("arguments[0].click();", clickElement);
    }
    public static void jsHighlight(WebElement element) {
        jsExe().executeScript("arguments[0].setAttribute('style','border: 2px solid red');", element);
    }
    public  static  WebDriverWait getwait(){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        return  wait;
    }
    public static void waitForElementToBeVisible(String xPath){
        getwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }
//    public static  WebDriver driver;
//    public static void openBrowserAndLaunchApplication() throws IOException {
//
//        switch (configReader.read("browser")){
//            case "Chrome":
//                driver=new ChromeDriver();
//                break;
//            case "FireFox":
//                driver=new FirefoxDriver();
//                break;
//            case "Edge":
//                driver=new EdgeDriver();
//                break;
//            default:
//                throw new RuntimeException("Invalid Browser Name");
//        }
////        impicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//        driver.get(configReader.read("url"));
//    }
//
//    public static void closeBrowser(){
//        if(driver!=null){
//            driver.quit();
//        }
//    }
//
//    public  static  void selectFromDropDown(WebElement dropDown,int index){
//        Select sel=new Select(dropDown);
//        sel.selectByIndex(index);
//    }
//    public  static  void selectFromDropDown(WebElement dropDown,String visibleText){
//        Select sel=new Select(dropDown);
//        sel.selectByVisibleText(visibleText);
//    }
//
//    public  static  void selectFromDropDown(String value, WebElement dropDown){
//        Select sel=new Select(dropDown);
//        sel.selectByValue(value);
//    }
//
//    public static void sendText(String text,WebElement element){
////        clear the text box
//        element.clear();
////        send the text to element
//        element.sendKeys(text);
//    }
//
//
//    public  static WebDriverWait getwait(){
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
//        return  wait;
//    }
//
//    public static void waitForElementToBeClickable(WebElement element){
//        getwait().until(ExpectedConditions.elementToBeClickable(element));
//
//    }
//
//    public static void click(WebElement element){
//        waitForElementToBeClickable(element);
//        element.click();
//    }
}

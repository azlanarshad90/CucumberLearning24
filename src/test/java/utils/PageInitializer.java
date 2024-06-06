package utils;

import pages.AddEmployeePage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {
    public static AddEmployeePage addEmployeePage;
    public static LoginPage loginPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static void initializerPageObject() {
        addEmployeePage = new AddEmployeePage();
        loginPage = new LoginPage();
        employeeSearchPage = new EmployeeSearchPage();
    }

}

package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static utils.CommonMethods.*;

public class Hooks {
    @Before
    public void start() throws IOException {
        openBrowser();
    }

    @After
    public void end(Scenario scenario) throws IOException {
        byte[] ss;
        if(scenario.isFailed()){
            ss = takeScreenshot("failed/"+scenario.getName());
        }
        else{
            ss = takeScreenshot("passed/"+scenario.getName());
        }
        scenario.attach(ss, "image/jpg", scenario.getName());
        closeBrowser();
    }
}

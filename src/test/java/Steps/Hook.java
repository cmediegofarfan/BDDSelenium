package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest (){
        //using a dummy webdriver
        //base.StepInfo = "FirefoxWebDriver";
        System.setProperty("webdriver.firefox.marionette", "D:\\libs\\geckodriver.exe");
        base.Driver = new FirefoxDriver();
        System.out.println("Opening the browser: Firefox\n");

    }

    @After
    public void FinalizeTest (Scenario scenario){
        if (scenario.isFailed()){
            //take screenshot
            System.out.println("Failed scenario: "+scenario.getName());
        }
        System.out.println("Closing the browser\n");
        //Driver.close();
    }

}

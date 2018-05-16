package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest (){
        //using a dummy webdriver
        //base.StepInfo = "FirefoxWebDriver";


        /*DesiredCapabilities options = DesiredCapabilities.chrome();
        String userProfile = "C:\\Users\\dfarfan\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\";
        ArrayList<String> switches = new ArrayList<String>();
        switches.add("--user-data-dir="+userProfile);
        options.setCapability("chrome.switches",switches);*/



        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        String userProfile = "C:\\Users\\dfarfan\\AppData\\Local\\Google\\Chrome\\User Data\\";
        options.addArguments("chrome.options", "--disable-extensions");
        options.addArguments("user-data-dir="+userProfile);
        options.addArguments("--start-maximixed");

        base.Driver = new ChromeDriver(options);
        System.out.println("Opening the browser: Firefox\n");

    }

    @After
    public void FinalizeTest (Scenario scenario){
        if (scenario.isFailed()){
            //take screenshot
            System.out.println("Failed scenario: "+scenario.getName());
        }
        System.out.println("Closing the browser\n");
        //base.Driver.close();
    }

}

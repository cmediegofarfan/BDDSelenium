package Steps;

import Base.BaseUtil;
import Pages.HomeScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;


public class LoginStepdef extends BaseUtil {

    private BaseUtil base;

    public LoginStepdef(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate Navis profile page$")
    public void i_navigate_Navis_profile_page() throws Throwable {

        System.out.println("1- Comienza el test\n");
        base.Driver.get("https://touchdesigner.navisdrive.com");


       /* base.Driver.get("www.google.com");


        Set<Cookie> cookiesList = base.Driver.manage().getCookies();
        base.Driver.quit();

        for (Cookie mycookie: cookiesList){
        base.Driver.manage().addCookie(mycookie);
        }
        base.Driver = new ChromeDriver();
*/


    }


    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsername(String account, String profile) throws Throwable {
        HomeScreen page = new HomeScreen(base.Driver);
        page.SelectProfile(account,profile);
        System.out.println("2- Going to home");
    }


    @Then("^I verify the count of my salary digits for rs ([^\"]*)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(String passWord) throws Throwable {
        System.out.println("This is the password: "+passWord);

    }
    }


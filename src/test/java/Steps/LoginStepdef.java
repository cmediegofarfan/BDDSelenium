package Steps;

import Base.BaseUtil;
import Pages.LoginScreen;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransform;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import sun.rmi.log.LogInputStream;

import java.util.List;

public class LoginStepdef extends BaseUtil {

    private BaseUtil base;

    public LoginStepdef(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate fb page$")
    public void iNavigateFbPage() throws Throwable {

        System.out.println("1- Comienza el test\n");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
        //My example from my personal computer
    }

    @And("^I click Login button$")
    public void iClickLoginButton() throws Throwable {
        LoginScreen page = new LoginScreen(base.Driver);
        page.ClickLoginbtn();
        System.out.println("3- It's clicked the button submit \n");
    }

    @Then("^I should see my personal wall$")
    public void iShouldSeeMyPersonalWall() throws Throwable {
        Assert.assertEquals("it wasn't properly loaded",base.Driver.findElement(By.id("Initial")).isDisplayed(),true);

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPass(String username, String pass) throws Throwable {
        LoginScreen page = new LoginScreen(base.Driver);
        page.Login(username,pass);
        System.out.println("2- Nombre usuario: "+username+" - Pass: "+pass);
    }

    @And("^I create an email using the ([^\"]*)$")
    public void iCreateAnEmailUsingTheNickname(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("This is your new email: "+email);

    }

    @And("^I verify the count of my salary digits for rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransform.class) int salary) throws Throwable {
        System.out.println("This is the count: "+salary);

    }

    public class UserData
        {
            public String nickname;
            public String password1;

            public UserData(String nickName, String passWord) {
                nickname = nickName;
                password1 = passWord;
            }
        }

    }


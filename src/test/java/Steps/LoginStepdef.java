package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransform;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.List;

public class LoginStepdef extends BaseUtil {

    private BaseUtil base;

    public LoginStepdef(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate fb page$")
    public void iNavigateFbPage() throws Throwable {

        System.out.println("1- Comienza el test\n");
        base.Driver.navigate().to("http://www.google.com");
        base.Driver.findElement();
    }

    @And("^I click Login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("3- Second AND: I click Login button\n");
    }

    @Then("^I should see my personal wall$")
    public void iShouldSeeMyPersonalWall() throws Throwable {
        //System.out.println("4- THEN, the driver is: "+base.StepInfo);
    }


    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
//        List<List<String>> data = table.raw();
//        System.out.println("2- Primer dato: "+data.get(0).get(0).toString()+"  Segundo Dato: "+data.get(0).get(1).toString());
        //Create an ArrayList
        List<UserData> users = table.asList(UserData.class);
        for (UserData user: users){
                    System.out.println("The nickname: "+user.nickname+" - Su password: "+user.password1+"\n");
                }

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPass(String username, String pass) throws Throwable {
        System.out.println("Nombre usuario: "+username+" - Pass: "+pass);
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


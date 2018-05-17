package Steps;

import Base.BaseUtil;
import Pages.HomeScreen;
import Pages.LoginScreen;
import com.sun.org.apache.xpath.internal.operations.Bool;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;


public class LoginStepdef extends BaseUtil {

    private BaseUtil base;

    public LoginStepdef(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate Navis profile page$")
    public void i_navigate_Navis_profile_page() throws Throwable {

        System.out.println("1- Comienza el test\n");
        //base.Driver.get("https://touchdesigner.navisdrive.com");
        base.Driver.get("http://www.fb.com/");


    }


    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsername(String account, String profile) throws Throwable {
        HomeScreen page = new HomeScreen(base.Driver);
        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.SelectProfile(account,profile);
        System.out.println("2- Going to home");
    }


    @Then("^I verify the count of my salary digits for rs ([^\"]*)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(String passWord) throws Throwable {
        System.out.println("This is the password: "+passWord);
        base.Driver.close();
        base.Driver = new ChromeDriver();
        base.Driver.navigate().to("http://www.google.com/");
        try{
            File myProfile = new File("Cookies.data");
            FileReader fileReader = new FileReader(myProfile);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreElements()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;
                    String val;
                    if (!(val=token.nextToken()).equals("null")){
                        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
                        expiry = df.parse(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                    Boolean isHttpOnly = new Boolean(token.nextToken()).booleanValue();

                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure,isHttpOnly);

                    base.Driver.manage().addCookie(ck);
                    System.out.println(ck.getDomain());
                    System.out.println(ck);


                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //base.Driver.navigate().to("http://www.fb.com/");
        base.Driver.navigate().to("https://touchdesigner.navisdrive.com");


    }

    @Given("^I navigate to Fb page page$")
    public void i_navigate_to_Fb_page_page() throws Throwable {

        System.out.println("1- Comienza el test\n");
        base.Driver.get("https://www.fb.com");

    }


    @And("^I fill ([^\"]*) and ([^\"]*)$")
    public void iFillUsername(String account, String profile) throws Throwable {
        LoginScreen page = new LoginScreen(base.Driver);
        page.Fblogin(account,profile);
        System.out.println("2- Going to home");
        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File myProfile = new File ("Cookies.data");
        try{
            myProfile.delete();
            myProfile.createNewFile();
            FileWriter fileWriter = new FileWriter(myProfile);
            BufferedWriter Bwrite = new BufferedWriter(fileWriter);
            for (Cookie ck: base.Driver.manage().getCookies()){
                Bwrite.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
                Bwrite.newLine();
                System.out.println(ck);
            }
            Bwrite.flush();
            Bwrite.close();
            fileWriter.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Given("^I go to google page page$")
    public void i_go_to_Fb_page_page() throws Throwable {

        System.out.println("1- Comienza el test\n");
        base.Driver.get("https://www.google.com");

    }
    }


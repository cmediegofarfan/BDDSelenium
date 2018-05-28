package Steps;

import Base.BaseUtil;
import Pages.HomeScreen;
import Pages.ImageLibraryScreen;
import Pages.LoginScreen;
import Pages.ViewExistingMessagesScreen;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        System.out.println("1- Test starts - Browser is opening\n");
        base.Driver.navigate().to("http://www.google.com/");
        //it charges the cookie within the browser in order to load a session and avoid the login screen
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
        base.Driver.get("https://touchdesigner.navisdrive.com");

    }


    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsername(String account, String profile) throws Throwable {
        HomeScreen page = new HomeScreen(base.Driver);
        WebDriverWait wait = new WebDriverWait(base.Driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(page.navisAccount));
        wait.until(ExpectedConditions.elementToBeClickable(page.navisProfile));
        page.SelectProfile(account,profile);
        System.out.println("2.1- Going to Navis's Dashboard");
    }


    @And("^I go to Image Library$")
    public void i_Go_To_Image_Library() throws Throwable {
        WebDriverWait wait = new WebDriverWait(base.Driver, 20);
        ImageLibraryScreen imageLibrary = new ImageLibraryScreen(base.Driver);
        wait.until(ExpectedConditions.visibilityOf(imageLibrary.linkImageLibrary));
        Set<String> test = base.Driver.getWindowHandles();
        imageLibrary.GoToImageLibrary();
    }

    @Then("^Image Library is properly opened$")
    public void image_Library_Is_Properly_Opened() throws Throwable {

        System.out.println("Image Library is opened!");
    }

    @And("^I go to View existing messages$")
    public void iGoToViewExistingMessages() throws Throwable {
        WebDriverWait wait = new WebDriverWait(base.Driver, 20);
        ViewExistingMessagesScreen viewMessages = new ViewExistingMessagesScreen(base.Driver);
        wait.until(ExpectedConditions.visibilityOf(viewMessages.designerbtn));
        Set<String> test = base.Driver.getWindowHandles();
        viewMessages.GoToViewExistingMessages();
    }

    @Then("^View existing messages is properly opened$")
    public void viewExistingMessagesIsProperlyOpened() throws Throwable {
        System.out.println("View existing message page is opened");
    }


    //To create the cookie.data file in order to save the session's cookies
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
}


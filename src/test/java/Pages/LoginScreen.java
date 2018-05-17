package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginScreen {

    public LoginScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using= "email")
    public WebElement txtEmail;

    @FindBy(how = How.ID, using= "password")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using= "email-next")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH, using= "//*[@id=\"u_0_2\"]")
    public WebElement loginBtn;





    public void NextLogin(String userEmail){
        txtEmail.sendKeys(userEmail);
        btnLogin.click();
    }

    public  void CompletePassword(String password){
        txtPassword.sendKeys(password);
    }


    @FindBy(how = How.ID, using= "pass")
    public WebElement passwordFB;

    public void Fblogin(String user, String pass){
        txtEmail.sendKeys(user);
        passwordFB.sendKeys(pass);
        loginBtn.click();

    }


    }







package Pages;

import Base.BaseUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class HomeScreen {



    public HomeScreen (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = How.XPATH, using = "//*[@id=\"ctl00_Content_Main_lstAccountList_I\"]")
    public WebElement navisAccount;

//option to select account
    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAccountList_DDD_L_LBI20T0")
    public WebElement selectAccount;

    @FindBy (how = How.XPATH, using = "//*[@id=\"ctl00_Content_Main_lstAgents_I\"]")
    public WebElement navisProfile;

    @FindBy (how = How.XPATH, using = "//*[@id=\"ctl00_Content_Main_lstAccountList_I\"]")
    public WebElement selectProfile;

    @FindBy (how = How.ID, using = "ctl00_Content_Main_cmdImpersonate_CD")
    public WebElement selectBtn;


    public void SelectProfile (String accountN, String profileN) throws Exception  {
        navisAccount.click();
        Thread.sleep(1000);
        navisAccount.sendKeys(accountN);
        //selectAccount.click();
        navisAccount.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        navisProfile.click();
        navisProfile.sendKeys(profileN);
        navisProfile.sendKeys(Keys.TAB);

        selectBtn.click();
        System.out.println("2- Get into with Account: "+accountN+"  - and Profile: "+profileN);

    }

}

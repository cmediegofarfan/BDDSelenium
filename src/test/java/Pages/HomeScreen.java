package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {

    public HomeScreen (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAccountList")
    public WebElement navisAccount;


    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAccountList_DDD_L_LBI20T0")
    public WebElement selection;

    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAccountList_B-1Img")
    public WebElement arrowbtn;

    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAgents_I")
    public WebElement navisProfile;

    @FindBy (how = How.ID, using = "ctl00_Content_Main_cmdImpersonate_CD")
    public WebElement selectBtn;

    public void SelectProfile (String accountN, String profileN){
        navisAccount.click();
        navisAccount.sendKeys(accountN);

        navisAccount.click();
        System.out.println(accountN+"   -  "+profileN);

    }

}

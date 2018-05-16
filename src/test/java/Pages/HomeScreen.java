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

    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAccountList_I")
    public WebElement navisAccount;

    @FindBy (how = How.ID, using = "ctl00_Content_Main_lstAgents_I")
    public WebElement navisProfile;

    @FindBy (how = How.ID, using = "ctl00_Content_Main_cmdImpersonate_CD")
    public WebElement selectBtn;

    public void SelectProfile (String accountN, String profileN){
        navisAccount.sendKeys(accountN);
        navisProfile.sendKeys(profileN);
        selectBtn.click();
    }

}

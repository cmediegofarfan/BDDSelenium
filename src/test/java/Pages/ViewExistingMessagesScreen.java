package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ViewExistingMessagesScreen {

    public ViewExistingMessagesScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/nav/ul/li[2]/div/span")
    public WebElement designerbtn;

    @FindBy (how = How.LINK_TEXT, using = "View Existing Messages")
    public WebElement linkViewMessages;

    public void GoToViewExistingMessages ()throws Exception{
        Thread.sleep(1000);
        designerbtn.click();
        linkViewMessages.click();
    }

}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ImageLibraryScreen {
    public ImageLibraryScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = How.XPATH, using = "//a[@class='menuButton']")
    public WebElement linkImageLibrary;

    @FindBy (how = How.ID, using = "ReactGridGallery")
    public WebElement gridGallery;

    public void GoToImageLibrary() throws Exception{
         Thread.sleep(1000);
         linkImageLibrary.click();
    }






}

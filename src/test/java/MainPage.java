import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]/a/span")
    private WebElement logOutField;

    @FindBy(xpath =  "//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]/ul/li[15]/a")
    private WebElement logOut;




    public MainPage logOut() {
        Actions action = new Actions(this.getDriver());
        action.moveToElement(logOutField).build().perform();
        this.logOut.click();
      return this;
    }

}

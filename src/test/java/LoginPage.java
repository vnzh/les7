import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav/ul/li[2]")
    private WebElement toLoginField;

    @FindBy(xpath = "//*[@id=\"user\"]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[3]/div/div[2]/form[1]/div/div[3]/div/label[2]")
    private WebElement rememberMe;

    @FindBy(xpath = "//*[@id=\"lj_loginwidget_password\"]")
    private WebElement passwField;


    final private String LOGIN = "capiw71256";
    final  private  String PASSWORD = "Lfplhfgthvf!1";



    public LoginPage sendLogin(){
        this.toLoginField.click();
        this.login.sendKeys(LOGIN);

        return this;
    }

    public LoginPage sendPassword () {
        this.passwField.click();
        this.passwField.sendKeys(PASSWORD);
        this.passwField.submit();
        return  this;
    }

    public LoginPage rememberMe (Boolean aBoolean) {
       if (false) {
           this.rememberMe.click();
       }
        return this;
    }

    public LoginPage login () {
        this.sendLogin();
        this.rememberMe(false);
        this.sendPassword();
        return this;
    }


}
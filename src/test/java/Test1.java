import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test1 {

    private static WebDriver driver;
    final static String STARTURL = "https://www.livejournal.com/";

    @DisplayName("creenShot")
    @BeforeAll
    static void getPage() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(STARTURL);

    }
    @DisplayName("ScreenShot")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void loginTest() {
        LoginPage testPage = new LoginPage(driver);
        testPage.login();
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]/a[@title=\"capiw71256\"]"));
        Assertions.assertEquals("capiw71256", webElement.getAttribute("title"));

    }
    @DisplayName("creenShot")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void logOutTest() {

        LoginPage testPage = new LoginPage(driver);
        testPage.login();
        MainPage mainPage = new MainPage(driver);
        mainPage.logOut();
        NoSuchElementException noSuchElementException = Assertions.assertThrows(NoSuchElementException.class,
                () -> mainPage.logOut());

    }


}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void driverInitialisation(){
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void driverQuit(){
        driver.quit();
    }
    public WebElement waitForElementToLoadAndReturn(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}

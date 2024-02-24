import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationCommandsTests {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void driverInitialise(){
       this.driver  = new ChromeDriver();
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void driverQuit(){
        driver.quit();
    }
    @Test
    public void navigationCommandTests(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        driver.get("https://www.flipkart.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        driver.navigate().forward();
        Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));
    }
}

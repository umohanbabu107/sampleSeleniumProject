import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

import java.time.Duration;

public class LocatorsTests extends BaseTest{
    OrangeHRMLoginPage orangeHRMLoginPage;
    @Test
    public void locatorsTest(){
        this.orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        orangeHRMLoginPage.login();
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        orangeHRMLoginPage.waitUntilElementVisible(By.cssSelector("a.oxd-userdropdown-link"));
        String aboutText = driver.findElement(By.cssSelector("a.oxd-userdropdown-link")).getText();
        Assert.assertEquals(aboutText,"About");
    }
}

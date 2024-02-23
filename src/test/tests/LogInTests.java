import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;


public class LogInTests {
    WebDriver driver = new ChromeDriver();
    OrangeHRMLoginPage orangeHRMLoginPage;
    @AfterTest
    public void closeDriver(){

    }
    @Test
    public void loginTest(){
        this.orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        this.orangeHRMLoginPage.login();
        String actualHeader = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
        Assert.assertEquals(actualHeader,"Dashboard");
        driver.quit();
    }
}

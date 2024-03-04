package masterTestSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;


public class LogInTests extends BaseTest{

    OrangeHRMLoginPage orangeHRMLoginPage;
    @Test
    public void loginTest(){
        this.orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        this.orangeHRMLoginPage.login();
        String actualHeader = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
        Assert.assertEquals(actualHeader,"Dashboard");
        driver.quit();
    }
}

package masterTestSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

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

package masterTestSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationCommandsTests extends BaseTest{

    @Test
    public void navigationCommandTests(){
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

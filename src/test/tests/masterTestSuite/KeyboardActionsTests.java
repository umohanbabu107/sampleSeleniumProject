package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class KeyboardActionsTests extends BaseTest{
    @Test
    public void keyboardActionsTests(){
        driver.get("https://text-compare.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("inputText1")).sendKeys("Hello Mohan");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        System.out.println(driver.findElement(By.id("inputText1")).getAttribute("value"));
        Assert.assertEquals(driver.findElement(By.id("inputText1")).getAttribute("value"),"Hello Mohan");
    }
    @Test
    public void handlingDifferentBrowserTabsOrWindows(){
        List<String> ecomApps = new ArrayList<>();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        ecomApps.add(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.flipkart.com/");
        ecomApps.add(driver.getTitle());
        driver.switchTo().newWindow(WindowType.WINDOW);
        secondDriver = secondDriver();
        secondDriver.get("https://www.myntra.com/");
        ecomApps.add(secondDriver.getTitle());
        System.out.println(ecomApps);
    }
}

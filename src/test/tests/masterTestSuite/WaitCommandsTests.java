package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

public class WaitCommandsTests extends BaseTest{

    FluentWait<WebDriver> fluentWait;

    @Test
    public void implicitWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Register.html");
        String title = driver.getTitle();
        System.out.println(title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Actions ac = new Actions(driver);
        ac.moveToElement( driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")));
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();
        driver.findElement(By.xpath("//div[@id='Tabbed']//button")).click();
        String currentWindowHandel = driver.getWindowHandle();
        System.out.println(currentWindowHandel);
        Set<String> windowHandles = driver.getWindowHandles();
        String parentWindowHandle = windowHandles.iterator().next();
        System.out.println(parentWindowHandle);
        windowHandles.iterator().next();
        driver.switchTo().window(currentWindowHandel);
    }
    @Test
    public void fluentWaitCommands(){
        driver.get("https://demo.automationtesting.in/Register.html");
        String title = driver.getTitle();
        System.out.println(title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Actions ac = new Actions(driver);
        ac.moveToElement( driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")));
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();
        driver.findElement(By.xpath("//div[@id='Tabbed']//button")).click();
        String currentWindowHandel = driver.getWindowHandle();
        System.out.println(currentWindowHandel);
        Set<String> windowHandles = driver.getWindowHandles();
        String parentWindowHandle = windowHandles.iterator().next();
        System.out.println(parentWindowHandle);
        windowHandles.iterator().next();
        driver.switchTo().window(currentWindowHandel);
    }
    public WebElement waitForElementToLoad(By element) {
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(element);
            }
        });
        return null;
    }
}

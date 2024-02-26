import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

public class WebDriverMethodsTests extends BaseTest{

    @Test
    public void getMethods(){
        driver.get("https://demo.automationtesting.in/Register.html");
        waitForPageLoad(By.xpath("//div/h1[contains(text(),'Automation Demo Site')]"));
        String title = driver.getTitle();
        System.out.println(title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Actions ac = new Actions(driver);
        ac.moveToElement( driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")));
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        waitForElementToLoadAndReturn(By.xpath("//a[contains(text(),'Windows')]")).click();
        waitForElementToLoadAndReturn(By.xpath("//div[@id='Tabbed']//button")).click();
        waitForPageLoad(By.xpath("//a[@class='navbar-brand']"));
        String currentWindowHandel = driver.getWindowHandle();
        System.out.println(currentWindowHandel);
        Set<String> windowHandles = driver.getWindowHandles();
        String parentWindowHandle = windowHandles.iterator().next();
        System.out.println(parentWindowHandle);
        windowHandles.iterator().next();
        driver.switchTo().window(currentWindowHandel);
    }

    @Test
    public void conditionalMethods(){
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in");
        waitForPageLoad(By.id("email"));
        if(isEnabled(By.xpath("//button[contains(text(),'Skip Sign In')]"))){
            clickButton(By.xpath("//button[contains(text(),'Skip Sign In')]"));
        }
        waitForPageLoad(By.xpath("//div/h1[contains(text(),'Automation Demo Site')]"));
        if(!isSelected(By.xpath("//input[@value='Male']"))){
            clickButton(By.xpath("//input[@value='Male']"));
        }
        Assert.assertTrue(isSelected(By.xpath("//input[@value='Male']")));
        Assert.assertTrue(isDisplayed(By.id("submitbtn")));
    }
    public boolean isEnabled(By element){
       return driver.findElement(element).isEnabled();
    }
    public void clickButton(By element){
        driver.findElement(element).click();
    }
    public boolean isSelected(By element){
        return driver.findElement(element).isSelected();
    }
    public boolean isDisplayed(By element){
        return driver.findElement(element).isDisplayed();
        }
    public void waitForPageLoad(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public WebElement waitForElementToLoadAndReturn(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}

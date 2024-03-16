package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavascriptExecutorTests extends BaseTest{
    @Test
    public void javascriptExecutorTests(){
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Create javascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //ChromeDriver driver2 = new ChromeDriver();
        //JavascriptExecutor js = driver2; // Here we no need to type cast because ChromeDriver class indirectly implements JavascriptExecutor interface

        WebElement nameInputField = driver.findElement(By.id("name"));
        //nameInputField.sendKeys("Mohan");
        js.executeScript("arguments[0].setAttribute('value','Mohan')",nameInputField);

        WebElement maleRadioButton = driver.findElement(By.id("male"));
        //maleRadioButton.click();
        js.executeScript("arguments[0].click();",maleRadioButton);

        WebElement sundayCheckBox = driver.findElement(By.id("sunday"));
        //sundayCheckBox.click();
        js.executeScript("arguments[0].click();",sundayCheckBox);

        driver.switchTo().frame("frame-one796456169");
        WebElement submitButton = driver.findElement(By.id("FSsubmit"));
        //submitButton.click();
        js.executeScript("arguments[0].click();",submitButton);
    }
    @Test
    public void scrollingThePageTests() throws InterruptedException {
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //1. Scroll down by pixel
        js.executeScript("window.scrollBy(0, 3000)");
        Thread.sleep(1000);

        //2. Scroll down the page till particular element
        WebElement indiaFlag = driver.findElement(By.xpath("//td//img[@alt='Flag of India']"));
        js.executeScript("arguments[0].scrollIntoView();",indiaFlag);
        Thread.sleep(1000);

        //3. Scroll down till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);

        // 4. Scroll to top
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        Thread.sleep(1000);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public OrangeHRMLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void login(){
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
        waitUntilElementVisible(By.className("orangehrm-login-branding"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();
        waitUntilElementVisible(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']"));
    }
    public void waitUntilElementVisible(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}

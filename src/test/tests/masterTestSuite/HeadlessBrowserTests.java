package masterTestSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HeadlessBrowserTests {
    @Test
    public void headlessBrowserApproach1(){
        // Approach 1: Using WebDriver Interface
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);
        List<String> ecomApps = new ArrayList<>();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        ecomApps.add(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.flipkart.com/");
        ecomApps.add(driver.getTitle());
        System.out.println(ecomApps);
    }
    @Test
    public void headlessBrowserApproach2(){
        // Approach 2: Using WebDriverManager
        // For Edge browser EdgeOptions
        // For Firefox browser FirefoxOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        List<String> ecomApps = new ArrayList<>();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        ecomApps.add(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.flipkart.com/");
        ecomApps.add(driver.getTitle());
        System.out.println(ecomApps);
    }
}

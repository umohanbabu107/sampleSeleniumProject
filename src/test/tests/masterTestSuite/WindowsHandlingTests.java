package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsHandlingTests extends BaseTest{
    @Test
    public void windowsHandlingTests(){
        driver.get("https://testautomationpractice.blogspot.com/");
        waitForElementToLoadAndReturn(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
        waitForElementToLoadAndReturn(By.xpath("//input[@class='wikipedia-search-button']")).click();
        waitForElementToLoadAndReturn(By.id("Wikipedia1_wikipedia-search-results-header"));
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//div[@id='wikipedia-search-result-link']//a"));
        System.out.println(searchResults.size());
        for(WebElement element: searchResults){
            element.click();
        }
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowTitles = new ArrayList<>();
        for(String handle : windowHandles){
            driver.switchTo().window(handle);
            windowTitles.add(driver.getTitle());
        }
        System.out.println(windowTitles);
    }
}

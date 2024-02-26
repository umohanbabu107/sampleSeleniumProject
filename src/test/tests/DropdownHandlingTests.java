import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownHandlingTests extends BaseTest{

    @Test
    public void staticDropDownHandlingTests() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        select.selectByIndex(1);
        //select.selectByValue("4");
        select.selectByVisibleText("France");
        List<WebElement> dropdownOptions = select.getOptions();
        for(WebElement option: dropdownOptions){
            System.out.println(option.getText());
        }
        Thread.sleep(5000);
    }
    @Test
    public void bootstrapDropdownTests() throws InterruptedException {
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        for(WebElement option: dropdownOptions){
            String optionName = option.getText();
            if(optionName.equals("Python") || optionName.equals("MySQL")){
                option.click();
            }
        }
        Thread.sleep(5000);
    }

    @Test
    public void autoSuggestiveDropdownTests(){
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
        List<WebElement> autoSuggestions = driver.findElements(By.xpath("//div[@id='Alh6id']//li//div[contains(@class,'wM6W7d')]//span"));
        for(WebElement suggestion: autoSuggestions){
            String suggestionName = suggestion.getText();
            if(suggestionName.equals("selenium testing")){
                suggestion.click();
                break;
            }
        }
        System.out.println(driver.getTitle());
    }
}

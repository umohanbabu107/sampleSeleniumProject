import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckboxTests extends BaseTest{

    @Test
    public void checkBoxTests() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        //Select all the checkboxes
        for(WebElement checkbox : checkboxes){
            checkbox.click();
        }
        for(WebElement checkbox : checkboxes){
            checkbox.click();
        }
        //Select first 3 check boxes
//        for(int i=0; i<checkboxes.size()-4;i++){
//            checkboxes.get(i).click();
//        }
        //Specific checkboxes to check
        List<String> checkboxIds = List.of(Week.MONDAY.getId(),Week.FRIDAY.getId());
        for(String id: checkboxIds){
            if(!findElementById(id).isSelected()) {
                findElementById(id).click();
            }
        }
        Thread.sleep(3000);
    }

    public WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }

    public enum Week{
        MONDAY("monday"),
        TUESDAY("tuesday"),
        WEDNESDAY("wednesday"),
        THURSDAY("thursday"),
        FRIDAY("friday"),
        SATURDAY("saturday"),
        SUNDAY("sunday");
        private final String id;
        Week(String id){
            this.id = id;
        }
        public String getId(){
            return id;
        }
    }
}

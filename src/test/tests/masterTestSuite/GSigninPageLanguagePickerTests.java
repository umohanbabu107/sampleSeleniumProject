package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GSigninPageLanguagePickerTests extends BaseTest{
    @Test
    public void languagePicker(){
        driver.get("https://accounts.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean dismissButtonStatus = driver.findElement(By.xpath("//span[contains(text(),'Dismiss')]")).isDisplayed();
        if(dismissButtonStatus){
            driver.findElement(By.xpath("//span[contains(text(),'Dismiss')]")).click();
        }
        driver.findElement(By.xpath("//div[@jsname='oYxtQd']")).click();
        List<WebElement> languageElements = driver.findElements(By.xpath("//ul[@role='listbox']//li//span[@class='VfPpkd-rymPhb-Gtdoyb']//span"));
        System.out.println("Total languages: "+languageElements.size());
        for(WebElement element : languageElements){
            System.out.println(element.getText());
        }
    }

}

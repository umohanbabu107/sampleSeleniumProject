package masterTestSuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlertTests extends BaseTest {
   @Test
    public void handlingAlerts(){
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       waitForElementAndReturn(By.xpath("//button[@onclick='jsAlert()']")).click();
       alertHandle().accept();
       waitForElementAndReturn(By.xpath("//button[@onclick='jsConfirm()']")).click();
       System.out.println(alertHandle().getText());
       alertHandle().dismiss();
       waitForElementAndReturn(By.xpath("//button[@onclick='jsPrompt()']")).click();
       alertHandle().sendKeys("I entered some text");
       alertHandle().accept();
       String result = waitForElementAndReturn(By.id("result")).getText();
       Assert.assertEquals(result, "You entered: " + "I entered some text");
   }
   public WebElement waitForElementAndReturn(By element){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
   }
   public Alert alertHandle(){
      return wait.until(ExpectedConditions.alertIsPresent());
   }
}

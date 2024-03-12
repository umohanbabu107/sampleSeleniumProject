package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActionsTests extends BaseTest{
    @Test
    public void mouseHoverTests(){
        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Desktops']"))).click().perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Desktops']/parent::li//div//li[2]")))
                .click()
                .build()
                .perform();
    }

    @Test
    public void rightClickTests(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.contextClick(driver.findElement(By.xpath("//span[normalize-space()='right click me']"))).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
        driver.switchTo().alert().accept();
    }
    @Test
    public void doubleClickTests(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String value = "Hello Mohan!";
        driver.switchTo().frame("iframeResult");
        WebElement buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Copy Text']")));
        WebElement fieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field1")));
        fieldElement.clear();
        fieldElement.sendKeys(value);
        actions.doubleClick(buttonElement).build().perform();
        String actMessage = driver.findElement(By.id("field2")).getAttribute("value");
        Assert.assertEquals(actMessage,value);
    }
    @Test
    public void dragAndDropTests(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(dragAndDropAction("Washington","United States"),"Correct Match");
        Assert.assertEquals(dragAndDropAction("Rome","Italy"),"Correct Match");
        Assert.assertEquals(dragAndDropAction("Madrid","Spain"),"Correct Match");
        Assert.assertEquals(dragAndDropAction("Oslo","Norway"),"Correct Match");
        Assert.assertEquals(dragAndDropAction("Copenhagen","Denmark"),"Correct Match");
        Assert.assertEquals(dragAndDropAction("Seoul","South Korea"),"Correct Match");
        Assert.assertEquals(dragAndDropAction("Stockholm","Sweden"),"Correct Match");
    }
    @Test
    public void slideBarTests(){
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement leftSlideBar = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
        WebElement rightSlideBar = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
        System.out.println("Current location of left slide bar: "+ leftSlideBar.getLocation());
        System.out.println("Current location of right slide bar "+ rightSlideBar.getLocation());
        actions.dragAndDropBy(leftSlideBar,100,250).build().perform();
        actions.dragAndDropBy(rightSlideBar,-100,250).build().perform();
        System.out.println("Current location of left slide bar: "+ leftSlideBar.getLocation());
        System.out.println("Current location of right slide bar "+ rightSlideBar.getLocation());
    }
    public String dragAndDropAction(String sourceName, String targetName){
        WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'box') and contains(text(),'"+sourceName+"')]")));
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+targetName+"']")));
        actions.dragAndDrop(sourceElement,targetElement).build().perform();
        boolean greenColour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+targetName+"']//div"))).getAttribute("style").equals("visibility: visible; background-color: rgb(0, 255, 0);");
        boolean whiteColour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+targetName+"']//div"))).getAttribute("style").equals("visibility: visible;");
        String match = null;
        if(greenColour){
            match = "Correct Match";
        }
        if(whiteColour){
            match = "Wrong Match";
        }
        return match;
    }
}

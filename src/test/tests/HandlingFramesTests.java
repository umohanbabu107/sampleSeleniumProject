import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandlingFramesTests extends BaseTest{
    @Test
    public void handlingFrames(){
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_1.html']")));
        waitForElementToLoadAndReturn(By.xpath("//input[@name = 'mytext1']")).sendKeys("Frame 1");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
        waitForElementToLoadAndReturn(By.xpath("//input[@name = 'mytext2']")).sendKeys("Frame 2");
    }
}

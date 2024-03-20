package masterTestSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakesScreenshotTests extends BaseTest{
    @Test
    public void takeEntirePageScreenshot() throws IOException {
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE); // It will store in some random memory
        File trg = new File("C:\\Users\\umoha\\IdeaProjects\\sampleSeleniumProject\\screenshots\\fullpagescreenshot"+timestamp()+".png");
        FileUtils.copyFile(src,trg);
    }
    @Test
    public void specificElementScreenshot() throws IOException {
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src = featuredProducts.getScreenshotAs(OutputType.FILE);
        File trg = new File("C:\\Users\\umoha\\IdeaProjects\\sampleSeleniumProject\\screenshots\\featuredProducts"+timestamp()+".png");
        FileUtils.copyFile(src,trg);

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        FileUtils.copyFile(logo.getScreenshotAs(OutputType.FILE), new File(("C:\\Users\\umoha\\IdeaProjects\\sampleSeleniumProject\\screenshots\\logo" + timestamp() + ".png")));
    }
    public String timestamp(){
        LocalDateTime now = LocalDateTime.now(); // This retrieves the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");// This will create a date time format
        return now.format(formatter); // This will generate the timestamp.
    }
}

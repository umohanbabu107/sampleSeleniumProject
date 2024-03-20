package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class HandlingBrokenLinksTests extends BaseTest{
    @Test
    public void brokenLinksCheckingTest() throws IOException {
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int brokenLinksCount = 0;
        for(WebElement link : allLinks){
            // Check whether element has href attribute or not
            String hrefAttributeValue = link.getAttribute("href");
            if(hrefAttributeValue==null || hrefAttributeValue.isEmpty()){
                System.out.println(link.getText()+ " has empty href value");
                continue;
            }
            URL linkUrl = new URL(hrefAttributeValue);
            HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=400){
                System.out.println(hrefAttributeValue + " ====> is broken link");
                brokenLinksCount++;
            }
        }
        System.out.println("Broken links count is "+ brokenLinksCount);
    }
}

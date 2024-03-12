package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentsTests extends BaseTest{
    @Test
    public void purchaseFlightTicketTest(){
        driver.get("https://blazedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select selectFrom = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
        Select selectTo = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
        selectFrom.selectByVisibleText("Boston");
        selectTo.selectByVisibleText("London");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        int lowestPriceRowNumber = getLowestPriceRowNumber();
        driver.findElement(By.xpath("//table//tr["+lowestPriceRowNumber+"]//td[1]//input")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String actualSuccessMessage = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualSuccessMessage,"Thank you for your purchase today!");
    }
    public HashMap<String, List<String>> getTableData(String headerName, int headerColumnNumber){
        HashMap<String, List<String>> data = new HashMap<>();
        List<String> values = driver.findElements(By.xpath("//table//th[contains(text(),'"+headerName+"')]/ancestor::table//tr//td["+headerColumnNumber+"]"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        data.put(headerName,values);
        return data;
    }
    public int getLowestPriceRowNumber(){
        double lowPrice = getTableData("Price",6).get("Price")
                .stream()
                .map(string -> Double.parseDouble(string.split("\\$")[1]))
                .collect(Collectors.toList())
                .stream()
                .min(Double::compareTo)
                .get();
        return getTableData("Price",6).get("Price")
                .stream()
                .map(string -> Double.parseDouble(string.split("\\$")[1]))
                .collect(Collectors.toList())
                .indexOf(lowPrice) + 1;
    }
}

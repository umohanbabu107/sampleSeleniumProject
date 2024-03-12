package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class WebTableTests extends BaseTest{
    public static void main(String[] args){
        WebTableTests webTableTests = new WebTableTests();
        webTableTests.dynamicWebTableTests();
    }
    @Test
    public void staticWebTableTests(){
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Get no of rows and columns in a table
        int noOfRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        int noOfColumns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("No of rows in a table: "+noOfRows);
        System.out.println("No of columns in table: "+noOfColumns);
        System.out.println(getTableColumnDataByTableHeader("BookName"));
        System.out.println(getTableColumnDataByTableHeader("Author"));
        System.out.println(getTableColumnDataByTableHeader("Subject"));
        System.out.println(getTableColumnDataByTableHeader("Price"));
        System.out.println(getTableData());
    }
    @Test
    public void dynamicWebTableTests(){
//        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys("demo");
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verification
//        boolean isVerificationPresent = driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed();
//        if(isVerificationPresent){
//            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//        }
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        driver.findElement(By.id("menu-customer")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

        String pagesText = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int noOfPages = Integer.parseInt(pagesText.split("\\(")[1].split(" ")[0]);
        System.out.println(noOfPages);
    }
    public HashMap<String,List<String>> getTableColumnDataByTableHeader(String headerName) {
        HashMap<String, List<String>> data = new HashMap<>();
        switch (headerName) {
            case "BookName":
                data.put(headerName, driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[1]")).stream().map(WebElement::getText).collect(Collectors.toList()));
                break;
            case "Author":
                data.put(headerName,driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[2]")).stream().map(WebElement::getText).collect(Collectors.toList()));
                break;
            case "Subject":
                data.put(headerName,driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[3]")).stream().map(WebElement::getText).collect(Collectors.toList()));
                break;
            case "Price":
                data.put(headerName,driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[4]")).stream().map(WebElement::getText).collect(Collectors.toList()));
                break;
        }
        return data;
    }
    public List<String> getTableColumnData(int columnNumber){
        return driver.findElements(By.xpath("//table[@name='BookTable']//tr//td["+columnNumber+"]")).stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<Map<String,List<String>>> getTableData(){
        Map<String,List<String>> data = new HashMap<>();
        List<WebElement> labels = driver.findElements(By.xpath("//table[@name='BookTable']//td[1]"));
        for(int j=2; j<=labels.size()+1; j++) {
            String label = labels.get(j-2).getText();
            List<String> values = new ArrayList<>();
            for (int i = 2; i < 5; i++) {
                values.add(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+j+"]//td["+i+"]")).getText());
            }
            data.put(label,values);
        }
        return List.of(data);
    }
}

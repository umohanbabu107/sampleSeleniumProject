package masterTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DatePickerTests extends BaseTest{
    @Test
    public void selectDateFromCalenderTest(){
        driver.get("https://demo.automationtesting.in/Datepicker.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("datepicker1")).click();
        String expYear = "2026";
        String expMonth = "January";
        String expDate = "6";

        List<String> months = Arrays.asList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );

        while(true){
            String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            if(expYear.equals(year) && expMonth.equals(month)){
                break;
            } else if (Integer.parseInt(expYear) > Integer.parseInt(year) ||
                    (expYear.equals(year) && months.indexOf(expMonth) > months.indexOf(month))){
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            } else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
//            if(Integer.parseInt(expYear)==Integer.parseInt(year)){
//                if(expMonth.equals(month)){
//                    break;
//                }
//                else if(months.indexOf(expMonth)>months.indexOf(month)){
//                    driver.findElement(By.xpath("//a[@title='Next']")).click();
//                }
//                else{
//                    driver.findElement(By.xpath("//a[@title='Prev']")).click();
//                }
//            }
//            else if(Integer.parseInt(expYear)>Integer.parseInt(year)){
//                driver.findElement(By.xpath("//a[@title='Next']")).click();
//            }
//            else{
//                driver.findElement(By.xpath("//a[@title='Prev']")).click();
//            }
        }
        driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"))
                .stream()
                .filter(webElement -> webElement.getText().equals(expDate))
                .findFirst()
                .get()
                .click();
    }
    @Test
    public void enterDateInInputTest(){
        driver.get("https://demo.automationtesting.in/Datepicker.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("datepicker2")).sendKeys("11/06/1996"); //mm/dd/yyyy
    }
    @Test
    public void selectDateFromDropDownTypeOfCalendar() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Datepicker.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("datepicker2")).click();

        String expYear = "2057";
        String expMonth = "January";
        String expDate = "6";

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@title='Change the month']")));
        selectMonth.selectByVisibleText(expMonth);
        WebElement optionElement = driver.findElement(By.xpath("//select[@title='Change the year']//option[@selected='selected']"));
        String year = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerText;", optionElement);
        //String  = driver.findElement(By.xpath("//select[@title='Change the year']//option[@selected='selected']/text()")).getText();
        String month = driver.findElement(By.xpath("//select[@title='Change the month']//option[@selected]")).getText();
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@title='Change the year']")));
        while(true) {
            if (selectYear.getOptions().stream().map(WebElement::getText).collect(Collectors.toList()).contains(expYear)) {
                selectYear.selectByVisibleText(expYear);
                break;
            } else if (Integer.parseInt(expYear) > Integer.parseInt(year)) {
                driver.findElement(By.xpath("//select[@title='Change the year']")).click();
                driver.findElement(By.xpath("//select[@title='Change the year']/option[1]")).click();
            }
            else{
                driver.findElement(By.xpath("//select[@title='Change the year']")).click();
                driver.findElement(By.xpath("//select[@title='Change the year']/option[last()]")).click();
            }
        }
        Thread.sleep(5000);
    }
}

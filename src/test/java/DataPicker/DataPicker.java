package DataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DataPicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        //Approach 1
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/15/2022");

        //Approach 2
        String year="2019";
        String month="March";
        String date="25";
        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // will open the date picker
        //select month and year
        while (true)
        {
            String monthFromData=driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText();
            String years=driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText();
            if (monthFromData.equals(month)&&years.equals(year)){
                break;
            }
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//past

        }
        //select data
        List <WebElement> allDate=driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//td"));
        for (WebElement dt:allDate){
            if (dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
//        for (int i = 0;i<allDate.size();i++){
//            if (allDate.get(i).getText().equals(date)){
//                allDate.get(i).click();
//                break;
//            }
//        }
    }
}

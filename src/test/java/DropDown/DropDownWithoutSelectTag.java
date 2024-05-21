package DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DropDownWithoutSelectTag {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //Clicking on DropDown
        driver.findElement(By.xpath("//*[@class='multiselect dropdown-toggle btn btn-default']")).click();
        List<WebElement> options= driver.findElements(By.xpath("//ul[contains(@class,multiselect)]//label"));
        //find total number of options
        System.out.println(options.size());

        //print all the options from dropdown
        //using normal for loop
//        for (int i = 0;i<options.size();i++){
//            System.out.println(options.get(i).getText());
//        }
        //select options from dropDown
        for (int i = 0;i<options.size();i++){

            String option = options.get(i).getText();
            if (option.equals("Java") || option.equals("Python")){
                options.get(i).click();
                break;
            }
        }
    }
}

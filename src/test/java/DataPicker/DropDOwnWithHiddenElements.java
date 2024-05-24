package DataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDOwnWithHiddenElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();

        //dropDown
        driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();//opensDropDown
        List<WebElement> options=driver.findElements(By.xpath("//*[@role='listbox']//span"));
        for (WebElement option:options){
            System.out.println(option.getText());
            if (option.getText().equals("Finance Manager")){
                option.click();
                break;
            }
        }

    }
}

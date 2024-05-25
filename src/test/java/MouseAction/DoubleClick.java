package MouseAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class DoubleClick {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        driver.switchTo().frame("iframeResult");//switch to frame
        WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
        field1.clear();
        field1.sendKeys("Welcome");
        WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
        WebElement field2=driver.findElement(By.xpath("//input[@id='field2']"));
//        String textFromField2=field2.getText();
        String textFromField2=field2.getAttribute("value");
        System.out.println(textFromField2);
        if (textFromField2.equals("Welcome")){
            System.out.println("Test past");
        }else {
            System.out.println("Test fieled");
        }


    }
}

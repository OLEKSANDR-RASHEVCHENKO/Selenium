package WaitCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");

    }

}

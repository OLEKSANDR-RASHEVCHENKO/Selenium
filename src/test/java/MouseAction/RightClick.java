package MouseAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClick {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);
        actions.contextClick(button).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
        driver.switchTo().alert().accept();
    }
}

package DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoDynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.de/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Selenium");
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='sbct PZPZlf']//div[@class='wM6W7d']"));

        System.out.println(list.size());

        for (int i = 0;i<list.size();i++){
            String text = list.get(i).getText();
            if (text.equals("selenium webdriver")){
                list.get(i).click();
                break;
            }

        }
    }
}

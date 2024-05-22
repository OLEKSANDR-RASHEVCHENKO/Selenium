package Allert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllertAuto {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //Alert alertWindow= (Alert) driver.switchTo().alert();
        Alert alertWindow =myWait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alertWindow.getText());
        //alertWindow.accept();
        alertWindow.dismiss();//cansel button
    }
}

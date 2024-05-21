package Allert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertWithTextInput {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        Alert alertwindow = driver.switchTo().alert();
        System.out.println(alertwindow.getText());
        alertwindow.sendKeys("Hallo from Alex");
        alertwindow.accept();
        String act_text= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String ext_text = "You entered: Hallo from Alex";
        Assert.assertEquals(act_text,ext_text);

    }
}

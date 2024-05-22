package iframeSwich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InnerIframeFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        //Frame3
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//*[@name='mytext1']")).sendKeys("11111");
        driver.switchTo().defaultContent();
        //Frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//*[@name='mytext3']")).sendKeys("33333");

        //inner Iframe
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("div.AB7Lab")).click();//select first radiobutton in iframe

        driver.switchTo().defaultContent();//go to home page,not to frame3

    }
}

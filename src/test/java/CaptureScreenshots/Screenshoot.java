package CaptureScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class Screenshoot {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //1)) Full Page screenshot
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File sourcefile=ts.getScreenshotAs(OutputType.FILE);
//        File targetfile=new File(System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");
//        sourcefile.renameTo(targetfile);//copy sourcefile to target file

        //2)Special area of Page
//        WebElement box=driver.findElement(By.xpath("//*[@class='product-grid home-page-product-grid']"));
//        box.getScreenshotAs(OutputType.FILE);
//        File sourcefile=box.getScreenshotAs(OutputType.FILE);
//        File targetfile=new File(System.getProperty("user.dir")+"\\Screenshot\\specialArea.png");
//        sourcefile.renameTo(targetfile);//copy sourcefile to target file
        //3)Special element
        WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        element.getScreenshotAs(OutputType.FILE);
        File sourcefile=element.getScreenshotAs(OutputType.FILE);
        File targetfile=new File(System.getProperty("user.dir")+"\\Screenshot\\element.png");
        sourcefile.renameTo(targetfile);//copy sourcefile to target file




        driver.quit();

    }
}

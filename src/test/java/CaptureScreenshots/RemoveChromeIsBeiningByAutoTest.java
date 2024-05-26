package CaptureScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class RemoveChromeIsBeiningByAutoTest {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.nopcommerce.com/");
        String act_title = driver.getTitle();
        if (act_title.equals("nopCommerce demo store")){
            System.out.println("test passed");
        }else {
            System.out.println("Test failed");
        }
        driver.quit();
    }
}

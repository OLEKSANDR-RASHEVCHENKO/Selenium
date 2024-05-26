package CaptureScreenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlesTesting {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");//setting for headless mode of execution
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

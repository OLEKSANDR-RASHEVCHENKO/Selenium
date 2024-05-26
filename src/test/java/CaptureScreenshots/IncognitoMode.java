package CaptureScreenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");


        WebDriver driver=new ChromeDriver(options);

        driver.get("https://demo.nopcommerce.com/");

        String act_title=driver.getTitle();

        if(act_title.equals("nopCommerce demo store"))
        {
            System.out.println("Test Passed");
        }
        else
        {
            System.out.println("Test Failed");
        }

        //driver.quit();


    }
}

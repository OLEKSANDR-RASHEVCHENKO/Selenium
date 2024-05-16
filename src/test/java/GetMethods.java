import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        System.out.println("title of the page"+driver.getTitle());


        String currentUrl=driver.getCurrentUrl();
        System.out.println( "Current Url" + currentUrl);

//        String pageSource=driver.getPageSource();
//        System.out.println("Page Source" + pageSource);
//        System.out.println(pageSource.contains("html"));
//        System.out.println(pageSource.contains("body"));


//        System.out.println(driver.getWindowHandle());
        Thread.sleep(3000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();//open new browserWindow
        Set<String> windowId=driver.getWindowHandles();
        for (String winId:windowId){
            System.out.println(winId);
        }


    }
}

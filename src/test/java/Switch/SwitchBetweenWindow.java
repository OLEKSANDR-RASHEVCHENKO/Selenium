package Switch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchBetweenWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(3000);
        Set<String> windowsID = driver.getWindowHandles();//store 2 window id
        //Approach1
        //capture id for browser windows
        List<String> windowsList = new ArrayList(windowsID);//converter set ---> LIst
        String parentWindowId = windowsList.get(0);
        String childWindowId = windowsList.get(1);
        //Switch to child window
        driver.switchTo().window(childWindowId);

        driver.switchTo().window(parentWindowId);
        //Approach2
//        for (String winId:windowsID){
//            String title = driver.switchTo().window(winId).getTitle();
//            if (title.equals("Human Resources Management Software | OrangeHRM")){
//                //logic
//            }
//        }

        //Closing specific browser
        //1-x,2-y,3-z,4-a,5-b.....
//                for (String winId:windowsID){
//            String title = driver.switchTo().window(winId).getTitle();
//            if (title.equals("x")||title.equals("b")){
//                driver.close();
//            }
//        }
        for (String winId:windowsID){
            String title = driver.switchTo().window(winId).getTitle();
            if (title.equals("OrangeHRM")){
                driver.close();
            }
        }
    }
}

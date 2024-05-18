package WaitCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationCommands {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.de/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.bahn.de/angebot");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());//amazon
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());//db
        driver.navigate().refresh();//db

    }

}

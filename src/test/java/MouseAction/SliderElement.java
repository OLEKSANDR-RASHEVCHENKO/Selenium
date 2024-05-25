package MouseAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        Actions act=new Actions(driver);
        WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
        System.out.println("Current location "+min_slider.getLocation());//(59,250)x,y
        act.dragAndDropBy(min_slider,100,250).perform();
        System.out.println("After moving location "+min_slider.getLocation());

        WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
        System.out.println("Current location" + max_slider.getLocation());
        act.dragAndDropBy(max_slider,-96,250).perform();
    }
}

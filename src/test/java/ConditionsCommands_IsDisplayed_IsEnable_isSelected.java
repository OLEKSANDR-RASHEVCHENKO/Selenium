import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ConditionsCommands_IsDisplayed_IsEnable_isSelected {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();


//isDisplayed() IsEnable
//        WebElement logo=driver.findElement(By.xpath("//*[@class='header-logo']"));
//        Assert.assertTrue(logo.isDisplayed());
//
//        boolean status=driver.findElement(By.xpath("//*[@class='header-logo']")).isDisplayed();
//        System.out.println(status);
//
//
//        WebElement searchBox=driver.findElement(By.xpath("//*[@id='small-searchterms']"));
//        System.out.println("Display status:"+searchBox.isDisplayed());
//        System.out.println("Enable status:"+searchBox.isEnabled());

        //isSelected()
        WebElement male=driver.findElement(By.xpath("//*[@id='gender-male']"));
        WebElement female=driver.findElement(By.xpath("//*[@id='gender-female']"));

        //beforeSelection
        System.out.println("Before Selection...........");
        System.out.println(male.isSelected());//false
        System.out.println(female.isSelected());//false

        //After selection pf male radio button
        System.out.println("After selection male rd .............");
        male.click();
        System.out.println(male.isSelected());//true
        System.out.println(female.isSelected());//false


    }
}

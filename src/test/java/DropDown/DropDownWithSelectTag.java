package DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownWithSelectTag {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();


        WebElement country=driver.findElement(By.xpath("//*[@id='country-list']"));
        Select drpCountry=new Select(country);
         //Selecting an options from dropdown
//        drpCountry.selectByVisibleText("USA");
//        drpCountry.selectByValue("3");
//        drpCountry.selectByIndex(3);

        //2)Find total options in dropdown
        List<WebElement> options = drpCountry.getOptions();
        System.out.println(options.size());

        //3)Print options in console
        for (int i=0;i<options.size();i++){
            System.out.println(options.get(i).getText());
        }
        for (WebElement op:options){
            System.out.println(op.getText());
        }

    }
}

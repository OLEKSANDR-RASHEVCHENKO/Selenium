package Table;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //Find total number of rows
        //Approach 1
        int rows = driver.findElements(By.xpath("//*[@name='BookTable']//tr")).size();
        System.out.println("Number of rows: " + rows);
        //Approach 2
        //int rows=driver.findElements(By.tagName("tr")).size();
        //Find total number of columns
        int cols=driver.findElements(By.xpath("//*[@name='BookTable']//th")).size();
        System.out.println("Number of columns: " + cols);
        //Read specific rows ß columns data
        //String value=driver.findElement(By.xpath("//*[@name='BookTable']//tr[7]//td[1]")).getText();
        //System.out.println(value);
        //Read data from all the rows ß columns
//        for (int r = 2;r<=rows;r++){
//            for (int c=1;c<=cols;c++){
//                String value=driver.findElement(By.xpath("//*[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//                System.out.print(value+"\t");
//            }
//            System.out.println();
//        }
        //Print book names whose authir is Amit
//        for (int r =2;r<=rows;r++){
//            String author=driver.findElement(By.xpath("//*[@name='BookTable']//tr["+r+"]//td[2]")).getText();
//            if (author.equals("Amit")){
//                String bookname=driver.findElement(By.xpath("//*[@name='BookTable']//tr["+r+"]//td[1]")).getText();
//                System.out.println(bookname);
//            }
//        }
        //Find sum of price
        int sum = 0;
        for (int r = 2;r<=rows;r++){
            String price=driver.findElement(By.xpath("//*[@name='BookTable']//tr["+r+"]//td[4]")).getText();

            sum = sum + Integer.parseInt(price);
        }
        System.out.println("Total price of books " + sum);

    }
}

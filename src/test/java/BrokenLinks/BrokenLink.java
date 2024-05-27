package BrokenLinks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
/*
1) Link    href="https://xyz.com"

2) https://xyz.com ---> server ---> status code

3)  status code>=400   broken link
status code <400   not a broken link

 */
public class BrokenLink {
    public static void main(String[] args) throws IOException {
        //if status code less then 400,link is not broken,if more then 400 or =400 its broken link
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total number of likns: "+links.size());
        int noOfBrokenLink =0;
        for (WebElement linkElement:links){
            String hrefAttributeValue=linkElement.getAttribute("href");
            if (hrefAttributeValue == null || hrefAttributeValue.isEmpty()){
                System.out.println("href attribute value is null or empty.So nit possible to check");
                continue;
            }
            // hit url to the server
            try {
                URL linkUrl = new URL(hrefAttributeValue);//converted href value from string to Url
                HttpURLConnection connLinkUrl = (HttpURLConnection) linkUrl.openConnection(); //open connection to the server
                connLinkUrl.connect();//connect ro server and sent request to the server
                if (connLinkUrl.getResponseCode() >= 400) {
                    System.out.println(hrefAttributeValue+ " =====>Broken link");
                    noOfBrokenLink++;
                } else {
                    System.out.println(hrefAttributeValue+" =====>Not Broken");
                }
            }catch (Exception e){
            }

        }
        System.out.println("Number of broken Likns " +noOfBrokenLink );
    }
}

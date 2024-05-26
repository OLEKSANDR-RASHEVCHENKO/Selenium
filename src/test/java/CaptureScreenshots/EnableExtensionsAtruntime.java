package CaptureScreenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class EnableExtensionsAtruntime {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions();

        File file=new File("C:\\Users\\Oleksandr\\Downloads\\SelectorsHub.crx");

        options.addExtensions(file);


        WebDriver driver=new ChromeDriver(options);

        driver.get("https://text-compare.com/");

    }
}

package Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    protected static WebDriver driver;
    public static Properties prop;

    public static WebDriver intializeDriver() throws IOException {
         prop = new Properties();
        FileInputStream fil = new FileInputStream("src/main/java/Resources/Data.properties");
        prop.load(fil);
        //System.out.println("hello");
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/ChromeDriver/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    public void getScreenshot() throws IOException {
       File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src,new File("/Users/admin/Desktop/screenshot.png"));
    }

}

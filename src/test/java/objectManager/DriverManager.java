package objectManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private WebDriver driver;
    private FileReader fr;
    private Properties prop;
    public WebDriver getDriver() throws IOException {
    createDriver();
    return driver;
    }
    private void createDriver() throws IOException {
        fr=new FileReader(new File("src/test/java/utility/config.properties"));
        prop=new Properties();
        prop.load(fr);
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            driver=new FirefoxDriver();
        }
        if(prop.getProperty("browser").equalsIgnoreCase("safari")){
            WebDriverManager.chromedriver().setup();
            driver=new SafariDriver();
        }
    }


}

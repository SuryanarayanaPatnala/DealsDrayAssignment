package script;

import actions.ActionClass;
import objectManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.PageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Testcase2 {
    WebDriver driver;
    DriverManager driverManager;
    PageObjects pageObjects;
    FileReader fr;
    Properties prop;
    ActionClass actionClass;

    @Test
    void test2() throws IOException {
        fr = new FileReader("src/test/java/utility/config.properties");
        prop = new Properties();
        prop.load(fr);
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        pageObjects = new PageObjects(driver);
        actionClass = new ActionClass(driver);
        driver.get(prop.getProperty("testcase2Url"));
        actionClass.senKeys(pageObjects.username, prop.getProperty("username"));
        actionClass.senKeys(pageObjects.password, prop.getProperty("password"));
        actionClass.click(pageObjects.loginbutton);
        actionClass.click(pageObjects.orderbutton);
        actionClass.click(pageObjects.ordersSubButton);
        actionClass.click(pageObjects.bulkOrderbutton);
        actionClass.upload(pageObjects.upload, "C:\\Users\\surya\\IdeaProjects\\DealsDray\\Data\\demo-data.xlsx");
        actionClass.click(pageObjects.importButton);
        actionClass.click(pageObjects.validateButton);
        actionClass.alert();
        actionClass.takeScreenshot(driver, "TestcaseScreenshots", 1920, 1080);
        driver.close();

    }
}

package script;

import actions.ActionClass;
import objectManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Testcase1 {
    WebDriver driver;
    DriverManager driverManager;
    ActionClass action;
    WebDriverWait wait;

    @DataProvider(name = "desktopResolution")
    public Object[][] data() {
        return new Object[][]{
                {1920, 1080}, {1366, 768}, {1536, 864}
        };
    }

    @DataProvider(name = "mobileResolution")
    public Object[][] data1() {
        return new Object[][]{
                {360, 640}, {414, 896}, {375, 667}
        };
    }

    @Test(dataProvider = "desktopResolution")
    void TestDesktopUI(int a, int b) throws InterruptedException, IOException {
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        ActionClass action = new ActionClass(driver);
        driver.manage().window().setSize(new Dimension(a, b));
        driver.get("https://www.getcalley.com/page-sitemap.xml");
        int noOfUrl = 5;
        for (int i = 1; i <= noOfUrl; i++) {
            WebElement element= driver.findElement(By.xpath("//*[@id='sitemap']/tbody/tr[" + i + "]/td/a"));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Thread.sleep(100);
            action.takeScreenshot(driver, "Desktop", a, b);
            driver.navigate().back();
        }
        driver.close();
    }

    @Test(dataProvider = "mobileResolution")
    void TestmobileUI(int a, int b) throws InterruptedException, IOException {
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        action = new ActionClass(driver);
        driver.manage().window().setSize(new Dimension(a, b));
        driver.get("https://www.getcalley.com/page-sitemap.xml");
        int noOfUrl = 5;
        for (int i = 1; i <= noOfUrl; i++) {
           WebElement ele= driver.findElement(By.xpath("//*[@id='sitemap']/tbody/tr[" + noOfUrl + "]/td/a"));
           wait.until(ExpectedConditions.elementToBeClickable(ele));
           ele.click();
            Thread.sleep(100);
            action.takeScreenshot(driver, "Mobile", a, b);
            driver.navigate().back();
        }
        driver.close();
    }

}

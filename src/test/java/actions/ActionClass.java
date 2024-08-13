package actions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObjects;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.Date;

public class ActionClass {
    private  WebDriver driver;
    PageObjects pageObjects;
    public ActionClass(WebDriver driver){
        this.driver=driver;
    }
    public void takeScreenshot(WebDriver driver,String deviceType,int x,int y) throws IOException {
        Date date=new Date();
        String time=date.toString().replace(" ","_").replace(":","-");
        File destfile=new File("Screenshots/"+deviceType+"/"+x+"x"+y+"-"+time+".png");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,destfile);
    }

    public void click(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void senKeys(WebElement element,String keydata){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keydata);
    }
    public void upload(WebElement element,String path){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(path);
    }
    public void alert(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

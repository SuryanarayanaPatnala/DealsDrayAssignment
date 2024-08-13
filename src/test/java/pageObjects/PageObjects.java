package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {

    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginbutton;
    @FindBy(xpath="//div[@class='css-sukebr']/button")
    public WebElement orderbutton;
    @FindBy(linkText = "Orders")
    public WebElement ordersSubButton;
    @FindBy(xpath = "//button[.='Add Bulk Orders']")
    public WebElement bulkOrderbutton;
    @FindBy(xpath="//input[@type='file']")
    public WebElement upload;
    @FindBy(xpath = "//button[.='Import']")
    public WebElement importButton;
    @FindBy(xpath = "//button[.='Validate Data']")
    public WebElement validateButton;

    public PageObjects(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}

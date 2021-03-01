package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftPanel {

    WebDriver driver;

    @FindBy(xpath="//a[@data-test-id='compose-button']")
    WebElement btnCreate;
    @FindBy(xpath="//span[@data-test-folder-name='Inbox']")
    WebElement btnInbox;
    @FindBy(xpath="//a[@data-test-folder-name='Bulk']")
    WebElement btnSpam;

    public LeftPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Click Create button
    public void clickCreate(){
        btnCreate.click();
    }

    //Click Inbox
    public void clickInbox(){
        btnInbox.click();
    }

    //Click Spam
    public void clickSpam(){
        btnSpam.click();
    }

}

package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inbox {

    private WebDriver driver;

    @FindBy(xpath="//span[@data-test-id='message-subject']")
    private WebElement firstLetter;
    @FindBy(xpath="//div[@data-test-id='message-view-body-content']")
    private WebElement txtBodyContent;
    @FindBy(xpath="//button[@data-test-id='toolbar-delete']")
    private WebElement btnDelete;
    @FindBy(xpath="//button[@data-test-id='folder-menu-button']")
    private WebElement btnMove;
    @FindBy(xpath="//*[@id=\"6\"]")
    private WebElement spamOption;

    public Inbox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Open first letter
    public void openFirstLetter(){
        firstLetter.click();
    }

    //get body content
    public String getBodyContent(){
        return txtBodyContent.getText();
    }

    //Click Delete button
    public void clickDelete(){
        btnDelete.click();
    }

    //Move a letter to Spam folder
    public void moveToSpam(){
        btnMove.click();
        spamOption.click();
//        Actions builder = new Actions(driver);
//        builder.click(spamOption).build().perform();
    }

}

package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inbox {

    private WebDriver driver;
    private WebDriverWait driverWait;

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
    @FindBy(xpath="//button[@data-test-id='undo-button']")
    private WebElement btnUndoSpam;
//    @FindBy(xpath="//div[@data-test-id='empty-list-message']/span")
//    private WebElement EmptyMailContainer;
    @FindBy(xpath ="//div[@role='status']//button[@data-test-id='undo-button']/preceding-sibling::span")
    private WebElement confirmDelete;
    @FindBy(xpath="//div[@role='status']//span[@data-test-folder-name='Bulk']")
    private WebElement confirmSpam;

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
    }

    //get confirmation delete text
//    public String getConfirmDeletedText(){
//        return EmptyMailContainer.getText();
//    }

    //get confirmation spam text
    public String getConfirmToSpamText(){
        return confirmSpam.getText();
    }

    //get confirmation delete text
    public String getConfirmDeleteText(){
        return confirmDelete.getText();
    }

}

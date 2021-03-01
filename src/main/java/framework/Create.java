package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create {

     private WebDriver driver;

    @FindBy(id="message-to-field")
    private WebElement txtTo;
    @FindBy(xpath="//input[@data-test-id='compose-subject']")
    private WebElement txtSubject;
    @FindBy(id="editor-container")
    private WebElement txtEdit;
    @FindBy(xpath="//div[@data-test-id='rte']")
    private WebElement txtBody;
    @FindBy(xpath="//button[@data-test-id='compose-send-button']")
    private WebElement btnSubmit;

    public Create(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //set To field
    public void setRecipient(String recipient){
        txtTo.sendKeys(recipient);
    }

    //set Subject field
    public void setSubject(String subject){
        txtSubject.click();
        txtSubject.sendKeys(subject);
    }

    //set Body field
    public void setBody(String body){
        txtEdit.click();
        txtBody.sendKeys(body);
    }

    //Click Submit button
    public void clickSubmit(){
        btnSubmit.click();
    }

}

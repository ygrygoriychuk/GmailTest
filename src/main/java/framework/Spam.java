package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Spam {

    WebDriver driver;

    @FindBy(xpath="//span[@data-test-id='message-subject']")
    WebElement firstLetter;
    @FindBy(xpath="//div[@data-test-id='message-view-body-content']")
    WebElement txtBodyContent;

    public Spam(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //get body content
    public String getBodyContent(){
        return txtBodyContent.getText();
    }

    //Open first letter
    public void openFirstLetter(){
        firstLetter.click();
    }

}

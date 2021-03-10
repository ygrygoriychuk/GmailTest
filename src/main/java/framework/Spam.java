package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Spam {

    private WebDriver driver;

    @FindBy(xpath="//span[@data-test-id='message-subject']")
    private WebElement firstLetter;
    @FindBy(xpath="//div[@data-test-id='message-view-body-content']")
    private WebElement txtBodyContent;
    @FindBy(xpath="//div[@data-test-id='virtual-list-container'/div]")
    private WebElement mailContainer;

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

    //get data-test-id value
    public String getDataTestId(){
        return mailContainer.getAttribute("data-test-id");
    }

}

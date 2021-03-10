package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {

    private Properties properties;
    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"signin-main\"]/div[1]/a[2]/span")
    private WebElement btnSignIn;
    @FindBy(id="login-username")
    private WebElement txtUsername;
    @FindBy(id="login-passwd")
    private WebElement txtPassword;
    @FindBy(id="login-signin")
    private WebElement btnNext;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\configs\\credentials.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //Set user name in textbox
    private void setUserName(){
//            txtUsername.sendKeys(properties.getProperty("login"));
        txtUsername.sendKeys("yhryhoriychuk@yahoo.com");
    }

    //Set password in password textbox
    private void setPassword(){
//        txtPassword.sendKeys(properties.getProperty("password"));
        txtPassword.sendKeys("y19021984");
    }

    //Click on login button
    private void clickSignIn(){
        btnSignIn.click();
    }

    //Click on next button
    private void clickNext(){
        btnNext.click();
    }

    public void loginYahooMail() {
        clickSignIn();
        setUserName();
        clickNext();
        setPassword();
        clickNext();
    }

}

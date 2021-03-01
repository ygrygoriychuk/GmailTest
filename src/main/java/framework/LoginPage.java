package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {

    Properties properties;
    WebDriver driver;

    @FindBy(xpath="//*[@id=\"signin-main\"]/div[1]/a[2]/span")
    WebElement btnSignIn;
    @FindBy(id="login-username")
    WebElement txtUsername;
    @FindBy(id="login-passwd")
    WebElement txtPassword;
    @FindBy(id="login-signin")
    WebElement btnNext;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir")+"\\configs\\Configuation.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //Set user name in textbox
    public void setUserName(){
            txtUsername.sendKeys(properties.getProperty("login"));
    }

    //Set password in password textbox
    public void setPassword(){
        txtPassword.sendKeys(properties.getProperty("password"));
    }

    //Click on login button
    public void clickSignIn(){
        btnSignIn.click();
    }

    //Click on next button
    public void clickNext(){
        btnNext.click();
    }

}

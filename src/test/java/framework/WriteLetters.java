package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WriteLetters {

    private static final Logger logger = LogManager.getLogger(YahooTest.class);
    protected WebDriver driver;
    private LoginPage login;
    private LeftPanel leftPanel;
    private Inbox inbox;
    private Spam spam;
    private Create create;

    public WriteLetters() {
    }

    @BeforeMethod
    @Parameters({ "browserName" })
    public void setup(String browserName) {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://mail.yahoo.com");
    }

    @Test
    public void writeLetters() {
        login = new LoginPage(driver);
        login.loginYahooMail();
        writeLetter("yhryhoriychuk@yahoo.com", "Hello!", "Hello!");
        writeLetter("yhryhoriychuk@yahoo.com", "Hello Body!", "Hello!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }

    public void writeLetter(String recipient, String subject, String body) {
        leftPanel = new LeftPanel(driver);
        leftPanel.clickCreate();
        create = new Create(driver);
        create.setRecipient(recipient);
        create.setSubject(subject);
        create.setBody(body);
        create.clickSubmit();
    }

}

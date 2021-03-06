package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YahooTest {

    private static final Logger logger = LogManager.getLogger(YahooTest.class);
    protected WebDriver driver;
    private LoginPage login;
    private LeftPanel leftPanel;
    private Inbox inbox;

    public YahooTest() {
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

    @Test(priority = 1)
    public void checkWrittenLetter() {
        login = new LoginPage(driver);
        login.loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickInbox();
        inbox = new Inbox(driver);
        inbox.openFirstLetter();

        logger.info(inbox.getBodyContent());
        Assert.assertEquals(inbox.getBodyContent(),"Hello!");
    }

    @Test(priority = 2)
    public void deleteLetter() {
        login = new LoginPage(driver);
        login.loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickInbox();
        inbox = new Inbox(driver);
        inbox.openFirstLetter();
        inbox.clickDelete();

        logger.info(inbox.getConfirmDeleteText());
        Assert.assertEquals(inbox.getConfirmDeleteText(),"Розмову видалено.");
     }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }

}


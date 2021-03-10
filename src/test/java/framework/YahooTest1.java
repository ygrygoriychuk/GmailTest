package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YahooTest1 {

    private static final Logger logger = LogManager.getLogger(YahooTest.class);
    protected WebDriver driver;
    private LoginPage login;
    private LeftPanel leftPanel;
    private Inbox inbox;
    private Spam spam;
    private Create create;

    public YahooTest1() {
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
    public void spamLetter() {
        login = new LoginPage(driver);
        login.loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickInbox();
        inbox = new Inbox(driver);
        inbox.openFirstLetter();
        inbox.moveToSpam();

        logger.info(inbox.getConfirmToSpamText());
        Assert.assertEquals(inbox.getConfirmToSpamText(),"Спам");
    }

    @Test(priority = 2)
    public void checkSpamLetter() {
        login = new LoginPage(driver);
        login.loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickSpam();
        spam = new Spam(driver);
        spam.openFirstLetter();

        logger.info(spam.getBodyContent());
        Assert.assertTrue(spam.getBodyContent().equals("Hello!"));
    }

    @AfterMethod(groups = { "functest", "functest1" })
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }

}

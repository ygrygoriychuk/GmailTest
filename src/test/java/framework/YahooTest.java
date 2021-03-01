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
    private Spam spam;
    private Create create;


    public YahooTest() {
    }


    @BeforeMethod(groups = { "functest", "functest1" })
    @Parameters({ "browserName" })
    public void setup(String browserName) {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://mail.yahoo.com");
    }

//    @Test(priority = 1)
//    public void writeLetters() {
//        loginYahooMail();
//        writeLetter("yhryhoriychuk@yahoo.com", "Hello!", "Hello!");
//        writeLetter("yhryhoriychuk@yahoo.com", "Hello Body!", "Hello!");
//    }

    @Test(priority = 2, groups = { "functest" })

    public void checkWrittenLetter() {
        loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickInbox();
        inbox = new Inbox(driver);
        inbox.openFirstLetter();

        logger.info(inbox.getBodyContent());

        Assert.assertEquals(inbox.getBodyContent(),"Hello!");
    }

    @Test(priority = 3, groups = { "functest" })
    public void deleteLetter() {
        loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickInbox();
        inbox = new Inbox(driver);
        inbox.openFirstLetter();
        inbox.clickDelete();
     }

    @Test(priority = 4, groups = { "functest1" })
    public void spamLetter() {
        loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickInbox();
        inbox = new Inbox(driver);
        inbox.openFirstLetter();
        inbox.moveToSpam();
    }

    @Test(priority = 5, groups = { "functest1" })
    public void checkSpamLetter() {
        loginYahooMail();
        leftPanel = new LeftPanel(driver);
        leftPanel.clickSpam();
        spam = new Spam(driver);
        spam.openFirstLetter();

        Assert.assertTrue(spam.getBodyContent().equals("Hello!"));
    }

    @AfterMethod(groups = { "functest", "functest1" })
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }

    }

    public void loginYahooMail() {
        login = new LoginPage(driver);
        login.clickSignIn();
        login.setUserName();
        login.clickNext();
        login.setPassword();
        login.clickNext();
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


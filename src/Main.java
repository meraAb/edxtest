import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by Mera on 01-06-2017.
 */
public class Main {

    private static WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/M.A/Downloads/Compressed/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.edx.org");
    }

    @Test
    public void testEdx() throws Exception {
        LoginEdx le = new LoginEdx(driver);
        le.login();

        CookiesEdx ce = le.cookies();
        assertTrue(ce.cookiesCheck());
        assertTrue(ce.deleteCookie());

        Hover hover = new Hover(driver);
        assertTrue(hover.testHover().equals("Courses by Subject"));

        Goback gb = new Goback(driver);
        assertTrue(gb.goBack().equals(driver.getTitle().toString()));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mera on 01-06-2017.
 */
public class LoginEdx {

    WebDriver driver;
    Wait<WebDriver> wait;

    public LoginEdx(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        // Fill simple Form and send (Log In)
        //xpath
        driver.findElement(By.xpath(".//*[@id='page']/header/div/div/div/div[3]/nav/a[1]")).click();
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("testSeleniummera@gmail.com");
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys("test@1234");
        //xpath
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.linkText("Explore courses")).click();
        //Reading the page title
        assertEquals("edX | Search", driver.getTitle());
        logout();
    }

    public void logout() {
        //LogOut
        //xpath
        driver.findElement(By.xpath("//*[@id=\"page\"]/header/div/div/div/div[3]/div/button")).click();
        //driver.findElement(By.cssSelector("button.dropdown")).click();
        driver.findElement(By.linkText("Sign Out")).click();
    }

    public CookiesEdx cookies() {
        return new CookiesEdx(driver);
    }
}

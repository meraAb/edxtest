import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.Set;

/**
 * Created by Mera on 02-06-2017.
 */
public class CookiesEdx {

    WebDriver driver;

    public CookiesEdx(WebDriver driver) {
        this.driver = driver;
    }
     // cookies manuplation create a cookie and ten delete it
    public boolean cookiesCheck() {
        Cookie name = new Cookie("cookiessample", "12345");
        driver.manage().addCookie(name);
        Cookie cookies= driver.manage().getCookieNamed("cookiessample");
        if(cookies != null) {
            return true;
        }
        return false;
    }

    public boolean deleteCookie() {
        driver.manage().deleteCookieNamed("cookiessample");
        Cookie cookieList = driver.manage().getCookieNamed("cookiessample");

        if(cookieList == null) {
            return true;
        }
        return false;
    }
}
